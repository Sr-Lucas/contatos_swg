/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public class Contato {
    private String codigo;
    private String nome;
    private String tipo;
    private boolean favorito; 
    private String celular;
    private String telefone;
    private String email;
    private String observacao;
    private String nomeEmpresa;
    private String cargoEmpresa;

    public Contato(String codigo, String nome, String tipo, boolean favorito, String celular, String email, String observacao, String nomeEmpresa, String cargoEmpresa, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.favorito = favorito;
        this.celular = celular;
        this.email = email;
        this.observacao = observacao;
        this.nomeEmpresa = nomeEmpresa;
        this.cargoEmpresa = cargoEmpresa;
        this.telefone = telefone;
    }

     public String getTelefone() {
        return telefone;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }
}
