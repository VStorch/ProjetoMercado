package model;

import java.sql.*;

public class PedidoDAO {

    public static int criarPedido(int usuarioId) {
        String sql = "INSERT INTO pedidos (usuario_id) VALUES (?)";
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int pedidoId = -1;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, usuarioId);
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pedidoId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return pedidoId;
    }

    public void adicionarItemPedido(int pedidoId, int produtoId, int quantidade, double precoUnitario) {
        String sql = "INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, pedidoId);
            statement.setInt(2, produtoId);
            statement.setInt(3, quantidade);
            statement.setDouble(4, precoUnitario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
    }

    public void atualizarEstoque(int produtoId, int quantidadeComprada) {
        String sql = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, quantidadeComprada);
            statement.setInt(2, produtoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
    }
}
