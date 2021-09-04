package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ListaEmpresas implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        System.out.println("listando empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
