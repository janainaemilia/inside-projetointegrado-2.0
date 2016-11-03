/* require imports*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

/* UsuarioCadastro View*/
public class FiltroView extends JFrame implements ActionListener{
   private JLabel lblNome;
   private JTextField txtNome;
   private JLabel lblTipoFiltro;
   private JLabel lblTipoPerfil;
   private JComboBox cbTipoFiltro;
   private JComboBox cbTipoPerfil;
   
   private JButton btnCadastrar;
   private JButton btnLimpar;
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btnCadastrar){
         //validar e cadastar
         if(txtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            Filtro filtro = new Filtro();
        
            filtro.setNome(txtNome.getText());
            //filtro.setIdTipoFiltro(cbTipoFiltro.getText());
            //filtro.setIdTipoPerfil(cbTipoPerfil.getText());
            filtro.insert();
            
            System.out.println("Se pa deu certo");
         }
      }
      else if(e.getSource() == btnLimpar){
         //limpar JTextField
      }
   }
   
   public FiltroView(){
   
      super("Cadastro de Tipo de Perfil");
      
      JPanel painelDados = new JPanel(new GridLayout(8, 2));
      JPanel painel = new JPanel(new FlowLayout());
      
      lblNome = new JLabel("Nome:");
      txtNome = new JTextField(12);
      
      lblTipoFiltro = new JLabel("Tipo de Filtro:");
      
      TipoFiltro tipoFiltro = new TipoFiltro();
      ArrayList<TipoFiltro> tipoFiltros = tipoFiltro.selectAll();   
     
      //String[] array = filtros.toArray(new String[filtros.size()]);
      //cbTipoFiltro = new JComboBox(array);
      
      cbTipoFiltro = new JComboBox(tipoFiltros.toArray());
      
      btnCadastrar = new JButton("Cadastrar");
      btnLimpar = new JButton("Limpar");    
      
      painelDados.add(lblNome);
      painelDados.add(txtNome);          
   
      painelDados.add(btnLimpar);   
      painelDados.add(btnCadastrar);
                        
      painel.add(painelDados);
      
      Container caixa = getContentPane();
      caixa.setLayout(new BorderLayout());
      caixa.add(painel, BorderLayout.CENTER);
   
      btnCadastrar.addActionListener(this);
      btnLimpar.addActionListener(this);
      
      setSize(350,350);                  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);      
   
   }  
}
