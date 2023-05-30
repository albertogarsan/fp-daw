package com.example.biblioteca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private Double preu;
    @Column //És una foreign key
    private int idAutor;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Double getPreu() {
        return preu;
    }
    public void setPreu(Double preu) {
        this.preu = preu;
    }
    public int getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    
}
