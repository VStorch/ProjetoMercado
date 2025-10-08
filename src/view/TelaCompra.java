package view;

import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaCompra extends JPanel {
    private JTable tabelaProdutos, tabelaCarrinho;
    private DefaultTableModel modeloProdutos, modeloCarrinho;
    private JButton btnAdicionar, btnRemover, btnCarrinho;

    public TelaCompra() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(920, 400));

        modeloProdutos = new DefaultTableModel(
                new Object[] {"ID", "Nome", "Descrição", "Quantidade", "Preço"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloCarrinho = new DefaultTableModel(
                new Object[] {"ID", "Nome", "Quantidade", "Preço Unitário", "Subtotal"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaProdutos = new JTable(modeloProdutos);
        JScrollPane scrollPane1 = new JScrollPane(tabelaProdutos);

        tabelaCarrinho = new JTable(modeloCarrinho);
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

    public void atualizarTabela(List<Produto> produtos) {
        modeloProdutos.setRowCount(0);
        for (Produto p : produtos) {
            modeloProdutos.addRow(new Object[]{
                    p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getPreco()
            });
        }
    }

    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }
    public JTable getTabelaCarrinho() {
        return tabelaCarrinho;
    }
    public DefaultTableModel getModeloCarrinho() {
        return modeloCarrinho;
    }
    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }
    public JButton getBtnRemover() {
        return btnRemover;
    }
    public JButton getBtnCarrinho() {
        return btnCarrinho;
    }
}
