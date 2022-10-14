package com.senac.toys2you.DAO;

import com.senac.toys2you.Model.Cliente;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface ClienteDAO {
    public Connection connect(String urlConexao, String login, String senha);
    public void insert(String urlConexao, String login, String senha, Cliente cliente);
    public void update(String urlConexao, String login, String senha, int id, String nome, String cpf , int nrEndereco, String bairro, String cidade, int estado, int cep , int sexo, Date nascimento, int estCivil, String email, int telefone);
    public void delete(String urlConexao, String login, String senha, int id);
    public List<String> getNome(String urlConexao, String login, String senha, String nome);
    public List<String> getCpf(String urlConexao, String login, String senha, String cpf);
}
