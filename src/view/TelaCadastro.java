package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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
	private JRadioButton btnAdmin;
	
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
		
		JLabel lblAdmin = new JLabel("Será administrador?");
		lblAdmin.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		txtNome = new JTextField();
		txtCpf = new JTextField();
		pwSenha = new JPasswordField();
		pwSenhaConf = new JPasswordField();
		btnAdmin = new JRadioButton();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		add(lblNome);
		add(txtNome);
		
		add(lblCpf);
		add(txtCpf);
		
//		add(lblSenha);
//		add(pwSenha);
//		
//		add(lblSenhaConf);
//		add(pwSenhaConf);
		
		add(lblAdmin);
		add(btnAdmin);
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(lblNome).
				addComponent(lblCpf).
				addComponent(lblAdmin)
			);
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(txtNome).
				addComponent(txtCpf).
				addComponent(btnAdmin).
				addComponent(btnCadastrar)
			);
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblNome).addComponent(txtNome)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblCpf).addComponent(txtCpf)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(lblAdmin).addComponent(btnAdmin)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar));
	}
}
