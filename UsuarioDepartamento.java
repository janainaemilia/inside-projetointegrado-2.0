
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

/*class UsuarioDepartamento*/
public class UsuarioDepartamento extends Model{
   private int idUsuarioAcesso;
   private int idDepartamento;
   
   public String table = "UsuarioDepartamento";
   
   public UsuarioDepartamento(){
   }
      
   /*public UsuarioDepartamento(String table){
      super(table);
   }*/
   
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
   
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
      public void setIdDepartamento(int idDepartamento){
      this.idDepartamento = idDepartamento;
   }
   
   public int getIdDepartamento(){
      return this.idDepartamento;
   }
   
   public void insert(){
      String query = "INSERT INTO usuarioAcesso_has_departamento ( usuarioAcesso_idUsuarioAcesso, departamento_idDepartamento) VALUES (?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
           
          // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          // Date dtNascimento = format.parse(getDtNascimento());
           
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, getIdUsuarioAcesso());
            stm.setInt(2, getIdDepartamento());            
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


