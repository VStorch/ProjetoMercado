package controller;

import model.UsuarioDAO;
import view.TelaLogin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginController {
    private final TelaLogin view;
    private final UsuarioDAO model;
    private final Navegador navegador;

    public LoginController(TelaLogin telaLogin, UsuarioDAO usuarioDAO, Navegador navegador) {
        this.view = telaLogin;
        this.model = usuarioDAO;
        this.navegador = navegador;

        this.view.cadastrar(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nome = view.getNome();
                String cpf = view.getCpf();
                String senha = view.getSenha();
            }
        });
    }
}
