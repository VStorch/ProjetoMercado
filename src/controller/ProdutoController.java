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
        try {
            String nome = telaCadProdutos.getNome();
            String desc = telaCadProdutos.getDesc();
            Integer quant = telaCadProdutos.getQuant();
            Double preco = telaCadProdutos.getPreco();

            if (nome.isEmpty() || desc.isEmpty()) {
                telaCadProdutos.exibirMensagem("Erro", "Preencha todos os campos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer id = telaCadProdutos.getProdutoId();

            if (id == null) {
                Produto novo = new Produto(null, nome, desc, quant, preco);
                model.adicionarProduto(novo);
                telaCadProdutos.exibirMensagem("Sucesso", "Produto  cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Produto atualizado = new Produto(id, nome, desc, quant, preco);
                model.atualizarProdutos(atualizado);
                telaCadProdutos.exibirMensagem("Sucesso", "Produto  atualizado com sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaCadProdutos.limparFormularios();
                voltarTelaAdmin();
            }

            telaCadProdutos.limparFormularios();
        } catch (Exception e) {
            telaCadProdutos.exibirMensagem("Erro", "Erro ao salvar produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void voltarTelaAdmin() {
        carregarProdutos();
        navegador.navegarPara("ADMIN");
    }

    private void editarProduto() {
        Integer id = telaAdmin.getProdutoSelecionadoId();
        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para editar");
            return;
        }
        Produto produto = model.buscarPorId(id);
        if (produto == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return;
        }

        telaCadProdutos.preencherFormulario(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getQuantidade(),
                produto.getPreco()
        );

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
