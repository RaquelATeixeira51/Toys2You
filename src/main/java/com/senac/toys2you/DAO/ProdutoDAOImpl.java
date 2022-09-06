package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;

public class ProdutoDAOImpl implements ProdutoDAO{
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
    public void insert(String urlConexao, Produto produto) {
        String sql = "INSERT INTO produto( fk_produto, qt_Produto) VALUES( ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(1, produto.getDescricao());
            preparedStatement.setString(2, produto.getTipo().name());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void update(String urlConexao, int id, String nome, String descricao, double valor, Tipo tipo,
            double tamanho, Date validade) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String urlConexao, int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<String> getNome(String urlConexao, String nomeProduto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getId(String urlConexao, int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
