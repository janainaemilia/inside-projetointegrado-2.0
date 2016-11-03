/* require imports*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import org.jdesktop.swingx.JXDatePicker;


/* UsuarioCadastro View*/
public class UsuarioCadastroView extends JFrame implements ActionListener{
   private JLabel lblNome;
   private JTextField txtNome;
   
   private JLabel lblCpf;
   private JTextField txtCpf;
   
   private JLabel lblDtNascimento;
   //private JXDatePicker dpDtNascimento;
   private JTextField txtDtNascimento;
   
   private JLabel lblGenero;
   private JTextField txtGenero;
   
   private JLabel lblEndereco;
   private JTextField txtEndereco;
   
   private JLabel lblTipoIdentificacao;
   private JTextField txtTipoIdentificacao;
   
   private JLabel lblNumeroIdentificacao;
   private JTextField txtNumeroIdentificacao;
  
   
   private JButton btnCadastrar;
   private JButton btnLimpar;
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btnCadastrar){
         //validar e cadastar
         if(txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtDtNascimento.getText().isEmpty() || txtGenero.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtTipoIdentificacao.getText().isEmpty() || txtNumeroIdentificacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            UsuarioCadastro usuario = new UsuarioCadastro();
        
            usuario.setNome(txtNome.getText());
            usuario.setCpf(Integer.parseInt(txtCpf.getText()));
            usuario.setDtNascimento(txtDtNascimento.getText());
            usuario.setGenero(txtGenero.getText());
            usuario.setEndereco(txtEndereco.getText());
            usuario.setIdTipoIdentificacao(Integer.parseInt(txtTipoIdentificacao.getText()));
            usuario.setNumeroIdentificacao(Integer.parseInt(txtNumeroIdentificacao.getText()));
            usuario.setIdTipoIdentificacao(1);            
            usuario.insert();
            
            //last insert id
            //int insertId = usuario.insert();
            
            /*UsuarioAcesso usuarioAcesso = new UsuarioAcesso();
            usuarioAcesso.setIdUsuarioCadastro(1);
            usuarioAcesso.setEmail()*/
            
            System.out.println("Se pa deu certo");
         }
      }
      else if(e.getSource() == btnLimpar){
         //limpar JTextField
      }
   }
   
   public UsuarioCadastroView(){
   
      super("Cadastro de Usuário");
      
      JPanel painelDados = new JPanel(new GridLayout(8, 2));
      JPanel painel = new JPanel(new FlowLayout());
      
      lblNome = new JLabel("Nome:");
      txtNome = new JTextField(12);
      
      lblCpf = new JLabel("Cpf:");
      txtCpf = new JTextField(12);
      
      lblDtNascimento = new JLabel("Data de Nascimento:");
      txtDtNascimento = new JTextField(12);
      //dpDtNascimento = new JXDatePicker();
      //dpDtNascimento.setDate(Calendar.getInstance().getTime());
      //dpDtNascimento.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
      
      lblGenero = new JLabel("Genero:");
      txtGenero = new JTextField(12);
      
      lblEndereco = new JLabel("Endereço:");
      txtEndereco = new JTextField(12);
      
      lblTipoIdentificacao = new JLabel("Tipo de identificação:");
      txtTipoIdentificacao = new JTextField(12);
      
      lblNumeroIdentificacao = new JLabel("Número de Identificação:");
      txtNumeroIdentificacao = new JTextField(12);
      
      btnCadastrar = new JButton("Cadastrar");
      btnLimpar = new JButton("Limpar");    
      
      painelDados.add(lblNome);
      painelDados.add(txtNome); 
   
      painelDados.add(lblCpf);
      painelDados.add(txtCpf); 
      
      painelDados.add(lblDtNascimento);
//      painelDados.add(dpDtNascimento); 
      painelDados.add(txtDtNascimento);
          
      painelDados.add(lblGenero);
      painelDados.add(txtGenero);       
   
      painelDados.add(lblEndereco);
      painelDados.add(txtEndereco); 
      
      painelDados.add(lblTipoIdentificacao);
      painelDados.add(txtTipoIdentificacao);
      
      painelDados.add(lblNumeroIdentificacao);
      painelDados.add(txtNumeroIdentificacao);          
   
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
