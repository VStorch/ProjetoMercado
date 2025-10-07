package controller;

import model.Produto;
import model.ProdutoDAO;
import view.TelaAdmin;
import view.TelaCadProdutos;

import javax.swing.*;
import java.util.List;

public class ProdutoController {
    private final TelaCadProdutos telaCadProdutos;
    private final TelaAdmin telaAdmin;
    private final ProdutoDAO model;
    private final Navegador navegador;

    public ProdutoController(TelaCadProdutos telaCadProdutos, TelaAdmin telaAdmin, ProdutoDAO model, Navegador navegador) {
        this.telaCadProdutos = telaCadProdutos;
        this.telaAdmin = telaAdmin;
        this.model = model;
        this.navegador = navegador;

        this.telaCadProdutos.getBtnSalvar().addActionListener(e -> salvarProduto());
        this.telaCadProdutos.getBtnVoltar().addActionListener(e -> voltarTelaAdmin());

        this.telaAdmin.getBtnAdicionar().addActionListener(e -> navegador.navegarPara("CADASTRO_PRODUTO"));
        this.telaAdmin.getBtnEditar().addActionListener(e -> editarProduto());
        this.telaAdmin.getBtnExcluir().addActionListener(e -> excluirProduto());
    }

    public void carregarProdutos() {
        List<Produto> produtos = model.listarProdutos();
        telaAdmin.atualizarTabela(produtos);
    }

    private void salvarProduto() {
        String nome = telaCadProdutos.getNome();
        String desc = telaCadProdutos.getDesc();
        Integer quant = telaCadProdutos.getQuant();
        Double preco = telaCadProdutos.getPreco();

        if (!nome.equals("") && !desc.equals("") && quant != null && preco != null) {
            Produto produto = new Produto(null, nome, desc, quant, preco);
            this.model.adicionarProduto(produto);

            this.telaCadProdutos.limparFormularios();
            this.telaCadProdutos.exibirMensagem("Sucesso", "Cadastro do produto realizado", 1);
        } else {
            this.telaCadProdutos.exibirMensagem("Erro", "Preencha todos os campos", 0);
        }
    }

    private void voltarTelaAdmin() {
        navegador.navegarPara("ADMIN");
    }

    private void editarProduto() {
        Integer id = telaAdmin.getProdutoSelecionadoId();
        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selucione um produto para editar");
            return;
        }
        navegador.navegarPara("CADASTRO_PRODUTO");
    }

    private void excluirProduto() {
        Integer id = telaAdmin.getProdutoSelecionadoId();
        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para ser excluído");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            model.excluirProduto(id);
            carregarProdutos();
        }
    }
}
