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

    public List<String> buscaLogin(String urlConexao, String login) {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.connect(urlConexao);

        List<String> r = usuarioDAOImpl.getLogin(urlConexao, login);
        return r;

    }
}
