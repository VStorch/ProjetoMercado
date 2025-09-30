package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastro;

public class CadastroController {
    private final TelaCadastro view;
    private final UsuarioDAO model;
    private final Navegador navegador;

    public CadastroController(TelaCadastro view, UsuarioDAO model, Navegador navegador) {
        this.view = view;
        this.model = model;
        this.navegador = navegador;

        this.view.cadastrar(e -> {
            String nome = view.getNome();
            String cpf = view.getCpf();
            String senha =  view.getSenha();
            String senhaConf = view.getSenhaConf();
            boolean admin = view.isAdmin();

            if (!nome.equals("") && !cpf.equals("")) {
                if (senha.equals(senhaConf)){
                    Usuario usuario = new Usuario(null, nome, cpf, senha, admin);
                    this.model.adicionarUsuario(usuario);

                    this.view.limparFormularios();
                    this.view.exibirMensagem("Sucesso", "Cadastro realizado com sucesso!", 1);

                } else {
                    this.view.exibirMensagem("Erro", "Senhas diferentes", 0);
                }
            } else {
                this.view.exibirMensagem("Erro", "Preencha todos os campos", 0);
            }
        });


    }
}
