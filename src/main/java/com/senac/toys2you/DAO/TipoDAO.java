/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.toys2you.DAO;

import com.senac.toys2you.Model.Tipo;
import java.sql.Connection;

/**
 *
 * @author rael.spaixao1
 */
public interface TipoDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Tipo tipo);
    public void update(String urlConexao, int id, String tipo);
    public void delete(String urlConexao, int id);
}
