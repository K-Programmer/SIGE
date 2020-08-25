/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KPROGRAMMER
 */
public class Estudante extends Pessoa {
 
 private double nota1;
 private double nota2;
 private double media;
private String situacao;
 

    public Estudante(double nota1, double nota2, double media) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public Estudante() {
        
    }

 
 
    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double n1,double n2) {
         
        this.media = (n1+n2)/2;
    }

    @Override
    public String toString() {
        return "Estudante{" + "nota1=" + nota1 + ", nota2=" + nota2 + ", media=" + media + ", situacao=" + situacao+'}';
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(double media) {
        
        if(media<10){
         situacao = "Excluido";   
        }
        if(media>=10 && media<14){
         situacao = "Aprovado";   
        }
        if(media>=14){
         situacao = "Dispensado";   
        }
      
    }
 
 
    
    
}
