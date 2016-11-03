
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class Sugestao*/
public class Sugestao extends Model{
   private int idSugestao;
   private String conteudo;
   private String dtSugestao;
   private String assunto;
   private int idUsuarioAcesso;
   private int idDepartamento;   
   private String tipoSugestao;   
   private int idStatus;
      
   private String table = "sugestao";
   
   public Sugestao(){}
   
   public Sugestao(String table){
      super(table);
   }
   
   public void setIdSugestao(int idSugestao){
      this.idSugestao = idSugestao;
   }  
   
   public int getIdSugestao(){
      return this.idSugestao;
   }
   
   /*---*/
   public void setConteudo(String conteudo){
      this.conteudo = conteudo;
   }
     
   public String getConteudo(){
      return this.conteudo;
   }
   
   /*---*/
   public void setDtSugestao(String dtSugestao){
      this.dtSugestao = dtSugestao;
   }
     
   public String getDtSugestao(){
      return this.dtSugestao;
   }
   
   /*---*/
   public void setAssunto(String assunto){
      this.assunto = assunto;
   }
     
   public String getAssunto(){
      return this.assunto;
   }
   
   /*---*/
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
     
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   /*---*/
   public void setIdDepartamento(int idDepartamento){
      this.idDepartamento = idDepartamento;
   }
     
   public int getIdDepartamento(){
      return this.idDepartamento;
   }
   
   /*---*/
   public void setTipoSugestao(String tipoSugestao){
      this.tipoSugestao = tipoSugestao;
   }
     
   public String getTipoSugestao(){
      return this.tipoSugestao;
   }
   
   /*---*/
   public void setIdStatus (int idStatus){
      this.idStatus = idStatus;
   }
     
   public int getIdStatus(){
      return this.idStatus;
   }
      
   public void insert(){
      String query = "INSERT INTO sugestao (conteudo, dtSugestao, assunto, usuarioAcesso_idUsuarioAcesso, departamento_idDepartamento, tipoSugestao, status_IdStatus) VALUES (?,?,?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getConteudo());
            stm.setString(2, getDtSugestao());
            stm.setString(3, getAssunto());
            stm.setInt(6, getIdUsuarioAcesso());                                                           
            stm.setInt(6, getIdDepartamento());            
            stm.setString(6, getTipoSugestao());            
            stm.setInt(6, getIdStatus());            
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
     
   public ArrayList<Sugestao> selectAll(){
      ArrayList<Sugestao> lista = new ArrayList<>();

      String query = "select * from sugestao";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Sugestao sugestao = new Sugestao();
               //terminar de inserir os dados de retorno no arrayList
               sugestao.setIdSugestao(rs.getInt("idSugestao"));
               sugestao.setConteudo(rs.getString("nome"));
               sugestao.setDtSugestao(rs.getString("assunto"));
               sugestao.setAssunto(rs.getString("conteudo"));      
               sugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_idUsuarioAcesso")); 
               sugestao.setIdDepartamento(rs.getInt("departamento_idDepartamento"));                
               sugestao.setTipoSugestao(rs.getString("tipoSugestao"));               
               sugestao.setIdStatus(rs.getInt("status_idStatus"));
                              
               lista.add(sugestao);
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


