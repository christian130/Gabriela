package implDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CitasMedicasImplDAO {
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:mysql://localhost/brasilia_diario";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn = null;
   public CitasMedicasImplDAO() {   
   try{
      Class.forName("com.mysql.jdbc.Driver");
      //System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }
   
}
  public boolean getLogin(String usuario, String clave){
	  Statement stmt = null;
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
}