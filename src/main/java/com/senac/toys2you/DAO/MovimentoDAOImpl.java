package com.senac.toys2you.DAO;

import com.senac.toys2you.Controller.Toys2YouController;
import com.senac.toys2you.Model.Movimento;
import com.senac.toys2you.Model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovimentoDAOImpl implements MovimentoDAO{
    private Connection connection;
    Toys2YouController toy = new Toys2YouController();

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
    public void insert(String urlConexao, String login, String senha, Movimento movimento) {
        String sql = "INSERT INTO TB_MOVIMENTO( FK_PRODUTO, VL_TOTAL, QT_PRODUTO ) VALUES( ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, movimento.getProduto());
            preparedStatement.setDouble(2, movimento.getTotal());
            preparedStatement.setInt(3, movimento.getQtProduto());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void insertVenda(String urlConexao, String login, String senha, Venda venda) {
        String sql = "INSERT INTO TB_MOVIMENTO( FK_CLIENTE, FK_VENDEDOR, DS_ENDERECO, NR_ENDERECO, NR_CEP,DS_BAIRRO,DS_CIDADE,DS_ESTADO,DT_PAGAMENTO,DT_VENCIMENTO,QT_PARCELAS,NR_CARTAO, VL_TOTAL ) VALUES( ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?, ?)";
        
        try{
            Connection conexao = connect(urlConexao, login, senha);
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, venda.getCliente());
            preparedStatement.setInt(2, venda.getVendedor());
            preparedStatement.setString(3, venda.getEndEntrega());
            preparedStatement.setInt(4, venda.getNumEntrega());
            preparedStatement.setInt(5, venda.getCepEntrega());
            preparedStatement.setString(6, venda.getBairroEntrega());
            preparedStatement.setString(7, venda.getCidade());
            preparedStatement.setString(8, venda.getEstado());
            preparedStatement.setDate(9, (Date) venda.getDataPagamento());
            preparedStatement.setDate(10, (Date) venda.getVencimentoPagamento());
            preparedStatement.setInt(11, venda.getParcelas());
            preparedStatement.setInt(12, venda.getNumCartao());
            preparedStatement.setDouble(13, venda.getValorTotal());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE FROM TB_MOVIMENTO WHERE pk_id = ?";
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
    public void deleteVenda(String urlConexao, String login, String senha, int id) {
        String sql = "DELETE FROM TB_VENDA WHERE pk_id = ?";
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
    public List<Movimento> getMovimentoVenda(String urlConexao, String login, String senha, int venda) {
        String sql = "SELECT *,(VL_TOTAL * QT_PRODUTO) AS VL_SOMADO FROM TB_MOVIMENTO WHERE FK_VENDA =" + venda;
        List<Movimento> l = new ArrayList<String>();
        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                Movimento novoObjeto = new Movimento();
                novoObjeto.setId(resultado.getInt("PK_ID"));
                novoObjeto.setProduto(resultado.getInt("FK_PRODUTO"));
                novoObjeto.setQtProduto(resultado.getInt("QT_PRODUTO"));
                novoObjeto.setTotal(resultado.getDouble("VL_TOTAL"));
                novoObjeto.setSomado(resultado.getDouble("VL_SOMADO"));
                
                
                
                l.add(novoObjeto);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
    @Override
    public List<Venda> getVenda(String urlConexao, String login, String senha, int venda) {
        String sql = "SELECT VEN.*,CLI.DS_NOME "
                + "FROM TB_VENDA AS VEN "
                + "LEFT JOIN TB_CLIENTE AS CLI ON CLI.PK_ID = VEN.FK_CLIENTE";
        
        if (venda > 0){
            sql = sql +  "WHERE FK_VENDA =" + venda;
        }
        List<Venda> l = new ArrayList<Venda>();
        try{
            Connection conexao = connect(urlConexao, login, senha);
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while(resultado.next()){
                Venda novoObjeto = new Venda();
                novoObjeto.setId(resultado.getInt("PK_ID"));
                novoObjeto.setCliente(resultado.getInt("FK_CLIENTE"));
                novoObjeto.setVendedor(resultado.getInt("FK_VENDEDOR"));
                novoObjeto.setValorTotal(resultado.getDouble("VL_TOTAL"));
                novoObjeto.setCli(resultado.getString("DS_NOME"));
                novoObjeto.setDataPagamento(resultado.getDate("DT_PAGAMENTO"));
                
                
                
                l.add(novoObjeto);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
}
