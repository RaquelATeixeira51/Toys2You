package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;

import com.senac.toys2you.Model.Movimento;
import com.senac.toys2you.Model.Venda;

public interface MovimentoDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Movimento movimento);
    public void delete(String urlConexao, int id);
    public void deleteVenda(String urlConexao, int id);
    public List<String> getMovimentoVenda(String urlConexao, int venda);
    public List<String> getVenda(String urlConexao, int venda);
    public void insertVenda(String urlConexao, Venda venda);

}
