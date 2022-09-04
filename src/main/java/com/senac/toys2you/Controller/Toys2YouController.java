/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Controller;

import java.util.List;

import com.senac.toys2you.DAO.UsuarioDAOImpl;
import com.senac.toys2you.Model.Usuario;

/**
 *
 * @author raquel.ateixeira3
 */
public class Toys2YouController {
    String urlConexao = "";

    public void AdicionaUsuario(Usuario usuario){
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        usuarioDAOImpl.insert(urlConexao, usuario);
    }

    public void alteraUsuario(String urlConexao, String login, String senha, int id){
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        usuarioDAOImpl.update(urlConexao, login, senha, id);
    }

    public List<String> buscaLogin(String urlConexao, String login, String senha) {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        List<String> r = usuarioDAOImpl.getLogin(urlConexao, login, senha);
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
}
