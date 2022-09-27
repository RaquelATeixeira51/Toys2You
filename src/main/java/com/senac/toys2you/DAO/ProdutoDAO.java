package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;
import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;

public interface ProdutoDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Produto produto,int tipo);
    public void update(String urlConexao, int id, String nome, String descricao, double valor, Tipo tipo );
    public void delete(String urlConexao, int id);
    public List<String> getNome(String urlConexao, String nomeProduto);
    public List<String> getId(String urlConexao, int id);
}
