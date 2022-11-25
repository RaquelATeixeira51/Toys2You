package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;
import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;

public interface ProdutoDAO {
    public Connection connect(String urlConexao, String login, String senha);
    public void insert(String urlConexao, String login, String senha, Produto produto,int tipo);
    public void update(String urlConexao, String login, String senha, String id, String nome, String descricao, double valor, Tipo tipo );
    public void delete(String urlConexao, String login, String senha, int id);
    public List<Produto> getNome(String urlConexao, String login, String senha, String nomeProduto);
    public List<Produto> getId(String urlConexao, String login, String senha, String id);
}
