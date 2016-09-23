package implDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

import conexusDTO.UsuarioDTO;
import oracle.jdbc.pool.OracleDataSource;

public class CitasMedicasImplDAO  {

   
	private Connection myConnection = null;
	private ApplicationContext context;
   public CitasMedicasImplDAO() {   
 
   
}
  public boolean getLogin(UsuarioDTO objUsuarioDTO) throws Exception {
	  
	  try {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        OracleDataSource dataSource=  (OracleDataSource) context.getBean("dataSource");
      	Connection myConnection = dataSource.getConnection();
         Statement sqlStatement = myConnection.createStatement();
          String readRecordSQL = "select * from USUARIO_K78 where ROWNUM < 2 and ROWNUM >0";
          //String readRecordSQL = "select * from USUARIO_K78 where ROWNUM < 2 and ROWNUM >0 and LOGIN like '%"+objUsuarioDTO.getLogin()+"%' and CLAVE like '%"+objUsuarioDTO.getPasssha256()+"%'";  
          ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
          while (myResultSet.next()) {
              return true;
          }
          myResultSet.close();
          myConnection.close();
          
      } catch (Exception e) {
          System.out.println(e);
          return false;
      }
	
	  return false;
	
	  
  }
  
   
 
}