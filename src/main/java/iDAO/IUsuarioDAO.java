package iDAO;

import conexusDTO.UsuarioDTO;

public interface IUsuarioDAO {
	 public boolean save(UsuarioDTO objUsuarioDTO);
	   public boolean update(UsuarioDTO objUsuarioDTO);
	   public boolean findByIdUser(UsuarioDTO objUsuarioDTO );
	   public boolean delete(UsuarioDTO objUsuarioDTO);

}
