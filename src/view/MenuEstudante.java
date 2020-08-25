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
import model.Estudante;


/**
 *
 * @author KPROGRAMMER
 */
public class MenuEstudante extends JFrame{
    JTable table;
    JTextField nome;
    JComboBox genero,filtros;
    JTextField nota1;
    JTextField nota2;
    JTextField media;
    JTextField situacao;
    JTextField jtfPesquisa;
    JLabel id;
    JLabel idText;
    
    public MenuEstudante(){
        
        initComponents();
         DefaultTableModel modelo=(DefaultTableModel) table.getModel();
         table.setRowSorter(new TableRowSorter(modelo));
         readJTable();
    }
    public void readJTable(){
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
          
          //EstudanteDao ficheiro=new EstudanteDao();
          modelo.setNumRows(0);
          for (Estudante e : EstudanteDao.lista()) {
            modelo.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                e.getGenero(),
                e.getNota1(),
                e.getNota2(),
                e.getMedia(),
                e.getSituacao()
                
            
            
            });
        }
          
       }
    
    public void readJTableSearch(String estudante){
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
          //EstudanteDao ficheiro=new EstudanteDao();
          modelo.setNumRows(0);
          for (Estudante e : EstudanteDao.search(estudante)) {
            modelo.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                 e.getGenero(),
                e.getNota1(),
                e.getNota2(),
                e.getMedia(),
                e.getSituacao()
                
            
            
            });
        }
          
       }
     public void readJTableSearchBySituacao(String situacao){
         
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
        
          modelo.setNumRows(0);
          for (Estudante e : EstudanteDao.filtrar(situacao)) {
            modelo.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                e.getGenero(),
                e.getNota1(),
                e.getNota2(),
                e.getMedia(),
                e.getSituacao()
                
            
            
            });
        }
          
       }
    public void clean(){
        nome.setText("");
        
          nota1.setText("");
           nota2.setText("");
                      media.setText("");
            jtfPesquisa.setText("");
            idText.setText("");
             situacao.setText("");
             filtros.setModel(new DefaultComboBoxModel(new Object[]{"Todos","Dispensado","Aprovado","Excluido"}));
    }
    
      public void updates(){
           if(Double.parseDouble(media.getText())<10){
         situacao.setText("Excluido");   
        }
        if(Double.parseDouble(media.getText())>=10 &&Double.parseDouble(media.getText())<14){
         situacao.setText("Aprovado"); ;
        }
        if(Double.parseDouble(media.getText())>=14){
         situacao.setText("Dispensado");   
        }
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
        jPanel12.setLayout(new FlowLayout(FlowLayout.LEFT));
        
         JPanel jPanel13=new JPanel();
        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel jPanel14=new JPanel();
        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel jPanel15=new JPanel();
        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel jPanel16=new JPanel();
        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel jPanel17=new JPanel();
        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(new FlowLayout(FlowLayout.CENTER));

        
        jPanel12.add(new JLabel("Nome:    "));
        
        nome=new JTextField();
        nome.setPreferredSize(new Dimension(400, 30));
        jPanel12.add(nome);
        
        JButton jbPesquisar=new JButton("Pesquisar");
        jbPesquisar.setPreferredSize(new Dimension(100, 30));
        jbPesquisar.setBackground(new java.awt.Color(55, 164, 117));
        jbPesquisar.setForeground(new java.awt.Color(255,255,255));
        jPanel12.add(new JLabel("                   "));
        jPanel12.add(jbPesquisar);
        
        jtfPesquisa=new JTextField();
        jtfPesquisa.setPreferredSize(new Dimension(290, 30));
        jPanel12.add(jtfPesquisa);
        
       
        
        filtros=new JComboBox(new Object[]{"Todos","Dispensado","Aprovado","Excluido"});
        filtros.setPreferredSize(new Dimension(100, 30));
        jPanel12.add(filtros);
        
        jPanel13.add(new JLabel("Gênero :"));
        
         genero=new JComboBox(new Object[]{"M","F"});
        genero.setPreferredSize(new Dimension(400, 30));
        jPanel13.add(genero);
        
        jPanel14.add(new JLabel("Nota 1:   "));
        
         nota1=new JTextField();
       nota1.setPreferredSize(new Dimension(400, 30));
        jPanel14.add(nota1);
        
         jPanel14.add(new JLabel("  Nota 2:    "));
        
         nota2=new JTextField();
        nota2.setPreferredSize(new Dimension(400, 30));
        jPanel14.add(nota2);
        
      
         media=new JTextField();
         media.setPreferredSize(new Dimension(400, 30));
         media.setEditable(false);
         
         situacao=new JTextField();
         situacao.setPreferredSize(new Dimension(400, 30));
         situacao.setEditable(false);
         
        jPanel15.add(new JLabel("Média:   "));
        jPanel15.add(media);
        
        jPanel15.add(new JLabel("Situação:   "));
        jPanel15.add(situacao);
        
        id=new JLabel("   ID:");
        idText=new JLabel("");
        jPanel16.add(id);
        jPanel16.add(idText);
        
        JButton jbNovo=new JButton("Novo");
        jbNovo.setPreferredSize(new Dimension(100, 30));
        jbNovo.setBackground(new java.awt.Color(55, 164, 117));
        jbNovo.setForeground(new java.awt.Color(255,255,255));
        jPanel17.add(jbNovo);
        
          JButton jbEditar=new JButton("Editar");
        jbEditar.setPreferredSize(new Dimension(100, 30));
        jbEditar.setBackground(new java.awt.Color(55, 164, 117));
        jbEditar.setForeground(new java.awt.Color(255,255,255));
        jPanel17.add(jbEditar);
        
        JButton jbApagar=new JButton("Apagar");
        jbApagar.setPreferredSize(new Dimension(100, 30));
        jbApagar.setBackground(new java.awt.Color(55, 164, 117));
        jbApagar.setForeground(new java.awt.Color(255,255,255));
        jPanel17.add(jbApagar);
        
         JButton jbNormalizar=new JButton("Limpar");
        jbNormalizar.setPreferredSize(new Dimension(100, 30));
        jbNormalizar.setBackground(new java.awt.Color(55, 164, 117));
        jbNormalizar.setForeground(new java.awt.Color(255,255,255));
        jPanel17.add(jbNormalizar);
        
        
        //add to fields panel
        jPanel1.add(jPanel12);
        jPanel1.add(jPanel13);
        jPanel1.add(jPanel14);
        jPanel1.add(jPanel15);
        jPanel1.add(jPanel16);
        jPanel1.add(jPanel17);
        
        
        
        //Jtable Panel
       String[] colunas={"ID","Nome","Gênero","Nota 1","Nota 2","Média","Situação"};
        table=new JTable();
        table.setModel(new DefaultTableModel(colunas,ABORT));
        JScrollPane scroll=new JScrollPane(table);
        jPanel2.add(scroll);
        
        
        //add to main panel
       jPanel.add(jPanel1);
       jPanel.add(jPanel2);
        
       
       
       
       
       //Eventos
       
       jbNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              EstudanteDao estudanteDao=new EstudanteDao();
              Estudante es=new Estudante();
              if(!nome.getText().trim().equals("")){
                  
              
               if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
                
                  try {
                      if(!EstudanteDao.lista().isEmpty()){
                   es.setId(EstudanteDao.lista().get(EstudanteDao.lista().size()-1).getId()+1);
                      }else{
                       es.setId(EstudanteDao.lista().size()+1);   
                      }
                es.setNome(nome.getText().toUpperCase());
                es.setGenero(genero.getSelectedItem().toString());
                es.setNota1(Double.parseDouble(nota1.getText()));
                es.setNota2(Double.parseDouble(nota2.getText()));
                es.setMedia(Double.parseDouble(nota1.getText()),Double.parseDouble(nota2.getText()));
                es.setSituacao(es.getMedia());
                
               
                EstudanteDao.create(es);
                 JOptionPane.showConfirmDialog(null, "Salvo com sucesso","", JOptionPane.DEFAULT_OPTION, 1);
                   
                  } catch (Exception ex) {
                      
                       JOptionPane.showConfirmDialog(null, "Falha ao salvar","", JOptionPane.DEFAULT_OPTION, 1); 
                  }
                
                readJTable();
                clean();
              
                
            }else{
                   JOptionPane.showConfirmDialog(null, "Nome vazio","", JOptionPane.DEFAULT_OPTION, 1); 
              }
            
           
       }
        });
       
       jbApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                
                 if(table.getSelectedRow()!=-1){
                
                     try {
                      EstudanteDao.delete(Integer.parseInt(idText.getText()));   
                        JOptionPane.showConfirmDialog(null, "Apagado com sucesso","", JOptionPane.DEFAULT_OPTION, 1);   
                        
                     } catch (Exception ex) {
                           JOptionPane.showConfirmDialog(null, "Falha ao apagar","", JOptionPane.DEFAULT_OPTION, 1);   
                     }
                
                readJTable();
                clean();
              
                 }else{
                   JOptionPane.showConfirmDialog(null, "Nenhum aluno selecionado","", JOptionPane.DEFAULT_OPTION, 1);   
                 }   
            }
        });
       
       jbEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
               if(table.getSelectedRow()!=-1){
                   
                
               
                Estudante es=new Estudante();
                
                 if(nota1.equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.equals("")){
                 nota2.setText("0.0");
                }
                   try {
                 es.setId(Integer.parseInt(idText.getText()));
                es.setNome(nome.getText().toUpperCase());
                es.setGenero(genero.getSelectedItem().toString());
                es.setNota1(Double.parseDouble(nota1.getText()));
                es.setNota2(Double.parseDouble(nota2.getText()));
                es.setMedia(Double.parseDouble(nota1.getText()),Double.parseDouble(nota2.getText()));
                es.setSituacao(es.getMedia());
                EstudanteDao.edit(Integer.parseInt(idText.getText()),es);
                 JOptionPane.showConfirmDialog(null, "Editado com sucesso","", JOptionPane.DEFAULT_OPTION, 1); 
                   } catch (Exception ex) {
                      JOptionPane.showConfirmDialog(null, "Falha ao editar","", JOptionPane.DEFAULT_OPTION, 1);   
                   }
               
                readJTable();
                clean();
              
                
            }else{
              JOptionPane.showConfirmDialog(null, "Nenhum aluno selecionado","", JOptionPane.DEFAULT_OPTION, 1);      
            }
            }
        });
       
        jbPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                readJTableSearch(jtfPesquisa.getText().toUpperCase());
                clean();
              
                
            }
        });
        
        jbNormalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                readJTable();
                clean();
              
                
            }
        });
        
       table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); 
         
         idText.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
         nome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
         
         if(table.getValueAt(table.getSelectedRow(), 2).toString().equals("M")){
         genero.setSelectedIndex(0);    
         }else{
          genero.setSelectedIndex(1);
         }
        
         nota1.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        nota2.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
         media.setText(table.getValueAt(table.getSelectedRow(), 5).toString());   
         situacao.setText(table.getValueAt(table.getSelectedRow(), 6).toString()); 
                
            }
           
         
});
       
       nota1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
                try {
                  media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));   
                
                
                } catch (Exception ex) {
                }
                updates();
              
            }
             

            @Override
            public void keyPressed(KeyEvent e) {
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
            try {
                 media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));   
                } catch (Exception ex) {
                }
             updates();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
             try {
                  media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));      
                } catch (Exception ex) {
                }
              updates();
            }
        });
      
        nota2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
                try {
                  media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));      
                } catch (Exception ex) {
                }
                 updates();
              
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
            try {
                  media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));     
                } catch (Exception ex) {
                }
            updates();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(nota1.getText().equals("")){
                 nota1.setText("0.0");
                }
                 if(nota2.getText().equals("")){
                 nota2.setText("0.0");
                }
             try {
                  
                 media.setText(String.valueOf((Double.parseDouble(nota1.getText())+Double.parseDouble(nota2.getText()))/2));     
                 updates();
             } catch (Exception ex) {
                }
            }
        });
        
        filtros.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               
                switch(filtros.getSelectedItem().toString()){
                    case "Todos":
                         jtfPesquisa.setEditable(true);
                        readJTable();  break;   
                        
                        case "Dispensado":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchBySituacao(filtros.getSelectedItem().toString());
                    break;  
                    
                    case "Aprovado":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchBySituacao(filtros.getSelectedItem().toString());
                    break;   
                    
                    case "Excluido":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchBySituacao(filtros.getSelectedItem().toString());
                    break;  
                }
             
            }
        });
       
       jtfPesquisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               readJTableSearch(jtfPesquisa.getText().toUpperCase());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                readJTableSearch(jtfPesquisa.getText().toUpperCase());
            }

            @Override
            public void keyReleased(KeyEvent e) {
               readJTableSearch(jtfPesquisa.getText().toUpperCase());
            }
        });
       pack();
    }
    
}
