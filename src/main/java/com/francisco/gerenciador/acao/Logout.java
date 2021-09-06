package com.francisco.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

    @Override
    public String executa(HttpServletRequest req) throws ServletException {
        HttpSession sessao = req.getSession();

//        sessao.removeAttribute("usuarioLogado");
        sessao.invalidate();

        return "redirect:entrada?acao=LoginForm";
    }
}
