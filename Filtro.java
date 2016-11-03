
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class TipoPerfil*/
public class Filtro extends Model{
   private int idFiltro;
   private String nome;
   private int idTipoFiltro;
   private int idTipoPerfil;
   
   private String table = "filtro";
   
   public Filtro(){}
   
   public Filtro(String table){
      super(table);
   }
   
   public void setIdFiltro(int idFiltro){
      this.idFiltro = idFiltro;
   }
   
   public int getIdFiltro(){
      return this.idFiltro;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
   
   public void setIdTipoFiltro(int idTipoFiltro){
      this.idTipoFiltro = idTipoFiltro;
   }
     
   public int getIdTipoFiltro(){
      return this.idTipoFiltro;
   }
 
   public void setIdTipoPerfil(int idTipoPerfil){
      this.idTipoPerfil = idTipoPerfil;
   }
     
   public int getIdTipoPerfil(){
      return this.idTipoPerfil;
   }

   public void insert(){
      String query = "INSERT INTO filtro (nome, tipoFiltro_idTipoFiltro, tipoPerfil_idTipoPerfil) VALUES (?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
            stm.setInt(2, getIdTipoFiltro());
            stm.setInt(3, getIdTipoPerfil());
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
   
   public ArrayList<Filtro> selectAll(){
      ArrayList<Filtro> lista = new ArrayList<>();
      Filtro filtro;
      String query = "select idFiltro, nome from filtro";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               filtro = new Filtro();
               filtro.setIdFiltro(rs.getInt("idFiltro"));
               filtro.setNome(rs.getString("nome"));
               lista.add(filtro);
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


