/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Model;

import java.sql.Date;

/**
 *
 * @author raquel.ateixeira3
 */
public class Movimento {
    private int id;
    private int produto;
    private double total;
    private int qtProduto;
    private String tipo;
    private Date dataVenda;
    private double somado;

    public double getSomado() {
        return somado;
    }

    public void setSomado(double somado) {
        this.somado = somado;
    }

    public Movimento() {
    }

    public Movimento(int id, double total, int qtProduto, String tipo, Date dataVenda) {
        this.id = id;
        this.total = total;
        this.qtProduto = qtProduto;
        this.tipo = tipo;
        this.dataVenda = dataVenda;
    }    
    
    public int getProduto(){
        return produto;
    }
    
    
    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public int getQtProduto() {
        return qtProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setProduto(int produto) {
        this.produto = produto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
