package controller;

import model.PedidoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.TelaCompra;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CompraController {
    private TelaCompra telaCompra;
    private ProdutoDAO produtoDAO;
    private Usuario usuario;

    public CompraController(TelaCompra telaCompra, ProdutoDAO produtoDAO, Usuario usuario) {
        this.telaCompra = telaCompra;
        this.produtoDAO = produtoDAO;
        this.usuario = usuario;

        carregarProdutos();
        inicializarEventos();
    }

    private void inicializarEventos() {
        telaCompra.getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAoCarrinho();
            }
        });

        telaCompra.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerCarrinho();
            }
        });

        telaCompra.getBtnCarrinho().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });
    }

    private void carregarProdutos() {
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        telaCompra.atualizarTabela(produtos);
    }

    private void adicionarAoCarrinho() {
        int linhaSelecionada = telaCompra.getTabelaProdutos().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(telaCompra, "Selecione um produto para adicionar ao carrinho");
            return;
        }

        DefaultTableModel modeloProdutos = (DefaultTableModel) telaCompra.getTabelaProdutos().getModel();
        DefaultTableModel modeloCarrinho = telaCompra.getModeloCarrinho();

        int id = (int) modeloProdutos.getValueAt(linhaSelecionada, 0);
        String nome = (String) modeloProdutos.getValueAt(linhaSelecionada, 1);
        int quantidade = 1;
        double preco = (double) modeloProdutos.getValueAt(linhaSelecionada, 4);
        double subtotal = quantidade * preco;

        modeloCarrinho.addRow(new Object[]{id, nome, quantidade, preco, subtotal});
    }

    private void removerCarrinho() {
        int linhaSelecionada = telaCompra.getTabelaCarrinho().getSelectedRow();
        if (linhaSelecionada != -1) {
            telaCompra.getModeloCarrinho().removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(telaCompra, "Selecione um item para remover do carrinho");
        }
    }

    private void finalizarCompra() {
        DefaultTableModel modeloCarrinho = telaCompra.getModeloCarrinho();

        if (modeloCarrinho.getRowCount() == 0) {
            JOptionPane.showMessageDialog(telaCompra, "O carrinho está vazio!");
            return;
        }

        PedidoDAO pedidoDAO = new PedidoDAO();
        int pedidoId = PedidoDAO.criarPedido(usuario.getId());

        if (pedidoId == -1) {
            JOptionPane.showMessageDialog(telaCompra, "Erro ao criar o pedido");
            return;
        }

        double total = 0.0;

        for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
            int produtoId = (int) modeloCarrinho.getValueAt(i, 0);
            int quantidade = (int) modeloCarrinho.getValueAt(i, 2);
            double precoUnitario = (double) modeloCarrinho.getValueAt(i, 3);

            pedidoDAO.adicionarItemPedido(pedidoId, produtoId, quantidade, precoUnitario);
            pedidoDAO.atualizarEstoque(produtoId, quantidade);

            total += (quantidade * precoUnitario);
        }

        JOptionPane.showMessageDialog(telaCompra, "Compra finalizada com sucesso!\nTotal: R$ " + String.format("%.2f", total));

        modeloCarrinho.setRowCount(0);
        carregarProdutos();
    }
}
