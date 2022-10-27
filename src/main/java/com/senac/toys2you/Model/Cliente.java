package com.senac.toys2you.Model;

import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int sexo;
    private String dataNascimento;
    private int estadoCivil;
    private String email;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, int numero, String bairro, String cidade, String estado, String cep, int sexo, String dataNascimento, int estadoCivil, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
    }
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public int getSexo() {
        return sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
}
