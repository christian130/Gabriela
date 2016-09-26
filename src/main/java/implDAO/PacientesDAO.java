package implDAO;

import java.sql.SQLException;
import java.sql.Statement;

import conexusDTO.PacientesDTO;
import iDAO.IPacientesDAO;

public class PacientesDAO implements IPacientesDAO {

	@Override
	public boolean save(PacientesDTO pacientesObjDTO) {
		try {
			
			Statement sqlStatement = AppConfig.getMyConnection().createStatement();
			//INSERT INTO "CITAS_MEDICAS"."PACIENTE_Z24" (ID_PACIENTE_Z24, NRO_HISTORIA, NOMBRE, TELEFONO, EMAIL, FECHA_NACIMIENTO, ESTATUS) VALUES ('1', '01112', 'Garcia Mendez', '1234567', 'ccc@gmail.com', TO_DATE('2016-09-24 22:34:05', 'YYYY-MM-DD HH24:MI:SS'), '1')
			String readRecordSQL = "INSERT INTO \"CITAS_MEDICAS\".\"PACIENTE_Z24\" (ID_PACIENTE_Z24, NRO_HISTORIA, NOMBRE, TELEFONO, EMAIL, FECHA_NACIMIENTO, ESTATUS) VALUES ('"+pacientesObjDTO.hashCode()+"', '"+pacientesObjDTO.getNroHistoriaP()+"', '"+pacientesObjDTO.getNombreP()+"', '"+pacientesObjDTO.getTelefonoP()+"', '"+pacientesObjDTO.getEmailP()+"', TO_DATE('"+pacientesObjDTO.getFechaNacimientoP()+"', 'YYYY-MM-DD'), '1')";
	          int myResultSet = sqlStatement.executeUpdate(readRecordSQL);	          
	          if (myResultSet==1){
	        	  AppConfig.getMyConnection().close();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findByIdUser(PacientesDTO pacientesObjDTO) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PacientesDTO pacientesObjDTO) {
		// TODO Auto-generated method stub
		return false;
	}



}
