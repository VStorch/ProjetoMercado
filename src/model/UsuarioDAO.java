package model;

import java.sql.*;
import java.util.Objects;

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

    public Usuario loginAdm(Usuario user) {
        String sql = "SELECT * FROM usuarios where cpf = ? AND adm = true";
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, user.getCpf());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String senhaBD = resultSet.getString("senha");
                if (Objects.equals(senhaBD, user.getSenha())) {
                    return new Usuario(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("cpf"),
                            resultSet.getString("senha"),
                            resultSet.getBoolean("adm")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return null;
    }

    public Usuario loginCliente(Usuario usuario) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ?";
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = BancoDeDados.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getCpf());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getBoolean("adm")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return null;
    }

    // Terminar CRUD conforme a necessidade

}
