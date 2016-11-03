
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
public class UsuarioCadastro extends Model{
   private int idUsuarioCadastro;
   private String nome;
   private int cpf;
   private String dtNascimento;
   private String genero;
   private String endereco;
   private int numeroIdentificacao;
   private String dtCadastro;
   private int idTipoPerfil;
   private int idTipoIdentificacao; 
   private TipoPerfil tipoPerfil;
   private TipoIdentificacao tipoIdentificacao;
   
   public String table = "usuarioCadastro";
   
   public UsuarioCadastro(){
   }
      
   /*public UsuarioCadastro(String table){
      super(table);
   }*/
   
   public int getIdUsuarioCadastro(){
      return this.idUsuarioCadastro;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
   
   /*---*/
   public void setCpf(int cpf){
      this.cpf = cpf;
   }
     
   public int getCpf(){
      return this.cpf;
   }
   
   /*---*/
   public void setDtNascimento(String dtNascimento){
      /*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	   Date date = new Date();
	   this.dtNascimento = dateFormat.format(dtNascimento);*/
      this.dtNascimento = dtNascimento;
   }
     
   public String getDtNascimento(){
      return this.dtNascimento;
   }
   
   /*---*/
   public void setGenero(String genero){
      this.genero = genero;
   }
     
   public String getGenero(){
      return this.genero;
   }
   
   /*---*/
   public void setEndereco(String endereco){
      this.endereco = endereco;
   }
     
   public String getEndereco(){
      return this.endereco;
   }
   
   /*---*/
   public void setNumeroIdentificacao(int numeroIdentificacao){
      this.numeroIdentificacao = numeroIdentificacao;
   }
     
   public int getNumeroIdentificacao(){
      return this.numeroIdentificacao;
   }
   
   /*---*/
   public void setDtCadastro(String dtCadastro){
      this.dtCadastro = dtCadastro;
   }
     
   public String getDtCadastro(){
      return this.dtCadastro;
   }
   
   /*---*/
   public void setIdTipoPerfil(int idTipoPerfil){
      this.idTipoPerfil = idTipoPerfil;
   }
     
   public int getIdTipoPerfil(){
      return this.idTipoPerfil;
   }
   
   /*---*/
   public void setIdTipoIdentificacao(int idTipoIdentificacao){
      this.idTipoIdentificacao = idTipoIdentificacao;
   }
     
   public int getIdTipoIdentificacao(){
      return this.idTipoIdentificacao;
   }
   
   public void insert(){
      String query = "INSERT INTO usuarioCadastro (nome, cpf, dtNascimento, genero, endereco, numeroIdentificacao, dtCadastro, tipoPerfil_id_tipoPerfil, tipoIdentificacao_id_tipoIdentificacao) VALUES (?,?,?,?,?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
           
          // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          // Date dtNascimento = format.parse(getDtNascimento());
           
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
            stm.setInt(2, getCpf());
            stm.setString(3, getDtNascimento());
            stm.setString(4, getGenero());
            stm.setString(5, getEndereco());
            stm.setInt(6, getNumeroIdentificacao());
            stm.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setInt(8, 1);
            stm.setInt(9, getIdTipoIdentificacao());
            stm.execute();
            
            //retornar o last insert id
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


