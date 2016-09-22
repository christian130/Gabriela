package iDAO;

import conexusDTO.CitasDTO;
import conexusDTO.PacientesDTO;

public interface ICitas {
	public boolean save(CitasDTO citasObjDTO);
	   public boolean update(CitasDTO citasObjDTO);
	   public boolean findByIdUser(CitasDTO citasObjDTO);
	   public boolean delete(CitasDTO citasObjDTO);
}
