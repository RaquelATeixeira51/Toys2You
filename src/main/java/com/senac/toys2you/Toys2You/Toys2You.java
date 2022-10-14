/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.senac.toys2you.Toys2You;

import com.senac.toys2you.Controller.Toys2YouController;
import com.senac.toys2you.Model.Usuario;

/**
 *
 * @author raquel.ateixeira3
 */
public class Toys2You {

    public static void main(String[] args) {
        Toys2YouController toys2YouController = new Toys2YouController();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("raquelat");
        usuario.setPassword("oioi");
        toys2YouController.adicionaUsuario(usuario);
    }
}
