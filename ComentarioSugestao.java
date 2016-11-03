
/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/*class Sugestao*/
public class ComentarioSugestao extends Model{
   private int idComentarioSugestao;
   private String conteudo;
   private String dtComentario;
   private int numeroCurtida;
   private int idUsuarioAcesso;
   private int idSugestao;
      
   private String table = "comentarioSugestao";
   
   public ComentarioSugestao(){}
   
   public ComentarioSugestao(String table){
      super(table);
   }
   
   public void setIdComentarioSugestao(int idComentarioSugestao){
      this.idComentarioSugestao = idComentarioSugestao;
   }  
   
   public int getIdComentarioSugestao(){
      return this.idComentarioSugestao;
   }
   
   /*---*/
   public void setConteudo(String conteudo){
      this.conteudo = conteudo;
   }
     
   public String getConteudo(){
      return this.conteudo;
   }
   
   /*---*/
   public void setDtComentario(String dtComentario){
      this.dtComentario = dtComentario;
   }
     
   public String getDtComentario(){
      return this.dtComentario;
   }
   
   /*---*/
   public void setNumeroCurtida(int numeroCurtida){
      this.numeroCurtida = numeroCurtida;
   }
     
   public int getNumeroCurtida(){
      return this.numeroCurtida;
   }
   
   /*---*/
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
     
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   /*---*/
   public void setIdSugestao(int idSugestao){
      this.idSugestao = idSugestao;
   }
     
   public int getIdSugestao(){
      return this.idSugestao;
   }
   
    public void insert(){
      String query = "INSERT INTO comentarioSugestao (conteudo, dtComentario, numeroCurtida, usuarioAcesso_idUsuarioAcesso, sugestao_idSugestao) VALUES (?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getConteudo());
            stm.setString(2, getDtComentario());
            stm.setInt(3, getNumeroCurtida());                                                           
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
     
   public ArrayList<ComentarioSugestao> selectAll(){
      ArrayList<ComentarioSugestao> lista = new ArrayList<>();

      String query = "select * from comentarioSugestao";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               ComentarioSugestao comentarioSugestao = new ComentarioSugestao();
               //terminar de inserir os dados de retorno no arrayList
               comentarioSugestao.setIdComentarioSugestao(rs.getInt("idComentarioSugestao"));
               comentarioSugestao.setConteudo(rs.getString("conteudo"));      
               comentarioSugestao.setDtComentario(rs.getString("dtComentario"));  
               comentarioSugestao.setNumeroCurtida(rs.getInt("numeroCurtida"));                 
               comentarioSugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_idUsuarioAcesso"));                
               comentarioSugestao.setIdSugestao(rs.getInt("sugestao_idSugestao"));  
                              
               lista.add(comentarioSugestao);
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


