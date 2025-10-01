package model;

import java.sql.*;

public class UsuarioDAO {

    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, cpf, senha, adm) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            if (usuario.isAdmin()) {
                statement.setString(3, usuario.getSenha());
            } else {
                statement.setNull(3, Types.VARCHAR);
            }
            statement.setBoolean(4, usuario.isAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void login(String nome, String cpf, String senha) {
        String sql = "SELECT * FROM usuarios where cpf = ?";
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {

        }
    }

    // Terminar CRUD conforme a necessidade

}
