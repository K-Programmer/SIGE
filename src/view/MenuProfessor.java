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
public class MenuProfessor extends JFrame{
    JTable table;
    JTextField nome;
    JComboBox genero,grau,filtros;
    JTextField jtfPesquisa;
    JLabel id;
    JLabel idText;
    
    public MenuProfessor(){
        
        initComponents();
         DefaultTableModel modelo=(DefaultTableModel) table.getModel();
         table.setRowSorter(new TableRowSorter(modelo));
         readJTable();
    }
    public void readJTable(){
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
          
          //ProfessorDao ficheiro=new ProfessorDao();
          modelo.setNumRows(0);
          for (Professor e : ProfessorDao.lista()) {
            modelo.addRow(new Object[]{
                e.getId(),
                e.getNome(),
                e.getGenero(),
                e.getGrauAcademico()
                
            
            
            });
        }
          
       }
    
    public void readJTableSearch(String professor){
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
          //ProfessorDao ficheiro=new ProfessorDao();
          modelo.setNumRows(0);
          for (Professor e : ProfessorDao.search(professor)) {
            modelo.addRow(new Object[]{
                  e.getId(),
                e.getNome(),
                e.getGenero(),
                e.getGrauAcademico()
                
            
            
            });
        }
          
       }
     public void readJTableSearchByGrau(String grau){
         
          DefaultTableModel modelo=(DefaultTableModel) table.getModel();
        
          modelo.setNumRows(0);
          for (Professor e : ProfessorDao.filtrar(grau)) {
            modelo.addRow(new Object[]{
               e.getId(),
                e.getNome(),
                e.getGenero(),
                e.getGrauAcademico()
                
            
            
            });
        }
          
       }
    public void clean(){
        nome.setText("");
            jtfPesquisa.setText("");
            idText.setText("");
           
             filtros.setModel(new DefaultComboBoxModel(new Object[]{"Todos","Bacharel","Licenciatura","Mestrado","Doutorado"}));
            grau.setModel(new DefaultComboBoxModel(new Object[]{"Bacharel","Licenciatura","Mestrado","Doutorado"}));
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
        
       
        
        filtros=new JComboBox(new Object[]{"Todos","Bacharel","Licenciatura","Mestrado","Doutorado"});
        filtros.setPreferredSize(new Dimension(100, 30));
        jPanel12.add(filtros);
        
        jPanel13.add(new JLabel("Gênero :"));
        
         genero=new JComboBox(new Object[]{"M","F"});
        genero.setPreferredSize(new Dimension(400, 30));
        jPanel13.add(genero);
        
        jPanel14.add(new JLabel("Grau  :   "));
        
         grau=new JComboBox(new Object[]{"Bacharel","Licenciatura","Mestrado","Doutorado"});
         grau.setPreferredSize(new Dimension(400, 30));
         jPanel14.add(grau);
        
        
        
      
        
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
       String[] colunas={"ID","Nome","Gênero","Grau Acadêmico"};
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
              ProfessorDao professorDao=new ProfessorDao();
              Professor es=new Professor();
              if(!nome.getText().trim().equals("")){
                  
              
               
                
                  try {
                    if(!ProfessorDao.lista().isEmpty()){
                   es.setId(EstudanteDao.lista().get(ProfessorDao.lista().size()-1).getId()+1);
                      }else{
                       es.setId(ProfessorDao.lista().size()+1);   
                      }
                es.setNome(nome.getText().toUpperCase());
                es.setGenero(genero.getSelectedItem().toString());
               es.setGrauAcademico(grau.getSelectedItem().toString());
               
                professorDao.create(es);
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
                      ProfessorDao.delete(Integer.parseInt(idText.getText()));   
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
                   
               
                Professor es=new Professor();
                
              
                   try {
                 es.setId(Integer.parseInt(idText.getText()));
                es.setNome(nome.getText().toUpperCase());
                es.setGenero(genero.getSelectedItem().toString());
               es.setGrauAcademico(grau.getSelectedItem().toString());
                ProfessorDao.edit(Integer.parseInt(idText.getText()),es);
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
        
         switch(table.getValueAt(table.getSelectedRow(), 3).toString()){
             
             
                         case "Bacharel":
                         grau.setSelectedIndex(0); 
                         break;
                        case "Licenciatura":
                      grau.setSelectedIndex(1); 
                    break;  
                    
                    case "Mestrado":
                       grau.setSelectedIndex(2); 
                    break;   
                    
                    case "Doutorado":
                        grau.setSelectedIndex(3); 
                    break;  
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
                    case "Bacharel":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchByGrau(filtros.getSelectedItem().toString()); break;
                        
                        case "Licenciatura":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchByGrau(filtros.getSelectedItem().toString());
                    break;  
                    
                    case "Mestrado":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchByGrau(filtros.getSelectedItem().toString());
                    break;   
                    
                    case "Doutorado":
                        jtfPesquisa.setEditable(false);
                        readJTableSearchByGrau(filtros.getSelectedItem().toString());
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
