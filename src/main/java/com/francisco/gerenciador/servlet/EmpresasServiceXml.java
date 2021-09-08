package com.francisco.gerenciador.servlet;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;
import com.thoughtworks.xstream.XStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServiceXml", value = "/empresas-xml")
public class EmpresasServiceXml extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Empresa> empresas = new Banco().getEmpresas();

        XStream xStream = new XStream();
        xStream.alias("empresa", Empresa.class);
        String xml = xStream.toXML(empresas);

        resp.setContentType("application/xml");
        resp.getWriter().print(xml);
    }
}
