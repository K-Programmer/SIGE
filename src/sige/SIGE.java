/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sige;

import controller.EstudanteDao;
import controller.ProfessorDao;
import view.Menu;
import view.MenuEstatistica;
import view.MenuEstudante;
import view.MenuProfessor;

/**
 *
 * @author KPROGRAMMER
 */
public class SIGE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EstudanteDao e=new EstudanteDao();
          ProfessorDao p=new ProfessorDao();
          e.CaminhoPrincipal();
          p.CaminhoPrincipal();
        Menu menu=new  Menu();
       menu.setVisible(true);
    }
    
}
