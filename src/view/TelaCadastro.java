package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaCadastro extends JPanel {
	
	private JTextField txtNome;
	private JTextField txtCpf;
	private JPasswordField pwSenha;
	private JPasswordField pwSenhaConf;
	private JRadioButton buttonM;
	private JRadioButton buttonF;
	
	private Janela janela;
	
	public TelaCadastro(Janela janela) {
		setPreferredSize(new Dimension(400, 200));
		this.janela = janela;
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JLabel lblNome = new JLabel("Digite o seu nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblCpf = new JLabel("Digite o seu CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSenha = new JLabel("Digite a sua senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSenhaConf = new JLabel("Confirme a sua senha:");
		lblSenhaConf.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSexo = new JLabel("Selecione o seu sexo:");
		lblSexo.setFont(new Font("Calibri", Font.PLAIN, 12));
	}
}
