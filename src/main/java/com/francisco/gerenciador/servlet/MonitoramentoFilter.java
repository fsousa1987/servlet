package com.francisco.gerenciador.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("MonitoramentoFilter");

        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        // executa a ação
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da ação " + acao + " -> " + (depois - antes));
    }
}
