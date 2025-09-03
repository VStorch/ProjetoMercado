package telas;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	
	// Telas da aplicação
	private TelaLogin telaIdent;
	
	// Constantes para nomear as telas
	public static final String LOGIN_PANEL = "Login";
	
	// Variável de estado, guarda o usuário logado
	private String currentUser;
	
	public Janela() {
		
	}
}
