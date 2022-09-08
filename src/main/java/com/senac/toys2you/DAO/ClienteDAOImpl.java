package com.senac.toys2you.DAO;

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
    public void insert(String urlConexao, Cliente cliente) {
        String sql = "INSERT INTO TB_CLIENTE(DS_NOME , NR_CPF, NR_NUMEROEND, DS_BAIRRO, DS_CIDADE, TG_ESTADO, NR_CEP, TG_SEXO, DT_NASCIMENTO, TG_ESTCIVIL, DS_EMAIL, NR_TELEFONE) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // preparedStatement.setInt(1, estoque.getId());
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setDouble(2, cliente.getCpf());
            preparedStatement.setInt(3, cliente.getNumero());
            preparedStatement.setString(4, cliente.getCidade());
            preparedStatement.setInt(5, cliente.getEstado());
            preparedStatement.setInt(6, cliente.getCep());
            preparedStatement.setInt(7, cliente.getSexo());
            preparedStatement.setDate(8, (Date) cliente.getDataNascimento());
            preparedStatement.setInt(9, cliente.getEstadoCivil());
            preparedStatement.setString(10, cliente.getEmail());
            preparedStatement.setInt(11, cliente.getTelefone());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String urlConexao, int id, String nome, String cpf , int nrEndereco, String bairro, String cidade, int estado, int cep , int sexo, java.util.Date nascimento, int estCivil, String email, int telefone) {
        String sql = "UPDATE TB_PRODUTO set DS_NOME = ? , NR_CPF = ?, NR_NUMEROEND = ?, DS_BAIRRO = ?, DS_CIDADE = ?, TG_ESTADO = ?, NR_CEP = ?, TG_SEXO = ?, DT_NASCIMENTO = ?, TG_ESTCIVIL = ?, DS_EMAIL = ?, NR_TELEFONE = ? where PK_ID = ?";

        try{
            Connection conexao = connect(urlConexao);
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
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE * FROM TB_CLIENTE where PK_ID = ?";

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
    public List<String> getNome(String urlConexao, String nome) {
        String sql = "SELECT * FROM TB_CLIENTE WHERE DS_NOME=" + nome;
        List<String> l = new ArrayList<String>();

        try{
            Connection conexao = connect(urlConexao);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("DS_NOME"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public List<String> getCpf(String urlConexao, String cpf) {
        String sql = "SELECT * FROM TB_CLIENTE WHERE NR_CPF=" + cpf;
        List<String> l = new ArrayList<String>();

        try{
            Connection conexao = connect(urlConexao);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                l.add(resultado.getString("NR_CPF"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }

}
