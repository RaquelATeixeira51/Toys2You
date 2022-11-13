package com.senac.toys2you.DAO;

import com.senac.toys2you.Model.Tipo;
import java.sql.Connection;
import java.util.List;

public interface TipoDAO {
    public Connection connect(String urlConexao, String login, String senha);
    public void insert(String urlConexao, String login, String senha, Tipo tipo);
    public void update(String urlConexao, String login, String senha, int id, String tipo);
    public void delete(String urlConexao, String login, String senha, int id);
    public List<Tipo> getAll(String urlConexao, String login, String senha, int id);
}
