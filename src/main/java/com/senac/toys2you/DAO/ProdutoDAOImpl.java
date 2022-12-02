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
    public Connection connect(String urlConexao, String login, String senha) {
        try{
            this.connection = DriverManager.getConnection(urlConexao, login, senha);
            return connection;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void insert(String urlConexao, String login, String senha, Produto produto, int tipo) {
        String sql = "INSERT INTO tb_produto(DS_PRODUTO , VL_TOTAL, DS_DESCRICAO, TG_TIPO ) VALUES( ?, ?, ?, ?)";
        
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getValor());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, tipo);

            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String urlConexao, String login, String senha, String id, String nome, String descricao, double valor, Tipo tipo) {
        String sql = "UPDATE TB_PRODUTO set DS_PRODUTO = ?, VL_TOTAL = ? , DS_DESCRICAO = ? , TG_TIPO = ? where PK_ID = ?";

        
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, valor);
            preparedStatement.setString(3, descricao);
            preparedStatement.setInt(4,tipo.getId());
            preparedStatement.setString(5, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE * FROM TB_PRODUTO where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            
            preparedStatement.executeQuery();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Produto> getNome(String urlConexao, String login, String senha, String nomeProduto) {
        String sql = "SELECT * FROM TB_PRODUTO";
        List<Produto> l = new ArrayList<Produto>();
        if(nomeProduto != null){
            sql = "SELECT * FROM TB_PRODUTO WHERE DS_PRODUTO= '" + nomeProduto + "'";
        }

        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                    Produto novoObjeto = new Produto();
                    novoObjeto.setId(resultado.getString("PK_ID"));
                    novoObjeto.setNome(resultado.getString("DS_PRODUTO"));
                    novoObjeto.setValor(resultado.getDouble("VL_TOTAL"));
                    novoObjeto.setDescricao(resultado.getString("DS_DESCRICAO"));
                    
                    l.add(novoObjeto);            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public List<Produto> getId(String urlConexao, String login, String senha, String id) {
        String sql = "SELECT * FROM TB_PRODUTO";
        List<Produto> l = new ArrayList<Produto>();
        if(!id.isBlank()){
            sql = "SELECT * FROM TB_PRODUTO WHERE PK_ID=" + id;
        }

        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                 Produto novoObjeto = new Produto();
                    novoObjeto.setId(resultado.getString("PK_ID"));
                    novoObjeto.setNome(resultado.getString("DS_PRODUTO"));
                    novoObjeto.setValor(resultado.getDouble("VL_TOTAL"));
                    novoObjeto.setDescricao(resultado.getString("DS_DESCRICAO"));
                l.add(novoObjeto);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
}
