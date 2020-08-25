/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author KPROGRAMMER
 */
public class Pessoa implements Serializable{
    
private int id;
private String nome;
private String Genero;

    public Pessoa(int id, String nome, String Genero) {
        this.id = id;
        this.nome = nome;
        this.Genero = Genero;
    }

    public Pessoa() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", Genero=" + Genero + '}';
    }
   
    
}
