package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfSenha;

	private Janela janela;
	
	public TelaLogin(Janela janela) {
		
		setPreferredSize(new Dimension(500, 200));
		this.janela = janela;
		
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
		add(lblCpf);
		add(lblSenhaAd);
		add(txfNome);
		add(txfCpf);
		add(txfSenha);
		add(btnEntrar);

	}
}
