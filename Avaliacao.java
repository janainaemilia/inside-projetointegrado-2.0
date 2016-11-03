
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class Avaliacao*/
public class Avaliacao extends Model{
   private int idAvaliacao;
   private String resposta;
   private boolean aprovado;
   private String dtAvaliacao;
   private int idSugestao;
   private int idUsuarioAcesso;   
      
   private String table = "avaliacao";
   
   public Avaliacao(){}
   
   public Avaliacao(String table){
      super(table);
   }
   
   public void setIdAvaliacao(int idAvaliacao){
      this.idAvaliacao = idAvaliacao;
   }  
   
   public int getIdAvaliacao(){
      return this.idAvaliacao;
   }
   
   /*---*/
   public void setResposta(String resposta){
      this.resposta = resposta;
   }
     
   public String getResposta(){
      return this.resposta;
   }
   
   /*---*/
   public void setAprovado(Boolean aprovado){
      this.aprovado = aprovado;
   }
     
   public Boolean getAprovado(){
      return this.aprovado;
   }
   
   /*---*/
   public void setDtAvaliacao(String dtAvaliacao){
      this.dtAvaliacao = dtAvaliacao;
   }
     
   public String getDtAvaliacao(){
      return this.dtAvaliacao;
   }
    
   /*---*/
   public void setIdSugestao(int idSugestao){
      this.idSugestao = idSugestao;
   }
     
   public int getIdSugestao(){
      return this.idSugestao;
   }
   
   /*---*/
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
     
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
  
   public void insert(){
      String query = "INSERT INTO avaliacao (resposta, aprovado, dtAvaliacao, sugestao_idSugestao, usuarioAcesso_idUsuarioAcesso) VALUES (?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getResposta());
            stm.setBoolean(2, getAprovado());
            stm.setString(2, getDtAvaliacao());                                                           
            stm.setInt(4, getIdUsuarioAcesso());            
            stm.setInt(5, getIdSugestao());           
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
     
   public ArrayList<Avaliacao> selectAll(){
      ArrayList<Avaliacao> lista = new ArrayList<>();

      String query = "select * from avaliacao";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Avaliacao avaliacao = new Avaliacao();
               avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
               avaliacao.setResposta(rs.getString("resposta"));                
               avaliacao.setAprovado(rs.getBoolean("aprovado"));      
               avaliacao.setDtAvaliacao(rs.getString("dtAvaliacao"));                  
               avaliacao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_idUsuarioAcesso"));                
               avaliacao.setIdSugestao(rs.getInt("sugestao_idSugestao"));  
                              
               lista.add(avaliacao);
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


