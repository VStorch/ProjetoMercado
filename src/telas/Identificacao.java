package telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Identificacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identificacao frame = new Identificacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Identificacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 426);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Identificação de Usuário");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(178, 11, 171, 21);
		contentPane.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 35, 537, 341);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(27, 63, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCpf.setBounds(27, 104, 46, 14);
		panel.add(lblCpf);
		
		JLabel lblSenhaAd = new JLabel("Senha de administrador:");
		lblSenhaAd.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenhaAd.setBounds(27, 141, 142, 14);
		panel.add(lblSenhaAd);
		
		txfNome = new JTextField();
		txfNome.setBounds(70, 60, 253, 20);
		panel.add(txfNome);
		txfNome.setColumns(10);
		
		txfCpf = new JTextField();
		txfCpf.setColumns(10);
		txfCpf.setBounds(70, 101, 253, 20);
		panel.add(txfCpf);
		
		txfSenha = new JTextField();
		txfSenha.setColumns(10);
		txfSenha.setBounds(171, 138, 152, 20);
		panel.add(txfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(234, 295, 89, 23);
		panel.add(btnEntrar);
	}
}
