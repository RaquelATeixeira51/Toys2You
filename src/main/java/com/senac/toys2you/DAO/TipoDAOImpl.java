package com.senac.toys2you.DAO;

import com.senac.toys2you.Model.Cliente;
import com.senac.toys2you.Model.Tipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoDAOImpl implements TipoDAO{
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
    public void insert(String urlConexao, String login, String senha, Tipo tipo) {
        String sql = "INSERT INTO TB_TIPO( DS_TIPO) VALUES( ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, tipo.getTipo());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, String login, String senha, int id, String tipo) {
        String sql = "UPDATE TB_TIPO set DS_TIPO = ? where pk_id = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, tipo);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE FROM TB_TIPO WHERE pk_id = ?";
        try{
            Connection conexaco = connect(urlConexao, login, senha);
            PreparedStatement pstm = conexaco.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.executeUpdate();

        } catch(SQLException e){
            System.out.println(e.getMessage());
       }
    }
    public List<Tipo> getAll(String urlConexao, String login, String senha, int id) {
        String sql = "SELECT * FROM TB_TIPO";
        List<Tipo> l = new ArrayList<Tipo>();

        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                Tipo novoObjeto = new Tipo();
                    novoObjeto.setId(resultado.getInt("PK_ID"));
                    novoObjeto.setTipo(resultado.getString("DS_NOME"));
                l.add(novoObjeto);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}

