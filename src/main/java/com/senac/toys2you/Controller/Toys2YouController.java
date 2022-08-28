/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Controller;

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
}
