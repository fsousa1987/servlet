package com.francisco.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        HttpSession sessao = req.getSession();

        sessao.invalidate();

        return "redirect:entrada?acao=LoginForm";
    }
}
