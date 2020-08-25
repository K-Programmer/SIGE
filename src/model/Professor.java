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
public class Professor extends Pessoa {
  
    private String grauAcademico;

    public Professor(String grauAcademico, int id, String nome, String Genero) {
        super(id, nome, Genero);
        this.grauAcademico = grauAcademico;
    }

    public Professor(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    public Professor() {
    }

  

    
    
    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }
    
      @Override
    public String toString() {
        return "Professor{" + "grauAcademico=" + grauAcademico + '}';
    }
}
