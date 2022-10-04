package com.senac.toys2you.DAO;

import java.sql.Connection;

public interface LogDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, String log);
}
