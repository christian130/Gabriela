package implDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import conexusDTO.UsuarioDTO;
import iDAO.IUsuarioDAO;
@Component
public class UsuarioDAO implements IUsuarioDAO{
	
		
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
					
					AppConfig configuracionInicial = new AppConfig();
			if (configuracionInicial.getLogin(objUsuarioDTO)){
				System.out.println("caigo aqui");
				return true;
			}else{
				System.out.println("entonces caigo aqui");
				return false;
			}
		} catch (Exception e) {
			System.out.println("no way... i'm here");
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
