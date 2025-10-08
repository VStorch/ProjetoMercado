package controller;

import model.PedidoDAO;
import model.ProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCompra;
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

            if (cpf.isEmpty()) {
                view.exibirMensagem("Erro", "Informe o CPF", 0);
                return;
            }

            if (!senha.isEmpty()) {
                Usuario usuario = model.loginAdm(new Usuario(null, nome, cpf, senha, true));
                if (usuario != null) {
                    view.exibirMensagem("Boas-Vindas", "Seja bem-vindo! " + nome, 1);
                    view.limpar();
                    navegador.navegarPara("ADMIN");
                } else {
                    view.exibirMensagem("Erro", "Administrador não encontrado", 0);
                }
            } else {
                Usuario usuario = model.loginCliente(new Usuario(null, nome, cpf, null, false));
                if (usuario != null) {
                    view.exibirMensagem("Boas-Vindas", "Seja bem-vindo! " + nome, 1);

                    TelaCompra telaCompra = new TelaCompra();
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    CompraController compraController = new CompraController(telaCompra, produtoDAO, usuario, navegador);

                    view.limpar();
                    navegador.adicionarPainel("COMPRA", telaCompra);
                    navegador.navegarPara("COMPRA");
                } else {
                    view.exibirMensagem("Erro", "Cliente não encontrado", 0);

                }
            }
        });
    }
}
