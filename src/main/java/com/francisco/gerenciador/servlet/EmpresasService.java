package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasService", value = "/empresas")
public class EmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Empresa> empresas = new Banco().getEmpresas();

        String valor = req.getHeader("Accept");

        if (valor.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            String xml = xStream.toXML(empresas);

            resp.setContentType("application/xml");
            resp.getWriter().print(xml);
        }
        else if (valor.contains("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            resp.setContentType("application/json");
            resp.getWriter().print(json);
        }
        else {
            resp.setContentType("application/json");
            resp.getWriter().print("{\n" +
                    "   \"message\":\"no content\"\n" +
                    "}");
        }
    }
}
