package view;

import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaAdmin extends JPanel{
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JButton btnAdicionar, btnEditar, btnExcluir, btnSair;

    public TelaAdmin() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));
        setMinimumSize(new Dimension(400, 200));

        modeloTabela = new DefaultTableModel(
                new Object[] {"ID", "Nome", "Descrição", "Quantidade", "Preço"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 15 ,10));

        btnAdicionar = new JButton("Adicionar Produto");
        btnEditar = new JButton("Editar Produto");
        btnExcluir = new JButton("Excluir Produto");
        btnSair = new JButton("Sair");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnSair);

        add(scrollPane, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    public void atualizarTabela(List<Produto> produtos) {
        modeloTabela.setRowCount(0);
        for (Produto p : produtos) {
            modeloTabela.addRow(new Object[]{
                    p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getPreco()
            });
        }
    }

    public Integer getProdutoSelecionadoId() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) return null;
        return (Integer) modeloTabela.getValueAt(linha, 0);
    }
    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }
    public JButton getBtnEditar() {
        return btnEditar;
    }
    public JButton getBtnExcluir() {
        return btnExcluir;
    }
    public JButton getBtnSair() {
        return btnSair;
    }
}
