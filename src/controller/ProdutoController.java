package controller;

import model.Produto;
import model.ProdutoDAO;
import view.TelaCadProdutos;

public class ProdutoController {
    private final TelaCadProdutos view;
    private final ProdutoDAO model;
    private final Navegador navegador;

    public ProdutoController(TelaCadProdutos view, ProdutoDAO model, Navegador navegador) {
        this.view = view;
        this.model = model;
        this.navegador = navegador;

        this.view.cadastrar(e -> {
            String nome = view.getNome();
            String desc = view.getDesc();
            Integer quant = view.getQuant();
            Double preco = view.getPreco();

            if (!nome.equals("") && !desc.equals("") && quant != null && preco != null) {
                Produto produto = new Produto(null, nome, desc, quant, preco);
                this.model.adicionarProduto(produto);

                this.view.limparFormularios();
                this.view.exibirMensagem("Sucesso", "Cadastro do produto realizado", 1);
            } else {
                this.view.exibirMensagem("Erro", "Preencha todos os campos", 0);
            }
        });
    }
}
