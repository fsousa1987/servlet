package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServiceJson", value = "/empresas-json")
public class EmpresasServiceJson extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Empresa> empresas = new Banco().getEmpresas();

        Gson gson = new Gson();
        String json = gson.toJson(empresas);

        resp.setContentType("application/json");
        resp.getWriter().print(json);
    }
}
