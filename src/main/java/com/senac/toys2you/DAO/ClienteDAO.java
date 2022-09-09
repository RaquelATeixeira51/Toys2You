package com.senac.toys2you.DAO;

import com.senac.toys2you.Model.Cliente;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface ClienteDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Cliente cliente);
    public void update(String urlConexao, int id, String nome, String cpf , int nrEndereco, String bairro, String cidade, int estado, int cep , int sexo, Date nascimento, int estCivil, String email, int telefone);
    public void delete(String urlConexao, int id);
    public List<String> getNome(String urlConexao, String nome);
    public List<String> getCpf(String urlConexao, String cpf);
}
