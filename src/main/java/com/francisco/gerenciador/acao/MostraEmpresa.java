package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;

public class MostraEmpresa {

    @SuppressWarnings("SameReturnValue")
    public String executa(HttpServletRequest req) {
        System.out.println("mostrando dados da empresa");

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaPelaId(id);

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);

        return "forward:formAlteraEmpresa.jsp";
    }
}
