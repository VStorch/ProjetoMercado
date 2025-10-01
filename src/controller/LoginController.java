package controller;

import model.Usuario;
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
                navegador.navegarPara("CADASTRO");
            }
        });

        this.view.entrar(e -> {
            String nome = view.getNome();
            String cpf = view.getCpf();
            String senha = view.getSenha();
            boolean admin = false;
            if (!senha.isEmpty()) {
                admin = true;
            }
            Usuario usuario = new Usuario(null, nome, cpf, senha, admin);
            if (nome.isEmpty() || cpf.isEmpty()) {
                view.exibirMensagem("Erro", "Preencha todos os campos", 0);
            }
            else if (model.login(usuario)) {
                view.exibirMensagem("Boas-Vindas", "Seja bem-vindo!", 1);
                if (admin == true) {
                    navegador.navegarPara("ADMIN");
                } else {
                    navegador.navegarPara("COMPRA");
                }
            } else {
                view.exibirMensagem("Erro", "Usuário não encontrado", 0);
            }
        });
    }
}
