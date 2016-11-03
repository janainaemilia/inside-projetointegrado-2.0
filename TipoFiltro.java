
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class TipoPerfil*/
public class TipoFiltro extends Model{
   private int idTipoFiltro;
   private String nome;
   private String table = "tipoFiltro";
   
   public TipoFiltro(){}
   
   public TipoFiltro(String table){
      super(table);
   }
   
   public void setIdTipoFiltro(int idTipoFiltro){
      this.idTipoFiltro = idTipoFiltro;
   }  
   
   public int getIdTipoFiltro(){
      return this.idTipoFiltro;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
   
   public void insert(){
      String query = "INSERT INTO tipoFiltro (nome) VALUES (?)"; 
      
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
    public ArrayList<TipoFiltro> selectAll(){
      ArrayList<TipoFiltro> lista = new ArrayList<>();
      TipoFiltro tipoFiltro;
      String query = "select idTipoFiltro, nome from tipoFiltro";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               tipoFiltro = new TipoFiltro();
               tipoFiltro.setIdTipoFiltro(rs.getInt("idTipoFiltro"));
               tipoFiltro.setNome(rs.getString("nome"));
               lista.add(tipoFiltro);
            } 
         }
         catch(SQLException e){
            e.printStackTrace();
         }   
      }catch(SQLException e){
         e.printStackTrace();
      }
         return lista;
   }

}


