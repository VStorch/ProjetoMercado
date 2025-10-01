package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

/** Equivale à classe Supermercado, contudo escolhi ProdutoDAO para manter a consistência com o restante do sistema */
public class ProdutoDAO {


    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement statement = null;
    }

}
