package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.senac.toys2you.Model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
    private Connection connection;

    @Override
    public Connection connect(String urlConexao) {
        try{
            this.connection = DriverManager.getConnection(urlConexao);
            return connection;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void insert(String urlConexao, Usuario usuario) {
        String sql = "INSERT INTO usuario(id, login, senha) VALUES(?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, String login, String senha, int id) {
        String sql = "UPDATE usuario set login = ?, senha = ? where id = ?";

        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void getId(String urlConexao, int id) {
        String sql = "SELECT * FROM usuario WHERE id =" + id;

        try{
            Connection conexao = connect(urlConexao);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                System.out.println(resultado.getString("login"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
