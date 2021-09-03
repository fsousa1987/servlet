package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("listando empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(req, resp);
    }
}
