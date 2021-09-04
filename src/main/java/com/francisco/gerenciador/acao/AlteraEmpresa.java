package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlteraEmpresa {

    @SuppressWarnings("SameReturnValue")
    public String executa(HttpServletRequest req) throws ServletException {

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println("ação altera empresa " + id);

        Date dataAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
