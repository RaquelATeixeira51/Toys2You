package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.senac.toys2you.Model.Estoque;
import com.senac.toys2you.Model.Produto;

public class EstoqueDAOImpl implements EstoqueDAO{

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
    public void insert(String urlConexao, String login, String senha, Estoque estoque) {
        String sql = "INSERT INTO tb_estoque( fk_produto, qt_Produto) VALUES( ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setInt(1, estoque.getProduto().getId());
            preparedStatement.setInt(2, estoque.getQtProduto());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, String login, String senha, int id, Produto produto, int qtProduto) {
        String sql = "UPDATE tb_estoque set fk_produto = ?, qt_estoque = ? where pk_id = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setInt(2, qtProduto);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE FROM tb_estoque WHERE pk_id = ?";
        try{
            Connection conexaco = connect(urlConexao, login, senha);
            PreparedStatement pstm = conexaco.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.executeUpdate();

        } catch(SQLException e){
            System.out.println(e.getMessage());
       }
    }

    @Override
    public List<String> getNomeProduto(String urlConexao, String login, String senha, String nomeProduto) {
        String sql = "SELECT * FROM tb_produto";
        if(nomeProduto != null){
            sql = "SELECT * FROM tb_produto WHERE DS_PRODUTO " + nomeProduto;
        }
        List<String> l = new ArrayList<String>();
        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("nomeProduto"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
}
