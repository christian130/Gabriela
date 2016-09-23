package implDAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

import conexusDTO.UsuarioDTO;
import oracle.jdbc.pool.OracleDataSource;


@Configuration
public class AppConfig  {

   
	private Connection myConnection;
	private ApplicationContext context;
   public AppConfig() {   
 
   
}
   
   @Bean
  public boolean getLogin(UsuarioDTO objUsuarioDTO) throws Exception {
	  
	  try {
          Statement sqlStatement = this.getMyConnection().createStatement();
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
@Bean
public Connection getMyConnection() throws Exception {
	 ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
     OracleDataSource dataSource=  (OracleDataSource) context.getBean("dataSource");
   	Connection myConnection = dataSource.getConnection();
	return myConnection;
}


  
   
 
}