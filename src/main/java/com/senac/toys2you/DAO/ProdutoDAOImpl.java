package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
        String sql = "INSERT INTO produto(DS_PRODUTO , VL_TOTAL, DS_DESCRICAO, TG_TIPO ) VALUES( ?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getValor());
            preparedStatement.setString(1, produto.getDescricao());
            preparedStatement.setString(2, produto.getTipo().name());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String urlConexao, int id, String nome, String descricao, double valor, Tipo tipo) {
        String sql = "UPDATE TB_PRODUTO set DS_PRODUTO = ?, VL_TOTAL = ? , DS_DESCRICAO = ? , TG_TIPO = ? where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, valor);
            preparedStatement.setString(3, descricao);
            preparedStatement.setString(4, tipo.name());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE * FROM TB_PRODUTO where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            
            preparedStatement.executeQuery();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> getNome(String urlConexao, String nomeProduto) {
        String sql = "SELECT * FROM TB_PRODUTO WHERE DS_PRODUTO=" + nomeProduto;
        List<String> l = new ArrayList<String>();

        try{
            Connection conexao = connect(urlConexao);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("DS_PRODUTO"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public List<String> getId(String urlConexao, int id) {
        String sql = "SELECT * FROM TB_PRODUTO WHERE PK_ID=" + id;
        List<String> l = new ArrayList<String>();

        try{
            Connection conexao = connect(urlConexao);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("PK_ID"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
}
