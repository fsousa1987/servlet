package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao {

    @Override
    public String executa(HttpServletRequest req) throws ServletException {
        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

        Date dataAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        req.setAttribute("empresa", empresa.getNome());

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
