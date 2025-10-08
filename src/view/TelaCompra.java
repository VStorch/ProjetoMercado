package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaCompra extends JPanel {
    private JTable tabelaProdutos, tabelaCarrinho;
    private DefaultTableModel modeloTabela;
    private JButton btnAdicionar, btnRemover, btnCarrinho;

    public TelaCompra() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(920, 400));

        modeloTabela = new DefaultTableModel(
                new Object[] {"ID", "Nome", "Descrição", "Quantidade", "Preço"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scrollPane1 = new JScrollPane(tabelaProdutos);

        tabelaCarrinho = new JTable(modeloTabela);
        JScrollPane scrollPane2 = new JScrollPane(tabelaCarrinho);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnAdicionar = new JButton("Adicionar Produto");
        btnRemover = new JButton("Remover produto");
        btnCarrinho = new JButton("Carrinho");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnCarrinho);

        add(scrollPane1, BorderLayout.WEST);
        add(scrollPane2, BorderLayout.EAST);
        add(painelBotoes, BorderLayout.SOUTH);
    }
}
