package iDAO;

import conexusDTO.PacientesDTO;
import conexusDTO.UsuarioDTO;

public interface IPacientesDAO {
	public boolean save(PacientesDTO pacientesObjDTO);
	   public boolean update(PacientesDTO pacientesObjDTO);
	   public boolean findByIdUser(PacientesDTO pacientesObjDTO);
	   public boolean delete(PacientesDTO pacientesObjDTO);
	
}
