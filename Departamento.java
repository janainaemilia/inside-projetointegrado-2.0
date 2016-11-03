
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class TipoPerfil*/
public class Departamento extends Model{
   private int idDepartamento;
   private String nome;
   
   private String table = "status";
   
   public Departamento(){}
   
   public Departamento(String table){
      super(table);
   }
   
   public void setIdDepartamento(int idDepartamento){
      this.idDepartamento = idDepartamento;
   }
   
   public int getIdDepartamento(){
      return this.idDepartamento;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
    public void insert(){
     String query = "INSERT INTO departamento (nome) VALUES (?)"; 
      
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
   
   public ArrayList<Departamento> selectAll(){
      ArrayList<Departamento> lista = new ArrayList<>();
      Departamento departamento;
      String query = "select idDepartamento, nome from departamento";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               departamento = new Departamento();
               departamento.setIdDepartamento(rs.getInt("idDepartamento"));
               departamento.setNome(rs.getString("nome"));
               lista.add(departamento);
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


