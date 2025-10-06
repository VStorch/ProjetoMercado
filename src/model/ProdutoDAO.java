package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Equivale à classe Supermercado, contudo escolhi ProdutoDAO para manter a consistência com o restante do sistema */
public class ProdutoDAO {


    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setInt(3, produto.getQuantidade());
            statement.setDouble(4, produto.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setPreco(resultSet.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return produtos;
    }
}
