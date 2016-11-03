
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class TipoIdentificacao*/
public class TipoIdentificacao extends Model{
   private int idTipoIdentificacao;
   private String nome;
   
   public String table = "tipoPerfil";
   
   public TipoIdentificacao(){}
   
   public TipoIdentificacao(String table){
      super(table);
   }
   
   public int getIdTipoIdentificacao(){
      return this.idTipoIdentificacao;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
      
   public void insert(){
      String query = "INSERT INTO tipoIdentificacao (nome) VALUES (?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
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


