package main;

import controller.*;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Janela janela = new Janela();
        Navegador navegador = new Navegador(janela);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        TelaLogin telaLogin = new TelaLogin();
        LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);

        TelaCadastro telaCadastro = new TelaCadastro();
        CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador);

        TelaCadProdutos telaCadProdutos = new TelaCadProdutos();
        TelaAdmin telaAdmin = new TelaAdmin();
        ProdutoController produtoController = new ProdutoController(telaCadProdutos, telaAdmin, produtoDAO, navegador);
        produtoController.carregarProdutos();

        navegador.adicionarPainel("CADASTRO", telaCadastro);
        navegador.adicionarPainel("LOGIN", telaLogin);
        navegador.adicionarPainel("CADASTRO_PRODUTO", telaCadProdutos);
        navegador.adicionarPainel("ADMIN", telaAdmin);

        janela.setLocationRelativeTo(null);
		janela.setVisible(true);

        navegador.navegarPara("LOGIN");
	}

}
