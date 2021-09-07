package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ControladorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("ControladorFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "com.francisco.gerenciador.acao." + paramAcao;

        String nome;
        try {
            Class<?> classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
            Acao acao = (Acao) classe.getConstructor().newInstance();
            nome = acao.executa(request);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        }
        else {
            response.sendRedirect(tipoEEndereco[1]);
        }
    }
}
