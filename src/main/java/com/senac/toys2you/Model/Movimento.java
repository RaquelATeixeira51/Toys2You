/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Model;

/**
 *
 * @author raquel.ateixeira3
 */
public class Movimento {
    private int id;
    private double total;
    private int qtProduto;
    private Tipo tipo;

    public Movimento() {
    }

    public Movimento(int id, double total, int qtProduto, Tipo tipo) {
        this.id = id;
        this.total = total;
        this.qtProduto = qtProduto;
        this.tipo = tipo;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}
