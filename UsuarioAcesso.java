
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*class UsuarioCadastro*/
public class UsuarioAcesso extends Model{
   private int idUsuarioAcesso;
   private String nome;
   private String email;
   private String senha;
   private int idUsuarioCadastro;
   
   public String table = "usuarioCadastro";
   
   public UsuarioAcesso(){
   }
      
   /*public UsuarioCadastro(String table){
      super(table);
   }*/
   
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
   
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   public void setEmail(String email){
      this.email = email;
   }
     
   public String getEmail(){
      return this.email;
   }
   
   public void setSenha(String senha){
      this.senha = senha;
   }
     
   public String getSenha(){
      return this.senha;
   }
   
   public void setIdUsuarioCadastro(int idUsuarioCadastro){
      this.idUsuarioCadastro = idUsuarioCadastro;
   }
   
   public int getIdUsuarioCadastro(){
      return this.idUsuarioCadastro;
   }
   
   public void insert(){
      String query = "INSERT INTO usuarioAcesso (email, senha, usuarioCadastro_idUsuarioCadastro) VALUES (?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
           
          // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          // Date dtNascimento = format.parse(getDtNascimento());
           
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getEmail());
            stm.setString(2, getSenha());
            stm.setInt(3, getIdUsuarioCadastro());
            stm.execute();
         } 
         catch (Exception e) {
            e.printStackTrace();
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }   
         }
      }catch(Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }   
      }
   }  
   
   public void update(){
   
   }   
}


