package iDAO;

import java.util.List;

import conexusDTO.PacientesDTO;

public interface IPacientesDAO {
	public boolean save(PacientesDTO pacientesObjDTO);
	   public boolean update(PacientesDTO pacientesObjDTO);
	   public List<PacientesDTO> findByIdUser();
	   public boolean delete(PacientesDTO pacientesObjDTO);
}
