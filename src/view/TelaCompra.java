package view;

import model.Produto;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

public class TelaCompra extends JPanel {
    private JTable tabelaProdutos, tabelaCarrinho;
    private DefaultTableModel modeloProdutos, modeloCarrinho;
    private JButton btnAdicionar, btnRemover, btnCarrinho, btnSair;
    private JLabel lblTotal;

    public TelaCompra() {
        setLayout(new MigLayout("fill, wrap 2, insets 15", "[grow, fill] [grow, fill]", "[][grow, fill][]"));
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
        btnSair = new JButton("Sair");

        lblTotal = new JLabel("Total: R$ 0.00");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnCarrinho);
        painelBotoes.add(btnSair);
        painelBotoes.add(lblTotal);

        add(scrollPane1, "grow, push");
        add(scrollPane2, "grow, push, wrap");
        add(painelBotoes, "span 2, align center, growx, pushy");

        tabelaProdutos.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = tabelaProdutos.rowAtPoint(e.getPoint());
                int column = tabelaProdutos.columnAtPoint(e.getPoint());

                if (column == 2 && row >= 0) {
                    Object descricao = tabelaProdutos.getValueAt(row, column);
                    tabelaProdutos.setToolTipText(descricao.toString());
                } else {
                    tabelaProdutos.setToolTipText(null);
                }
            }
        });
    }

    public void atualizarTabela(List<Produto> produtos) {
        modeloProdutos.setRowCount(0);
        for (Produto p : produtos) {
            modeloProdutos.addRow(new Object[]{
                    p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getPreco()
            });
        }
    }

    public void atualizarTotal() {
        double total = 0.0;
        for(int i = 0; i < modeloCarrinho.getRowCount(); i++) {
            Object subtotalObj = modeloCarrinho.getValueAt(i, 4);
            if (subtotalObj instanceof Number) {
                total += ((Number) subtotalObj).doubleValue();
            }
        }
        lblTotal.setText(String.format("Total: R$ %.2f", total));
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
    public JButton getBtnSair() {
        return btnSair;
    }
}
