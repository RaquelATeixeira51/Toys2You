/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Tipo;

/**
 *
 * @author raquel.ateixeira3
 */
public interface ProdutoDAO {
    public Connection connect(String urlConexao);
    public void insert(String urlConexao, Produto produto);
    public void update(String urlConexao, int id, String nome, String descricao, double valor, Tipo tipo, double tamanho, Date validade );
    public void delete(String urlConexao, int id);
    public List<String> getNome(String urlConexao, String nomeProduto);
    public List<String> getId(String urlConexao, int id);
}
