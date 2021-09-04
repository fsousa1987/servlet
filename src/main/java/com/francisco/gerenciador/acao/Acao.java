package com.francisco.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Acao {

    String executa(HttpServletRequest req) throws ServletException;
}
