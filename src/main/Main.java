package main;

import controller.CadastroController;
import controller.Navegador;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastro;
import view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Janela janela = new Janela();
        Navegador navegador = new Navegador(janela);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        TelaLogin telaLogin = new TelaLogin();
        // Criar Login Controller

        TelaCadastro telaCadastro = new TelaCadastro();
        CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador);

        navegador.adicionarPainel("CADASTRO", telaCadastro);

        janela.setLocationRelativeTo(null);
		janela.setVisible(true);

        navegador.navegarPara("CADASTRO");
	}

}
