package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;

import com.senac.toys2you.Model.Movimento;
import com.senac.toys2you.Model.Venda;

public interface MovimentoDAO {
    public Connection connect(String urlConexao, String login, String senha);
    public void insert(String urlConexao, String login, String senha, Movimento movimento, int venda);
    public void delete(String urlConexao, String login, String senha, int id);
    public void deleteVenda(String urlConexao, String login, String senha, int id);
    public List<Movimento> getMovimentoVenda(String urlConexao, String login, String senha, int venda);
    public List<Venda> getVenda(String urlConexao, String login, String senha, int venda);
    public void insertVenda(String urlConexao, String login, String senha, Venda venda);

}
