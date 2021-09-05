package com.francisco.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println("Logando " + login);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
