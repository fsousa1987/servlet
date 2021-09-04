package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UnicaEntradaServlet", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAcao = req.getParameter("acao");

        String nome = null;
        switch (paramAcao) {
            case "ListaEmpresas": {
                ListaEmpresas acao = new ListaEmpresas();
                nome = acao.executa(req);
                break;
            }
            case "RemoveEmpresa": {
                RemoveEmpresa acao = new RemoveEmpresa();
                nome = acao.executa(req);
                break;
            }
            case "MostraEmpresa": {
                MostraEmpresa acao = new MostraEmpresa();
                nome = acao.executa(req);
                break;
            }
            case "AlteraEmpresa": {
                AlteraEmpresa acao = new AlteraEmpresa();
                nome = acao.executa(req);
                break;
            }
            case "NovaEmpresa": {
                NovaEmpresa acao = new NovaEmpresa();
                nome = acao.executa(req);
                break;
            }
        }

        assert nome != null;
        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher(tipoEEndereco[1]);
            rd.forward(req, resp);
        }
        else {
            resp.sendRedirect(tipoEEndereco[1]);
        }
    }
}
