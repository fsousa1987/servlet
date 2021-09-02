package com.francisco.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(Banco.chaveSequencial++);
        empresa.setNome("Alura");

        Empresa empresa2 = new Empresa();
        empresa2.setId(Banco.chaveSequencial++);
        empresa2.setNome("Caelum");

        lista.add(empresa);
        lista.add(empresa2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.lista.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }

    public void removeEmpresa(Integer id) {
        lista.removeIf(emp -> emp.getId().equals(id));
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
        for (Empresa empresa : lista) {
            if (empresa.getId().equals(id)) {
                return empresa;
            }
        }
        return null;
    }
}
