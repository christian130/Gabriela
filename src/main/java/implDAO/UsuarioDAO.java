package implDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import conexusDTO.UsuarioDTO;
import iDAO.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO{
	
	@Autowired	
	AppConfig configuracionInicial;
	
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
		
				try {
			if (configuracionInicial.getLogin(objUsuarioDTO)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean delete(UsuarioDTO objUsuarioDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
