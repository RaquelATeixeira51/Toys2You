/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.util.List;

import com.senac.toys2you.Model.Estoque;
import com.senac.toys2you.Model.Produto;
/**
 *
 * @author raquel.ateixeira3
 */
public interface EstoqueDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Estoque estoque);
    public void update(String urlConexao, int id, Produto produto, int qtProduto);
    public void delete(String urlConexao, int id);
    public List<String> getNomeProduto(String urlConexao, String nomeProduto);
}
