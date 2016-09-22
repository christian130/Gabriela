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

import conexusDTO.UsuarioDTO;

public class CitasMedicasImplDAO implements ApplicationContextAware  {
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@//192.168.56.101:1521/SERVICENAMEjdbc:mysql://localhost/brasilia_diario";
   static final String USER = "root";
   static final String PASS = "";
   
   Connection conn = null;
   public CitasMedicasImplDAO() {   
   /*try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }*/
   
}
  public boolean getLogin(UsuarioDTO objUsuarioDTO) throws Exception {
	  
	  try {
		  
          String dbURL = "jdbc:oracle:thin:@192.168.56.101:1521:deasrrollo";
          String strUserID = "CITAS_MEDICAS";
          String strPassword = "123456";
          Connection myConnection=DriverManager.getConnection(dbURL,strUserID,strPassword);

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
	  /*Statement stmt = null;
	  try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
      String sql;
      sql = "SELECT * FROM `tbl_usuarios` where `tbl_usuarios`.`alias` like '"+usuario.toString()+"' and `tbl_usuarios`.`clave` like '"+clave.toString()+"' ";
      try {
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			return true;
			}else{
				System.out.println(sql);
				//System.out.println("no");
			}
	
		
		 //if(stmt!=null)
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return false;
	 */ 
	  
  }
   public void close(){
	   try {
		conn.close();
		System.out.println("closing connection");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void RellenarGrid(JTable table, String Query)
   {
       try
       {
           //modelo mod = new modelo();
           //CreateConnection();
           Statement stat = conn.createStatement();
           ResultSet rs = stat.executeQuery(Query);

           //To remove previously added rows
           while(table.getRowCount() > 0) 
           {
               ((DefaultTableModel) table.getModel()).removeRow(0);
           }
           int columns = rs.getMetaData().getColumnCount();
           while(rs.next())
           {  
               Object[] row = new Object[columns];
               for (int i = 1; i <= columns; i++)
               {  
                   row[i - 1] = rs.getObject(i);
               }
               ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
           }

           rs.close();
           stat.close();
           conn.close();
       }
       catch( SQLException e)
       {
       }
   }
   private ApplicationContext applicationContext;
@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext = applicationContext;
	// TODO Auto-generated method stub
	
}
}