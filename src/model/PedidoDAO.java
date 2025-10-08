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
        String verificarSql = "SELECT quantidade FROM produtos WHERE id = ?";

        Connection conexao = null;
        PreparedStatement statementUpdate = null;
        PreparedStatement statementVerificar = null;

        try {
            conexao = BancoDeDados.conectar();
            statementUpdate = conexao.prepareStatement(sql);
            statementUpdate.setInt(1, quantidadeComprada);
            statementUpdate.setInt(2, produtoId);
            statementUpdate.executeUpdate();

            try {
                statementVerificar = conexao.prepareStatement(verificarSql);
                statementVerificar.setInt(1, produtoId);
                ResultSet rs = statementVerificar.executeQuery();
                if (rs.next()) {
                    int quantidadeAtual = rs.getInt("quantidade");
                    if (quantidadeAtual <= 0) {
                        desativarProduto(produtoId);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
    }

    public void desativarProduto(int id) {
        String sql = "UPDATE produtos SET ativo = FALSE WHERE id = ?";
        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
