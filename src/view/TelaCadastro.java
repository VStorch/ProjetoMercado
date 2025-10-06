package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class TelaCadastro extends JPanel {
	
	private JTextField txtNome, txtCpf;
	private JPasswordField pwSenha, pwSenhaConf;
	private JRadioButton btnAdmin;
    private JButton btnCadastrar;

	public TelaCadastro() {
		setPreferredSize(new Dimension(400, 200));

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
		
		btnCadastrar = new JButton("Cadastrar");
		
		add(lblNome);
		add(txtNome);
		
		add(lblCpf);
		add(txtCpf);
		
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
        layout.setHorizontalGroup(hGroup);
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
        layout.setVerticalGroup(vGroup);
	}

    public String getNome() {
        return this.txtNome.getText();
    }
    public String getCpf() {
        return this.txtCpf.getText();
    }
    public String getSenha() {
        return new String(this.pwSenha.getPassword());
    }
    public String getSenhaConf() {
        return new String(this.pwSenhaConf.getPassword());
    }
    public boolean isAdmin() {
        return this.btnAdmin.isSelected();
    }

    public void cadastrar(ActionListener actionListener) {
        this.btnCadastrar.addActionListener(actionListener);
    }

    public void pedirSenha(String titulo) {
        int option = JOptionPane.showConfirmDialog(this, pwSenha, titulo, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    public void pedirSenhaConf(String titulo) {
        int option = JOptionPane.showConfirmDialog(this, pwSenhaConf, titulo, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void exibirMensagem(String titulo, String mensagem, int tipoMensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipoMensagem);
    }

    public void limparFormularios() {
        this.txtNome.setText("");
        this.txtCpf.setText("");
    }
    public void senhasIncorretas() {
        this.pwSenha.setText("");
        this.pwSenhaConf.setText("");
    }
}
