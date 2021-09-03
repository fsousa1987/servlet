package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.acao.ListaEmpresas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnicaEntradaServlet", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAcao = req.getParameter("acao");

        if (paramAcao.equals("ListaEmpresas")) {
            ListaEmpresas acao = new ListaEmpresas();
            acao.executa(req, resp);
        }
        else if (paramAcao.equals("RemoveEmpresa")) {
            System.out.println("removendo empresa");
        }
        else if (paramAcao.equals("MostraEmpresa")) {
            System.out.println("mostrando dados da empresa");
        }
    }
}
