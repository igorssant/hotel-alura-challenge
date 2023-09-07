package br.com.alura.hotel.model;

public class Administrador {
    private Integer id;
    private String usuario;
    private String senha;

    public Administrador() {
    }

    public Administrador(String usuario) {
        this.usuario = usuario;
        this.senha = null;
    }

    public Administrador(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Administrador(Integer id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
