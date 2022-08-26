/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.toys2you.Model;

import java.util.Date;

/**
 *
 * @author raquel.ateixeira3
 */
public class Venda {
    private int id;
    private String endEntrega;
    private int numEntrega;
    private double valorTotal;
    private int formaPagamento;
    private int cepEntrega;
    private String bairroEntrega;
    private String cidade;
    private String estado;
    private Date dataPagamento;
    private Date vencimentoPagamento;
    private String parcelas;
    private int numCartao;

    public Venda() {
    }

    public Venda(int id, String endEntrega, int numEntrega, double valorTotal, int formaPagamento, int cepEntrega, String bairroEntrega, String cidade, String estado, Date dataPagamento, Date vencimentoPagamento, String parcelas, int numCartao) {
        this.id = id;
        this.endEntrega = endEntrega;
        this.numEntrega = numEntrega;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.cepEntrega = cepEntrega;
        this.bairroEntrega = bairroEntrega;
        this.cidade = cidade;
        this.estado = estado;
        this.dataPagamento = dataPagamento;
        this.vencimentoPagamento = vencimentoPagamento;
        this.parcelas = parcelas;
        this.numCartao = numCartao;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEndEntrega(String endEntrega) {
        this.endEntrega = endEntrega;
    }

    public void setNumEntrega(int numEntrega) {
        this.numEntrega = numEntrega;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setCepEntrega(int cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setVencimentoPagamento(Date vencimentoPagamento) {
        this.vencimentoPagamento = vencimentoPagamento;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    
    
    public int getId() {
        return id;
    }

    public String getEndEntrega() {
        return endEntrega;
    }

    public int getNumEntrega() {
        return numEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public int getCepEntrega() {
        return cepEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Date getVencimentoPagamento() {
        return vencimentoPagamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public int getNumCartao() {
        return numCartao;
    }
    
    
}
