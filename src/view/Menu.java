/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KPROGRAMMER
 */
public class Menu extends JFrame {
    
    
    public Menu(){
        
        initComponents();
    }
    
    public void initComponents(){
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1080,600));
        setVisible(true);
        setLocation(100,100); 
        
        JPanel mainPanel=new JPanel();
        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new GridLayout(1, 4));
        setContentPane(mainPanel);
        
        JPanel leftPanel=new JPanel();
        leftPanel.setBackground(new java.awt.Color(147, 199, 254));
         leftPanel.setSize(50, 600);
        leftPanel.setLayout(new GridLayout(3, 1));
        
           JPanel leftPanel1=new JPanel();
        leftPanel1.setBackground(new java.awt.Color(147, 199, 254));
         leftPanel1.setSize(50, 600);
        leftPanel1.setLayout(new FlowLayout((int) CENTER_ALIGNMENT));
        
        JPanel leftPanel2=new JPanel();
        leftPanel2.setBackground(new java.awt.Color(147, 199, 254));
        leftPanel2.setSize(50, 600);
        leftPanel2.setLayout(new GridLayout(3, 1,5,10));
        
         JButton jbConfig=new JButton("");
         JButton jbDepart=new JButton("Encerrar");
         JButton jbSair=new JButton("");
         
         jbConfig.setBackground(new java.awt.Color(65, 164, 117));
         jbConfig.setForeground(new java.awt.Color(255, 255, 255));
         jbConfig.setFocusable(false);
         
         jbDepart.setBackground(new java.awt.Color(65, 164, 117));
         jbDepart.setForeground(new java.awt.Color(255, 255, 255));
         jbDepart.setFocusable(false);
         
          jbSair.setBackground(new java.awt.Color(65, 164, 117));
         jbSair.setForeground(new java.awt.Color(255, 255, 255));
         jbSair.setFocusable(false);
         
         
         leftPanel2.add(jbConfig);
         leftPanel2.add(jbDepart);
         leftPanel2.add(jbSair);
         
        
        
        JPanel leftPanel3=new JPanel();
        leftPanel3.setBackground(new java.awt.Color(147, 199, 254));
        //leftPanel3.setSize(50, 600);
        leftPanel3.setLayout(new FlowLayout((int) CENTER_ALIGNMENT));
        
        
        leftPanel.add(leftPanel1);
       leftPanel.add(leftPanel2);
       leftPanel.add(leftPanel3);
       
         JPanel rightPanel=new JPanel();
         rightPanel.setBackground(new java.awt.Color(255, 255, 255));
         rightPanel.setLayout(new GridLayout(3, 1));
        
          JPanel rightPanelUp=new JPanel();
         rightPanelUp.setBackground(new java.awt.Color(255, 255, 255));
         
          JPanel rightPanelmiddle=new JPanel();
         rightPanelmiddle.setBackground(new java.awt.Color(255, 255, 255));
         rightPanelmiddle.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JButton jbPedidos=new JButton(new ImageIcon(getClass().getResource("/imgs/estudante.png")));
          jbPedidos.setBackground(new java.awt.Color(55, 164, 117));
          jbPedidos.setPreferredSize(new Dimension(230, 150));
          jbPedidos.setFocusable(false);
        
        
         rightPanelmiddle.add(jbPedidos);
         
          JPanel rightPaneldown=new JPanel();
         rightPaneldown.setBackground(new java.awt.Color(255, 255, 255));
         rightPaneldown.setBackground(new java.awt.Color(255, 255, 255));
         rightPaneldown.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JLabel jlPedidos=new JLabel("Estudantes");
         jlPedidos.setForeground(new java.awt.Color(0, 165, 0));
         jlPedidos.setFont(new Font(getFont().MONOSPACED, getFont().BOLD, 18));
         
          rightPaneldown.add(jlPedidos);
          
         
         
          
    
       
        
        rightPanel.add(rightPanelUp);
        rightPanel.add(rightPanelmiddle);
        rightPanel.add(rightPaneldown);
        
        JPanel middlePanel=new JPanel();
       middlePanel.setBackground(new java.awt.Color(255, 255, 255));
       middlePanel.setLayout(new GridLayout(3, 3));
       
       JPanel middlePanelUp=new JPanel();
         middlePanelUp.setBackground(new java.awt.Color(255, 255, 255));
         
          JPanel middlePanelmiddle=new JPanel();
         middlePanelmiddle.setBackground(new java.awt.Color(255, 255, 255));
         middlePanelmiddle.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JButton jbRelatorios=new JButton(new ImageIcon(getClass().getResource("/imgs/relatorio.png")));
          jbRelatorios.setBackground(new java.awt.Color(55, 164, 117));
          jbRelatorios.setPreferredSize(new Dimension(230, 150));
          jbRelatorios.setFocusable(false);
        
        
         middlePanelmiddle.add(jbRelatorios);
         
          JPanel middlePaneldown=new JPanel();
         middlePaneldown.setBackground(new java.awt.Color(255, 255, 255));
         middlePaneldown.setBackground(new java.awt.Color(255, 255, 255));
         middlePaneldown.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JLabel jlRelatorios=new JLabel("Estatísticas");
         jlRelatorios.setForeground(new java.awt.Color(0, 165, 0));
         jlRelatorios.setFont(new Font(getFont().MONOSPACED, getFont().BOLD, 18));
         
          middlePaneldown.add(jlRelatorios);
          
         
         
          
    
       
        
        middlePanel.add(middlePanelUp);
        middlePanel.add(middlePanelmiddle);
        middlePanel.add(middlePaneldown);
       
       JPanel lastPanel=new JPanel();
       lastPanel.setBackground(new java.awt.Color(255, 255, 255));
       lastPanel.setLayout(new GridLayout(3, 3));
        
       
          JPanel lastPanelUp=new JPanel();
         lastPanelUp.setBackground(new java.awt.Color(255, 255, 255));
         
          JPanel lastPaneUp=new JPanel();
         lastPaneUp.setBackground(new java.awt.Color(255, 255, 255));
         lastPaneUp.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JButton jbProfessores=new JButton(new ImageIcon(getClass().getResource("/imgs/professor.png")));
          jbProfessores.setBackground(new java.awt.Color(55, 164, 117));
          jbProfessores.setPreferredSize(new Dimension(230, 150));
          jbProfessores.setFocusable(false);
        
        
         lastPaneUp.add(jbProfessores);
         
          JPanel lastPaneldown=new JPanel();
         lastPaneldown.setBackground(new java.awt.Color(255, 255, 255));
         lastPaneldown.setBackground(new java.awt.Color(255, 255, 255));
         lastPaneldown.setLayout(new FlowLayout(FlowLayout.CENTER));
         
          JLabel jlProfessores=new JLabel("Professores");
         jlProfessores.setForeground(new java.awt.Color(0, 165, 0));
         jlProfessores.setFont(new Font(getFont().MONOSPACED, getFont().BOLD, 18));
         
          lastPaneldown.add(jlProfessores);
          
         
         
          
    
       
        
        lastPanel.add(lastPanelUp);
        lastPanel.add(lastPaneUp);
        lastPanel.add(lastPaneldown);
       
       
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(lastPanel);
        
        
        jbPedidos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              MenuEstudante menu=new  MenuEstudante();
       menu.setVisible(true);
           }
       });
        
        jbProfessores.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              MenuProfessor menu=new  MenuProfessor();
              menu.setVisible(true);
           }
       });
        
         jbRelatorios.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              MenuEstatistica menu=new  MenuEstatistica();
              menu.setVisible(true);
           }
       });
         
          jbDepart.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           System.exit(0);
          
                  
           }
       });
        pack();
        
        
    }
    
}
