package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;

import javax.servlet.http.HttpServletRequest;

public class RemoveEmpresa {

    @SuppressWarnings("SameReturnValue")
    public String executa(HttpServletRequest req) {
        System.out.println("ação removendo empresa");

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
