/* require imports*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/* UsuarioCadastro View*/
public class TipoFiltroView extends JFrame implements ActionListener{
   private JLabel lblNome;
   private JTextField txtNome;
   
   private JButton btnCadastrar;
   private JButton btnLimpar;
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btnCadastrar){
         //validar e cadastar
         if(txtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            TipoFiltro tipoFiltro = new TipoFiltro();
        
            tipoFiltro.setNome(txtNome.getText());
            tipoFiltro.insert();
            
            System.out.println("Se pa deu certo");
         }
      }
      else if(e.getSource() == btnLimpar){
         //limpar JTextField
      }
   }
   
   public TipoFiltroView(){
   
      super("Cadastro de Tipo de Perfil");
      
      JPanel painelDados = new JPanel(new GridLayout(8, 2));
      JPanel painel = new JPanel(new FlowLayout());
      
      lblNome = new JLabel("Nome:");
      txtNome = new JTextField(12);
            
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
