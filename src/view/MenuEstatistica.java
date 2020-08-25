/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.EstudanteDao;
import controller.ProfessorDao;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.ABORT;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Professor;


/**
 *
 * @author KPROGRAMMER
 */
public class MenuEstatistica extends JFrame{
    JTable table;
    JTextField nome;
    JComboBox genero,grau,filtros;
    JTextField jtfPesquisa;
    JLabel id;
    JLabel idText;
    
    public MenuEstatistica(){
        
        initComponents();
         
        
    }
   
    
 
    
      public void updates(){
        
      }
    public void initComponents(){
        
     
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1080,600));
        setVisible(true);
        setLocation(100,100);
        
        
        
        JPanel jPanel=new JPanel();
        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setLayout(new GridLayout(2, 0));
        setContentPane(jPanel);
        
          //Panel de fields
        JPanel jPanel1=new JPanel();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new GridLayout(6, 0));
        
          //Panel de Jtable
         JPanel jPanel2=new JPanel();
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new GridLayout(1, 0));
        
        
      //Panels de fields
         JPanel jPanel12=new JPanel();
        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new FlowLayout(FlowLayout.CENTER));
        
         JPanel jPanel13=new JPanel();
        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
       jPanel13.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel jPanel14=new JPanel();
        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel jPanel15=new JPanel();
        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel jPanel16=new JPanel();
        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(BorderFactory.createTitledBorder(""));
        jPanel16.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel jPanel17=new JPanel();
        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(new FlowLayout(FlowLayout.CENTER));

       EstudanteDao estudanteDao=new EstudanteDao();
        DecimalFormat format = new DecimalFormat("0.00");
        
        jPanel12.add(new JLabel("Números de  estudantes:"+EstudanteDao.lista().size()));
        jPanel13.add(new JLabel("Números de  estudantes Dispensados:"+EstudanteDao.filtrar("Dispensado").size()));
        jPanel14.add(new JLabel("Números de  estudantes Aprovados:"+EstudanteDao.filtrar("Aprovado").size()));
        jPanel15.add(new JLabel("Números de  estudantes Excluidos:"+EstudanteDao.filtrar("Excluido").size()));
        jPanel16.add(new JLabel("Números de  estudantes Moda:"+format.format(EstudanteDao.moda())));
        jPanel17.add(new JLabel("Números de  estudantes Média :"+format.format(EstudanteDao.media())));
   
       
        
        
      
        
       
       
        
       
        
        //add to fields panel
        jPanel1.add(jPanel12);
        jPanel1.add(jPanel13);
        jPanel1.add(jPanel14);
        jPanel1.add(jPanel15);
        jPanel1.add(jPanel16);
        jPanel1.add(jPanel17);
        
        
     
        
        //add to main panel
       jPanel.add(jPanel1);
       jPanel.add(jPanel2);
        
       
       
       
       
       //Eventos

       pack();
    }
    
}
