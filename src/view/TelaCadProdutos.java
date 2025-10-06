package view;

import controller.ProdutoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadProdutos extends JPanel {
    private Janela janela;
    private ProdutoController controller;

    private JTextField txtNome, txtDesc, txtQuant, txtPreco;
    private JButton btnSalvar;

    public TelaCadProdutos() {
        setPreferredSize(new Dimension(400, 200));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lblNome = new JLabel("Digite o nome do produto: ");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel lblDesc = new JLabel("Digite a descrição produto: ");
        lblDesc.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel lblQuant = new JLabel("Digite a quantidade do produto: ");
        lblQuant.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel lblPreco = new JLabel("Digite o preço do produto: R$");
        lblPreco.setFont(new Font("Arial", Font.PLAIN, 12));

        txtNome = new JTextField();
        txtDesc = new JTextField();
        txtQuant = new JTextField();
        txtPreco = new JTextField();

        btnSalvar = new JButton("Cadastrar");

        add(lblNome);
        add(txtNome);

        add(lblDesc);
        add(txtDesc);

        add(lblQuant);
        add(txtQuant);

        add(lblPreco);
        add(txtPreco);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNome).
                addComponent(lblDesc).
                addComponent(lblQuant).
                addComponent(lblPreco)
        );
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(txtNome).
                addComponent(txtDesc).
                addComponent(txtQuant).
                addComponent(txtPreco).
                addComponent(btnSalvar)
        );
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(lblNome).addComponent(txtNome)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(lblDesc).addComponent(txtDesc)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblQuant).addComponent(txtQuant)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblPreco).addComponent(txtPreco)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnSalvar));
        layout.setVerticalGroup(vGroup);
    }

    public String getNome() {
        return this.txtNome.getText();
    }
    public String getDesc() {
        return this.txtDesc.getText();
    }
    public Integer getQuant() {
        return Integer.parseInt(txtQuant.getText());
    }
    public Double getPreco() {
        return Double.parseDouble(txtPreco.getText());
    }

    public void cadastrar(ActionListener actionListener) {
        this.btnSalvar.addActionListener(actionListener);
    }

    public void limparFormularios() {
        this.txtNome.setText("");
        this.txtDesc.setText("");
        this.txtQuant.setText("");
        this.txtPreco.setText("");
    }
    public void exibirMensagem(String titulo, String mensagem, int tipoMensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipoMensagem);
    }
}
