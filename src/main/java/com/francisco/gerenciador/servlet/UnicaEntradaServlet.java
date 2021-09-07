package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.acao.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UnicaEntradaServlet", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAcao = req.getParameter("acao");

        String nomeDaClasse = "com.francisco.gerenciador.acao." + paramAcao;

        String nome;
        try {
            Class<?> classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
            Acao acao = (Acao) classe.getConstructor().newInstance();
            nome = acao.executa(req);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(req, resp);
        }
        else {
            resp.sendRedirect(tipoEEndereco[1]);
        }
    }
}
