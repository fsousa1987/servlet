package com.francisco.gerenciador.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListaEmpresasServlet", value = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<ul>");

        for (Empresa empresa : lista) {
            out.println("<li>" + empresa.getNome() + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}
