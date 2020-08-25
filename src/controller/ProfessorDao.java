/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.EstudanteDao.lista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estudante;
import model.Professor;
import model.Professor;

/**
 *
 * @author KPROGRAMMER
 */
public class ProfessorDao {
     File directorio=new File("C:\\Gestao");
     File bancoDados=new File("C:\\Gestao\\Professor.dat");
      
    
    //
    public void CaminhoPrincipal(){
      
      
        
        if(directorio.exists()){
           System.out.print("Direcorio OK!");
        }else{
            directorio.mkdir();
        }
        
        if(bancoDados.exists()){
           System.out.print("Banco de dados OK!");
           
        }else{
            try {
                bancoDados.createNewFile();
                
                ArrayList<Professor> lista=new ArrayList();
              //File bancoDados=new File("C:\\Gestao\\Professor.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
             

              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
      public int gerarID(){
      ArrayList<Estudante> lista=new ArrayList();
        
         lista= (ArrayList<Estudante>)lista().clone();
         
         return lista.get(lista.size()).getId()+1;
    }
      
     public static void create(Professor p){
        ArrayList<Professor> lista=new ArrayList();
        
         lista= (ArrayList<Professor>)lista().clone();
         lista.add(p);
        
          try {
              File bancoDados=new File("C:\\Gestao\\Professor.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public static void delete(int id){
        ArrayList<Professor> lista=new ArrayList();
        
         lista= (ArrayList<Professor>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getId()==id){
                lista.remove(i);
            }
        }
        
          try {
              File bancoDados=new File("C:\\Gestao\\Professor.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static void edit(int id,Professor p){
        ArrayList<Professor> lista=new ArrayList();
        
         lista= (ArrayList<Professor>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getId()==id){
                lista.remove(i);
                lista.add(p);
            }
        }
        
          try {
              File bancoDados=new File("C:\\Gestao\\Professor.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static  ArrayList<Professor> search(String nome){
        ArrayList<Professor> lista=new ArrayList();
         ArrayList<Professor> nova=new ArrayList();
         
         lista= (ArrayList<Professor>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getNome().startsWith(nome)){
                
                nova.add(lista.get(i));
            }
        }
          return nova;
    }
     
     public static  ArrayList<Professor> filtrar(String filtro){
        ArrayList<Professor> lista=new ArrayList();
         ArrayList<Professor> nova=new ArrayList();
         lista= (ArrayList<Professor>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getGrauAcademico().equals(filtro)){
                
                nova.add(lista.get(i));
            }
        }
          return nova;
    }
    
    public static ArrayList<Professor> lista(){
        ArrayList<Professor> lista=new ArrayList();
       
        
          try {
            
            FileInputStream readData = new FileInputStream("C:\\Gestao\\Professor.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista=(ArrayList<Professor>)os.readObject();
                   
             os.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          return lista;
        
    }
    
    public static void  listas(){
        
       
        
          try {
            
            FileInputStream readData = new FileInputStream("C:\\Gestao\\Professor.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              ArrayList<Professor> lista=(ArrayList<Professor>)os.readObject();
              
              os.close();
                  
              
            
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
    }
    
}
