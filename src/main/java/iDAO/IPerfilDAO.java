package iDAO;

import conexusDTO.PerfilDTO;

public interface IPerfilDAO {
	public boolean save(PerfilDTO perfilObjDTO);
	   public boolean update(PerfilDTO perfilObjDTO);
	   public boolean findByIdUser(PerfilDTO perfilObjDTO);
	   public boolean delete(PerfilDTO perfilObjDTO);
}
