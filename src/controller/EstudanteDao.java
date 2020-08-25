/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Estudante;

/**
 *
 * @author KPROGRAMMER
 */
public class EstudanteDao {
     File directorio=new File("C:\\Gestao");
     File bancoDados=new File("C:\\Gestao\\Estudante.dat");
      
    
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
                
                ArrayList<Estudante> lista=new ArrayList();
              //File bancoDados=new File("C:\\Gestao\\Estudante.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
             

              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EstudanteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public int gerarID(){
      ArrayList<Estudante> lista=new ArrayList();
        
         lista= (ArrayList<Estudante>)lista().clone();
         
         return lista.get(lista.size()).getId()+1;
    }
     public static void create(Estudante p){
        ArrayList<Estudante> lista=new ArrayList();
        
         lista= (ArrayList<Estudante>)lista().clone();
         lista.add(p);
        
          try {
              File bancoDados=new File("C:\\Gestao\\Estudante.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public static void delete(int id){
        ArrayList<Estudante> lista=new ArrayList();
        
         lista= (ArrayList<Estudante>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getId()==id){
                lista.remove(i);
            }
        }
        
          try {
              File bancoDados=new File("C:\\Gestao\\Estudante.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static void edit(int id,Estudante p){
        ArrayList<Estudante> lista=new ArrayList();
        
         lista= (ArrayList<Estudante>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getId()==id){
                lista.remove(i);
                lista.add(p);
            }
        }
        
          try {
              File bancoDados=new File("C:\\Gestao\\Estudante.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
              
              
              
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static  ArrayList<Estudante> search(String nome){
        ArrayList<Estudante> lista=new ArrayList();
         ArrayList<Estudante> nova=new ArrayList();
         
         lista= (ArrayList<Estudante>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getNome().startsWith(nome)){
                
                nova.add(lista.get(i));
            }
        }
          return nova;
    }
     
     public static  ArrayList<Estudante> filtrar(String filtro){
        ArrayList<Estudante> lista=new ArrayList();
         ArrayList<Estudante> nova=new ArrayList();
         lista= (ArrayList<Estudante>)lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getSituacao().equals(filtro)){
                
                nova.add(lista.get(i));
            }
        }
          return nova;
    }
     
      public static  double moda(){
        ArrayList<Estudante> lista=new ArrayList();
       
         lista= (ArrayList<Estudante>)lista().clone();
         
       double maxValue = 0;
int maxCount=0, i, j;
      for (i = 0; i < lista.size(); ++i) {
         int count = 0;
         for (j = 0; j < lista.size(); ++j) {
            if (lista.get(j).getMedia() == lista.get(i).getMedia())
            ++count;
         }

         if (count > maxCount) {
            maxCount = count;
            maxValue = lista.get(i).getMedia();
         }
      }
      return maxValue;
         
    }
    public static  double media(){
        ArrayList<Estudante> lista=new ArrayList();
       
         lista= (ArrayList<Estudante>)lista().clone();
         
       double media = 0;
       double sum=0;

      for (int i = 0; i < lista.size(); ++i) {
        
        sum+=lista.get(i).getMedia();
      }
      
      media= sum/(lista.size()-1);
      return media;
         
    }
    public static ArrayList<Estudante> lista(){
        ArrayList<Estudante> lista=new ArrayList();
       
        
          try {
            
            FileInputStream readData = new FileInputStream("C:\\Gestao\\Estudante.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista=(ArrayList<Estudante>)os.readObject();
                   
             os.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          return lista;
        
    }
    
    public static void  listas(){
        
       
        
          try {
            
            FileInputStream readData = new FileInputStream("C:\\Gestao\\Estudante.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              ArrayList<Estudante> lista=(ArrayList<Estudante>)os.readObject();
              
              os.close();
                  
              
            
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Estudante.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
    }
    
}
