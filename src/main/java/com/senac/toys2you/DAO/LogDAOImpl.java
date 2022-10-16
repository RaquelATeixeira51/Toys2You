package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAOImpl implements LogDAO {
    private Connection connection;

    @Override
    public Connection connect(String urlConexao, String login, String senha) {
        try{
            this.connection = DriverManager.getConnection(urlConexao, login, senha);
            return connection;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public void insert(String urlConexao, String login, String senha, String log) {
        String sql = "INSERT INTO tb_estoque( DS_ERRO) VALUES(" + log + ")";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
