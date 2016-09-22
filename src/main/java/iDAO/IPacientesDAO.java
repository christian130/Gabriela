package iDAO;

import conexusDTO.PacientesDTO;

public interface IPacientesDAO {
	public boolean save(PacientesDTO pacientesObjDTO);
	   public boolean update(PacientesDTO pacientesObjDTO);
	   public boolean findByIdUser(PacientesDTO pacientesObjDTO);
	   public boolean delete(PacientesDTO pacientesObjDTO);
	
}
