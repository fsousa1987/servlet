package com.francisco.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;

public class LoginForm implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        return "forward:formLogin.jsp";
    }
}
