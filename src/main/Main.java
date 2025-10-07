package main;

import controller.CadastroController;
import controller.LoginController;
import controller.Navegador;
import controller.ProdutoController;
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

        TelaCompra telaCompra = new TelaCompra();
        // Implementar Controller da tela compra

        TelaCadProdutos telaCadProdutos = new TelaCadProdutos();
        ProdutoController produtoController = new ProdutoController(telaCadProdutos, produtoDAO, navegador);

        navegador.adicionarPainel("CADASTRO", telaCadastro);
        navegador.adicionarPainel("LOGIN", telaLogin);
        navegador.adicionarPainel("COMPRA", telaCompra);
        navegador.adicionarPainel("ADMIN", telaCadProdutos);

        janela.setLocationRelativeTo(null);
		janela.setVisible(true);

        navegador.navegarPara("LOGIN");
	}

}
