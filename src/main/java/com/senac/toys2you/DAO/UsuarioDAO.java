/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;

import com.senac.toys2you.Model.Usuario;

/**
 *
 * @author raquel.ateixeira3
 */
public interface UsuarioDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Usuario usuario);
    public void update(String urlConexao, String login, String senha, int id);
    public List<String> getLogin(String urlConexao, String login);

}
