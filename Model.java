/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/* class Model */
public class Model extends Conexao{
   private int id;
   private String table;
   private ArrayList<String> dados;
   
   public Model(){}
   
   public Model(String table){
      this.table = table;
   }
     
   public void selectAll(Connection conn){
      String query = "SELECT * FROM " + table;
         
      try(PreparedStatement prepare = conn.prepareStatement(query);){
         prepare.execute();
         try (ResultSet result = prepare.executeQuery();){
            if (result.next()) {
            //quero retornar o objeto para a classe filho para la tratar os dados
             //return result.next();
            }
         }catch (Exception e) {
            e.printStackTrace();
         }
      }catch (Exception e) {
         e.printStackTrace();
      }    
   }
   
   public void selectById(Connection conn, int id){
      String query = "SELECT * FROM " + table + "WHERE id" + table + " = ?";
    
      try(PreparedStatement prepare = conn.prepareStatement(query);){
         prepare.setInt(1, id);
         prepare.execute();
         try (ResultSet result = prepare.executeQuery();){
            if (result.next()){
               //quero retornar o objeto para a classe filho para la tratar os dados
               //return result;
            }
         } 
         catch (Exception e){
            e.printStackTrace();
         }
      }catch (Exception e){
         e.printStackTrace();
      } 
   }
   
   /*verificar forma de fazer um metodo insert e update generico*/
   /*public void insert(ArrayList<> atributos, String table, String insertQuery){
      String query = insertQuery;
   
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, getIdCliente());
         stm.setString(2, getNome());
         stm.setString(3, getFone());
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
   }*/

}