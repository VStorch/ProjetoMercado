package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class TelaLogin extends JPanel {

	private JTextField txfNome;
	private JTextField txfCpf;
	private JPasswordField pwSenha;
    private JLabel lblCadastro;
    JButton btnEntrar;

	public TelaLogin() {
		setPreferredSize(new Dimension(400, 200));

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
		
		lblCadastro = new JLabel("Não possui cadastro? Clique aqui.");
		lblCadastro.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCadastro.setForeground(new Color(000, 000, 255));
		
		txfNome = new JTextField();
		txfCpf = new JTextField();
		pwSenha = new JPasswordField();
		
		btnEntrar = new JButton("Entrar");
		
		add(lblNome);
		add(txfNome);

		add(lblCpf);
		add(txfCpf);

		add(lblSenhaAd);
		add(pwSenha);
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
				addComponent(pwSenha).
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
				addComponent(pwSenha)
			);
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
				addComponent(lblCadastro).
				addComponent(btnEntrar)
			);
		layout.setVerticalGroup(vGroup);
	}

    public String getNome() {
        return txfNome.getText();
    }
    public String getCpf() {
        return txfCpf.getText();
    }
    public String getSenha() {
        return new String(this.pwSenha.getPassword());
    }

	public void limpar() {
		txfNome.setText("");
		txfCpf.setText("");
		pwSenha.setText("");
	}

    public void cadastrar(MouseAdapter mouseAdapter) {
        this.lblCadastro.addMouseListener(mouseAdapter);
    }

    public void entrar(ActionListener actionListener) {
        this.btnEntrar.addActionListener(actionListener);
    }

    public void exibirMensagem(String titulo, String mensagem, int tipoMensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipoMensagem);
    }
}
