package iDAO;

import conexusDTO.UsuarioDTO;

public interface IUsuarioDAO {
	 public boolean save(UsuarioDTO objUsuarioDAO);
	   public boolean update(UsuarioDTO objUsuarioDAO);
	   public boolean findByIdUser(UsuarioDTO objUsuarioDAO );
	   public boolean delete(UsuarioDTO objUsuarioDAO);

}
