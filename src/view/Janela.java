package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	
	// Telas da aplicação
	private TelaLogin telaLogin;
	private TelaCadastro telaCadastro;
	
	// Constantes para nomear as telas
	public static final String LOGIN_PANEL = "Login";
	public static final String CADASTRO_PANEL = "Cadastro";
	
	// Variável de estado, guarda o usuário logado
	private String currentUser;
	
	public Janela() {
		setTitle("Sistema de mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 370);
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		
		contentPane = new JPanel(cardLayout);
		contentPane.setPreferredSize(new Dimension(400, 200));
		
		// Instancia as telas
		telaLogin = new TelaLogin(this);
		telaCadastro = new TelaCadastro(this);
		
		// Adiciona as telas ao contentPane
		contentPane.add(telaLogin, LOGIN_PANEL);
		contentPane.add(telaCadastro, CADASTRO_PANEL);
		
		setContentPane(contentPane);
		
		mostrarTela(LOGIN_PANEL);
        // mostrarTela(CADASTRO_PANEL);

    }
	
	// Método genérico para trocar de tela
	public void mostrarTela(String panelName) {
		cardLayout.show(contentPane, panelName);
	}
	
	// Método chamado pelo LoginPanel para ir para a tela principal
	public void mostrarTelaPrincipal(String userName) {
		this.currentUser = userName;
		// telaPrincipal.updateWelcomeMessage(currentUser);
		// mostrarTela(MAIN_PANEL);
	}
}
