package com.francisco.gerenciador.acao;

import com.francisco.gerenciador.modelo.Banco;
import com.francisco.gerenciador.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest req) {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        System.out.println("Logando " + login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if (usuario != null) {
            System.out.println("Usuário existe");
            return "redirect:entrada?acao=ListaEmpresas";
        }
        else {
            return "redirect:entrada?acao=LoginForm";
        }
    }
}
