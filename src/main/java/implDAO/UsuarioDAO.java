package implDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexusDTO.UsuarioDTO;

public class UsuarioDAO implements IUsuarioDAO{

	@Override
	public boolean save(UsuarioDTO objUsuarioDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UsuarioDTO objUsuarioDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findByIdUser(UsuarioDTO objUsuarioDTO) {
		// TODO Auto-generated method stub
		 /*Statement stmt = null;
		  try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      String sql;
	      sql = "SELECT * FROM `tbl_usuarios` where `tbl_usuarios`.`alias` like '"+objUsuarioDTO.getLogin()+"' and `tbl_usuarios`.`clave` like '"+objUsuarioDTO.getPasssha256()+"' ";
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
		*/
		return false;
	}

	@Override
	public boolean delete(UsuarioDTO objUsuarioDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
