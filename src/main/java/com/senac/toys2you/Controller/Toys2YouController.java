/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Controller;

import java.util.List;
import java.sql.Date;
import java.util.InputMismatchException;

import com.senac.toys2you.DAO.ClienteDAOImpl;
import com.senac.toys2you.DAO.ProdutoDAOImpl;
import com.senac.toys2you.DAO.UsuarioDAOImpl;
import com.senac.toys2you.Model.Cliente;
import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;
import com.senac.toys2you.Model.Usuario;

/**
 *
 * @author raquel.ateixeira3
 */
public class Toys2YouController {
    String urlConexao = "";

    public void adicionaUsuario(Usuario usuario){
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        usuarioDAOImpl.insert(urlConexao, usuario);
    }

    public void alteraUsuario(String login, String senha, int id){
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        usuarioDAOImpl.update(urlConexao, login, senha, id);
    }

    public List<String> buscaLogin(String login, String senha) {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        List<String> r = usuarioDAOImpl.getLogin(urlConexao, login, senha);
        return r;

    }

    public void adicionaCliente(Cliente cliente){
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(urlConexao);

        clienteDAOImpl.insert(urlConexao, cliente);
    }

    public void alteraCliente(int id, String nome, String cpf , int nrEndereco, String bairro, String cidade, int estado, int cep , int sexo, Date nascimento, int estCivil, String email, int telefone){
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(urlConexao);

        clienteDAOImpl.update(urlConexao, id, nome, cpf, nrEndereco, bairro, cidade, estado, cep, sexo, nascimento, estCivil, email, telefone);
    }

    public void deletaCliente(int id){
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(urlConexao);

        clienteDAOImpl.delete(urlConexao, id);
    }

    public List<String> consultaCliente(String nome, String cpf){
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(urlConexao);

        if(nome!=null){
            List<String> r = clienteDAOImpl.getNome(urlConexao, nome);
            return r;
        }
        List<String> r = clienteDAOImpl.getCpf(urlConexao, cpf);
        return r;
    }

    public void adicionaProduto(Produto produto){
        ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
        produtoDAOImpl.connect(urlConexao);

        produtoDAOImpl.insert(urlConexao, produto);
    }

    public void alteraProduto(int id, String nome, String descricao, double valor, Tipo tipo ){
        ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
        produtoDAOImpl.connect(urlConexao);

        produtoDAOImpl.update(urlConexao, id, nome, descricao, valor, tipo);
    }

    public void deletaProduto(int id){
        ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
        produtoDAOImpl.connect(urlConexao);

        produtoDAOImpl.delete(urlConexao, id);
    }

    public List<String> ConsultaProduto(String nomeProduto, int id){
        ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
        produtoDAOImpl.connect(urlConexao);

        if(nomeProduto!=null){
            List<String> r = produtoDAOImpl.getNome(urlConexao, nomeProduto);
            return r;
        }

        List<String> r = produtoDAOImpl.getId(urlConexao, id);
        return r;
    }

    public String getUrl(){
        return urlConexao;
    }
    
    public static int somaDigitos(int numero) {
        if( numero < 9 ) {
            return numero;
        } else {
            return numero%10 + 1;
        }
    }
		
    public static boolean checkValidade(String numeroCartao) { 

        int somaPar=0;
        int somaImpar=0;
        int aux=0;

        //PARES
        for( int j=numeroCartao.length()-2; j>=0; j=j-2) {
            aux = Integer.parseInt(numeroCartao.charAt(j) + "");
            somaPar = somaPar + somaDigitos(aux*2);
        }

        //IMPARES
        for( int i=numeroCartao.length()-1; i>=0; i=i-2) {
            aux = Integer.parseInt(numeroCartao.charAt(i) + "");
            somaImpar = somaImpar + aux;			
        }

        if( (somaPar+somaImpar)%10 == 0 ) {
            return true;
        } else {
            return false;
        }

    }
	
    public static String checkBandeiraCartao (String numero1IdEmissor, String numero2IdEmissor) {
        if (numero2IdEmissor.equals("37")) {
            return "AMERICAN EXPRESS";
        } else if (numero2IdEmissor.equals("35")) {
            return "JCB";
        } else if (numero1IdEmissor.equals("4")) {
            return "VISA";
        } else if (numero1IdEmissor.equals("5")) {
            return "MASTER";
        } else if (numero1IdEmissor.equals("6")) {
            return "DISCOVER";
        } else {
            return "BANDEIRA NÃO IDENTIFICADA/INEXISTENTE";
        }
    }
    
    public String validarCartao(String numeroCartao){
        String bandeiraCartao = "";
        if(numeroCartao.length() >= 13 && numeroCartao.length() <= 16){
            boolean flag = this.checkValidade(numeroCartao);
            if(flag){
                bandeiraCartao = this.checkBandeiraCartao(numeroCartao.substring(0,1), numeroCartao.substring(0,2));
                return bandeiraCartao;
            }else{
                return "Cartão inválido";
            }
        }else{
            return "Número de cartão inválido";
        }
    }
    
    public static boolean ValidarCPF (String CPF) {
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
            
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

  
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
        
        public String LoginSupervisor(){
            String login = "Spy12345";
            return login;
        }
        
}
