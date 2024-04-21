package com.mercadinho.mercadinhoV2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.ArrayList;

@Entity
public class Usuario {

    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String senha;

    private ArrayList<ProductModel> Carrinho = new ArrayList<ProductModel>();

    Usuario() {
    }

    Usuario(String name, String senha) {

        this.name = name;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCarrinho(ProductModel p) {
        Carrinho.add(p);
    }

    public ArrayList<ProductModel> getCarrinho() {
        return Carrinho;
    }    

}