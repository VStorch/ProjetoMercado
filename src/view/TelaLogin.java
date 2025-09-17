package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfSenha;
	
	private Janela janela;
	
	public TelaLogin(Janela janela) {
		setPreferredSize(new Dimension(400, 200));
		this.janela = janela;
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(27, 63, 46, 14);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(27, 104, 46, 14);
		
		JLabel lblSenhaAd = new JLabel("Senha de administrador:");
		lblSenhaAd.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenhaAd.setBounds(27, 141, 142, 14);
		
		txfNome = new JTextField();
		txfNome.setBounds(70, 60, 253, 20);
		txfNome.setColumns(10);
		
		txfCpf = new JTextField();
		txfCpf.setColumns(10);
		txfCpf.setBounds(70, 101, 253, 20);
		
		txfSenha = new JTextField();
		txfSenha.setColumns(10);
		txfSenha.setBounds(171, 138, 152, 20);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(234, 295, 89, 23);
		
		add(lblNome);
		add(txfNome);

		add(lblCpf);
		add(txfCpf);

		add(lblSenhaAd);
		add(txfSenha);
		add(btnEntrar);
		
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().
				addComponent(lblNome).addComponent(lblCpf).
				addComponent(lblSenhaAd)
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
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnEntrar));
		layout.setVerticalGroup(vGroup);
	}
}
