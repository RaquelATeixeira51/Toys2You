/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Model;

/**
 *
 * @author raquel.ateixeira3
 */
public class Estoque {
    private int id;
    private Produto produto;
    private int qtProduto;

    public Estoque() {
    }

    public Estoque(int id, Produto produto, int qtProduto) {
        this.id = id;
        this.produto = produto;
        this.qtProduto = qtProduto;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }
    
    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtProduto() {
        return qtProduto;
    }
    
}
