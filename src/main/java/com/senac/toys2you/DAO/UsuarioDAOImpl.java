package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.senac.toys2you.Model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
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
    public void insert(String urlConexao, String login, String senha, Usuario usuario) {
        String sql = "INSERT INTO usuario(id, login, senha) VALUES(?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getPassword());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, String login, String senha, int id, String email, String password) {
        String sql = "UPDATE usuario set login = ?, senha = ? where id = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public List<String> getLogin(String urlConexao, String login, String senha, String email, String password) {
        String sql = "SELECT * FROM usuario WHERE login=" + email + "AND DS_SENHA = " + password;
        List<String> l = new ArrayList<String>();

        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("email"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}
