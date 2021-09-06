package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ListaEmpresas implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        HttpSession sessao = req.getSession();
        if (sessao.getAttribute("usuarioLogado") == null) {
            return "redirect:entrada?acao=LoginForm";
        }

        System.out.println("listando empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
