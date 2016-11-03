
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class TipoPerfil*/
public class Ocorrencia extends Model{
   private int idOcorrencia;
   private String email;
   private String nomeUsuario;
   private String assunto;
   private String conteudo;
   private String dtOcorrencia;
   private int idUsuarioAcesso;
   private int idStatus;
      
   private String table = "ocorrencia";
   
   public Ocorrencia(){}
   
   public Ocorrencia(String table){
      super(table);
   }
   
   public void setIdOcorrencia(int idOcorrencia){
      this.idOcorrencia = idOcorrencia;
   }  
   
   public int getIdOcorrencia(){
      return this.idOcorrencia;
   }
   
   /*---*/
   public void setEmail(String email){
      this.email = email;
   }
     
   public String getEmail(){
      return this.email;
   }
   
   /*---*/
   public void setNomeUsuario(String nomeUsuario){
      this.nomeUsuario = nomeUsuario;
   }
     
   public String getNomeUsuario(){
      return this.nomeUsuario;
   }
   
   /*---*/
   public void setAssunto(String assunto){
      this.assunto = assunto;
   }
     
   public String getAssunto(){
      return this.assunto;
   }
   
   /*---*/
   public void setConteudo(String conteudo){
      this.conteudo = conteudo;
   }
     
   public String getConteudo(){
      return this.conteudo;
   }
   
   /*---*/
   public void setDtOcorrencia(String dtOcorrencia){
      this.dtOcorrencia = dtOcorrencia;
   }
     
   public String getDtOcorrencia(){
      return this.dtOcorrencia;
   }
   
   /*---*/
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
     
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   /*---*/
   public void setIdStatus (int idStatus){
      this.idStatus = idStatus;
   }
     
   public int getIdStatus(){
      return this.idStatus;
   }
      
   public void insert(){
      String query = "INSERT INTO ocorencia (email, nomeUsuario, assunto, conteudo, dtOcorrencia, usuarioAcesso_idUsuarioAcesso, status_IdStatus) VALUES (?,?,?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getEmail());
            stm.setString(2, getNomeUsuario());
            stm.setString(3, getAssunto());
            stm.setString(4, getConteudo());
            stm.setString(5, getDtOcorrencia());
            stm.setInt(6, getIdUsuarioAcesso());                                                           
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
     
   public ArrayList<Ocorrencia> selectAll(){
      ArrayList<Ocorrencia> lista = new ArrayList<>();
      TipoFiltro tipoFiltro;
      String query = "select * from ocorrencia";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Ocorrencia ocorrencia = new Ocorrencia();
               //terminar de inserir os dados de retorno no arrayList
               ocorrencia.setIdOcorrencia(rs.getInt("idOcorrencia"));
               ocorrencia.setNomeUsuario(rs.getString("nome"));
               ocorrencia.setAssunto(rs.getString("assunto"));
               ocorrencia.setConteudo(rs.getString("conteudo"));               
               ocorrencia.setDtOcorrencia(rs.getString("dtOcorrencia"));               
               ocorrencia.setAssunto(rs.getString("assunto"));
               ocorrencia.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_idUsuarioAcesso")); 
               ocorrencia.setIdStatus(rs.getInt("status_idStatus"));
                              
               lista.add(ocorrencia);
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


