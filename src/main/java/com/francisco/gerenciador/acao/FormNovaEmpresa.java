package com.francisco.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;

public class FormNovaEmpresa implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        return "forward:formNovaEmpresa.jsp";
    }
}
