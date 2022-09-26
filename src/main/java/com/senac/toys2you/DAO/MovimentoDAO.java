package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;

import com.senac.toys2you.Model.Movimento;

public interface MovimentoDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Movimento movimento);
    public void delete(String urlConexao, int id);
    public List<String> getMovimentoL(String urlConexao, String login, String senha);
}
