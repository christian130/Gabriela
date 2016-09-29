package implDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import conexusDTO.PacientesDTO;
import iDAO.IPacientesDAO;
@Configuration
@ComponentScan({"conexusDTO","implDAO"})
public class PacientesDAO implements IPacientesDAO {	
	@Autowired
	AppConfig appconfig=null;
	@Override
	public boolean save(PacientesDTO pacientesObjDTO) {
		try {
			Statement sqlStatement = appconfig.getMyConnection().createStatement();
			String readRecordSQL = "INSERT INTO \"CITAS_MEDICAS\".\"PACIENTE_Z24\" (ID_PACIENTE_Z24, NRO_HISTORIA, NOMBRE, TELEFONO, EMAIL, FECHA_NACIMIENTO, ESTATUS) VALUES ('"+pacientesObjDTO.hashCode()+"', '"+pacientesObjDTO.getNroHistoriaP()+"', '"+pacientesObjDTO.getNombreP()+"', '"+pacientesObjDTO.getTelefonoP()+"', '"+pacientesObjDTO.getEmailP()+"', TO_DATE('"+pacientesObjDTO.getFechaNacimientoP()+"', 'YYYY-MM-DD'), '1')";
	          int myResultSet = sqlStatement.executeUpdate(readRecordSQL);	          
	          if (myResultSet==1){
	        	  appconfig.getMyConnection().close();
	        	  return true;	        	  
	          }else{
	        	  return false;
	          }
	          
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//PacientesDTO pacientes= new PacientesDTO();
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(PacientesDTO pacientesObjDTO) {
		try {
			Statement sqlStatement = appconfig.getMyConnection().createStatement();
			String readRecordSQL = "UPDATE \"CITAS_MEDICAS\".\"PACIENTE_Z24\" SET NOMBRE = '"+pacientesObjDTO.getNombreP()+"', TELEFONO = '"+pacientesObjDTO.getTelefonoP()+"', EMAIL = '"+pacientesObjDTO.getEmailP()+"', FECHA_NACIMIENTO = TO_DATE('"+pacientesObjDTO.getFechaNacimientoP()+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS') WHERE  NRO_HISTORIA = '"+pacientesObjDTO.getNroHistoriaP()+"'";
			System.out.println(readRecordSQL);
	          int myResultSet = sqlStatement.executeUpdate(readRecordSQL);	          
	          if (myResultSet==1){
	        	  appconfig.getMyConnection().close();
	        	  return true;	        	  
	          }else{
	        	  return false;
	          }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	

	@Override
	public boolean delete(PacientesDTO pacientesObjDTO) {
try {
			
			Statement sqlStatement = appconfig.getMyConnection().createStatement();
			String readRecordSQL = "UPDATE \"CITAS_MEDICAS\".\"PACIENTE_Z24\" SET ESTATUS = '0' WHERE NRO_HISTORIA = '"+pacientesObjDTO.getNroHistoriaP()+"'";
	          int myResultSet = sqlStatement.executeUpdate(readRecordSQL);	          
	          if (myResultSet>=1){
	        	  appconfig.getMyConnection().close();
	        	  return true;	        	  
	          }else{
	        	  return false;
	          }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception f){
			f.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<PacientesDTO> findByIdUser() {
		
		List<PacientesDTO> listPacientes = new ArrayList<PacientesDTO>();
		//ArrayList listPacientes = new ArrayList();
		
		 try {
	          Statement sqlStatement = appconfig.getMyConnection().createStatement();
	          String readRecordSQL = "select ID_PACIENTE_Z24,NRO_HISTORIA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO,ESTATUS from PACIENTE_Z24 where ESTATUS=1";
	          //String readRecordSQL = "select * from USUARIO_K78 where ROWNUM < 2 and ROWNUM >0 and LOGIN like '%"+objUsuarioDTO.getLogin()+"%' and CLAVE like '%"+objUsuarioDTO.getPasssha256()+"%'";  
	          ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
	          
	          while (myResultSet.next()) {
	        	  PacientesDTO nuevoObjeto  = new PacientesDTO();
	        	  nuevoObjeto.setNroHistoriaP(myResultSet.getString("NRO_HISTORIA"));	        	  
	        	  nuevoObjeto.setNombreP(myResultSet.getString("NOMBRE"));	        	  
	        	  nuevoObjeto.setTelefonoP(myResultSet.getString("TELEFONO"));
	        	  nuevoObjeto.setEmailP(myResultSet.getString("EMAIL"));
	        	  nuevoObjeto.setFechaNacimientoP(myResultSet.getString("FECHA_NACIMIENTO"));
	        	  nuevoObjeto.setEdad(myResultSet.getString("FECHA_NACIMIENTO"));
	        	  listPacientes.add(nuevoObjeto);
	        	  //System.out.println(pacientesObjDTO.getNombreP());
	              
	              
	            		  //myResultSet.getString("ID_PACIENTE_Z24"));
	          }	          
//	          for(PacientesDTO model : listPacientes) {
//	              System.out.println(model.getNombreP());
//	          }
	          
	          myResultSet.close();
	          appconfig.getMyConnection().close();
	          return listPacientes;
	          
	      } catch (Exception e) {
	          System.out.println(e);
	          return null;
	      }
		
		  
	}



}
