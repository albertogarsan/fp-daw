package com.example.tutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//NOTES:
//@Entity - Amb entity, Java sap que esta classe s'ha de convertir en una taula de mySQL. Entitat = Taula
//Utilitza cadascun dels atributs per a una nova columna de la taula
//Tindrem una columna per cada atribut de la classe
//Les etiquetes sempre actuen sobre la següent línia que es troben a continuació.

@Entity
public class User {
  
    //Atributs = Columnes
    //L'atribut id és especial perquè té l'etiqueta @id i li diu a la taula que eixa columna és la primary key.
    //Apart, la segona etiqueta, s'encarrega de fer un autoincrement de la primary key.
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
  
    //Mètodes getters i setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}