package com.senac.toys2you.DAO;

import com.senac.toys2you.Controller.Toys2YouController;
import com.senac.toys2you.Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{
    private Connection connection;

    Toys2YouController toy = new Toys2YouController(); 
    
    @Override
    public Connection connect(String urlConexao, String login, String senha) {
        try{
            this.connection = DriverManager.getConnection(urlConexao, login, senha);
            return connection;
        } catch(SQLException e){
            toy.logErro(e.getMessage());
            return null;
        }
    }
    
    @Override
    public void insert(String urlConexao, String login, String senha, Cliente cliente) {
        String sql = "INSERT INTO TB_CLIENTE(DS_NOME , NR_CPF, NR_NUMEROEND, DS_BAIRRO, DS_CIDADE, TG_ESTADO, NR_CEP, TG_SEXO, DT_NASCIMENTO, TG_ESTCIVIL, DS_EMAIL, NR_TELEFONE) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setDouble(2, cliente.getCpf());
            preparedStatement.setInt(3, cliente.getNumero());
            preparedStatement.setString(4, cliente.getCidade());
            preparedStatement.setInt(5, cliente.getEstado());
            preparedStatement.setInt(6, cliente.getCep());
            preparedStatement.setInt(7, cliente.getSexo());
            preparedStatement.setString(8,cliente.getDataNascimento());
            preparedStatement.setInt(9, cliente.getEstadoCivil());
            preparedStatement.setString(10, cliente.getEmail());
            preparedStatement.setInt(11, cliente.getTelefone());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            toy.logErro(e.getMessage());
        }
    }
    
    @Override
    public void update(String urlConexao, String login, String senha, int id, String nome, String cpf , int nrEndereco, String bairro, String cidade, int estado, int cep , int sexo, java.util.Date nascimento, int estCivil, String email, int telefone) {
        String sql = "UPDATE TB_PRODUTO set DS_NOME = ? , NR_CPF = ?, NR_NUMEROEND = ?, DS_BAIRRO = ?, DS_CIDADE = ?, TG_ESTADO = ?, NR_CEP = ?, TG_SEXO = ?, DT_NASCIMENTO = ?, TG_ESTCIVIL = ?, DS_EMAIL = ?, NR_TELEFONE = ? where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            //preparedStatement.setInt(3, endereco);
            preparedStatement.setInt(4, nrEndereco);
            preparedStatement.setString(5, bairro);
            preparedStatement.setString(6, cidade);
            preparedStatement.setInt(7, estado);
            preparedStatement.setInt(7, cep);
            preparedStatement.setInt(7, sexo);
            preparedStatement.setDate(8, (Date) nascimento);
            preparedStatement.setInt(9, estCivil);
            preparedStatement.setString(10, email);
            preparedStatement.setInt(11, telefone);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            toy.logErro(e.getMessage());
        }
        
    }

    @Override
    public void delete(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE * FROM TB_CLIENTE where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            
            preparedStatement.executeQuery();
        } catch(SQLException e){
            toy.logErro(e.getMessage());
        }
    }

    @Override
    public List<String> getClientes(String urlConexao, String login, String senha, String nome, String cpf){
        List<String> l = new ArrayList<String>();
        String sql = "SELECT * FROM TB_CLIENTE";
        
        if(nome != null && cpf == null || cpf.isEmpty()){
            sql = "SELECT * FROM TB_CLIENTE WHERE DS_NOME=" + nome;
        }else if(cpf != null && nome == null || nome.isEmpty()){
            sql = "SELECT * FROM TB_CLIENTE WHERE NR_CPF=" + cpf;
        }else{
            sql = "SELECT * FROM TB_CLIENTE WHERE NR_CPF=" + cpf + " AND DS_NOME=" + nome;
        }

        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("DS_NOME"));
            }
        } catch(SQLException e){
            toy.logErro(e.getMessage());
        }
        return l;
    }

}
