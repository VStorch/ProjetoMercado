package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JPanel {

	private JTextField txfNome;
	private JTextField txfCpf;
	private JPasswordField txfSenha;
	
	private Janela janela;
	
	public TelaLogin() {
		setPreferredSize(new Dimension(400, 200));
		this.janela = janela;
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSenhaAd = new JLabel("Senha de administrador:");
		lblSenhaAd.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblCadastro = new JLabel("Não possui cadastro? Clique aqui.");
		lblCadastro.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblCadastro.setForeground(new Color(000, 000, 255));
		
		txfNome = new JTextField();
		txfCpf = new JTextField();
		txfSenha = new JPasswordField();
		
		JButton btnEntrar = new JButton("Entrar");
		
		add(lblNome);
		add(txfNome);

		add(lblCpf);
		add(txfCpf);

		add(lblSenhaAd);
		add(txfSenha);
		add(btnEntrar);
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(lblNome).
				addComponent(lblCpf).
				addComponent(lblSenhaAd).addComponent(lblCadastro)
			);
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(txfNome).
				addComponent(txfCpf).
				addComponent(txfSenha).
				addComponent(btnEntrar)
			);
		layout.setHorizontalGroup(hGroup);
		
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblNome).
				addComponent(txfNome)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblCpf).
				addComponent(txfCpf)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblSenhaAd).
				addComponent(txfSenha)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblCadastro).
				addComponent(btnEntrar)
			);
		layout.setVerticalGroup(vGroup);
	}
}
