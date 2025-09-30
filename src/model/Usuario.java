package model;

public class Usuario {
    private Integer id;
    private String nome, cpf, senha;
    private boolean admin;

    public Usuario(Integer id, String nome, String cpf, String senha, boolean admin) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }
    public boolean isAdmin() {
        return admin;
    }
}
