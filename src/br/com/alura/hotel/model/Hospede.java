package br.com.alura.hotel.model;

import java.sql.Date;

public class Hospede {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String nacionalidade;
    private String telefone;
    private Integer reservaId;

    public Hospede() {
    }

    /**
     * @param nome
     */
    public Hospede(String nome) {
        this.nome = nome;
    }

    /**
     * @param nome
     * @param sobrenome
     */
    public Hospede(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    /**
     * @param nome
     * @param sobrenome
     * @param dataNascimento
     */
    public Hospede(String nome, String sobrenome, Date dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    /**
     * @param nome
     * @param sobrenome
     * @param dataNascimento
     * @param nacionalidade
     */
    public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    /**
     * @param nome
     * @param sobrenome
     * @param dataNascimento
     * @param nacionalidade
     * @param telefone
     */
    public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
    }

    /**
     * @param nome
     * @param sobrenome
     * @param dataNascimento
     * @param nacionalidade
     * @param telefone
     * @param reservaId
     */
    public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer reservaId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this. reservaId = reservaId;
    }

    /**
     * @param id Integer
     * @param nome String
     * @param sobrenome String
     * @param dataNascimento sql.Date
     * @param nacionalidade String
     * @param telefone String
     * @param reservaId Integer
     */
    public Hospede(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer reservaId) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reservaId = reservaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }
}
