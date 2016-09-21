package implDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import conexusDTO.UsuarioDTO;

public class UsuarioDAO implements IUsuarioDAO{
	@Autowired
	private ApplicationContext appContext;
	//@Autowired
	//private dataSource d;
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
		CitasMedicasImplDAO getConnection = new CitasMedicasImplDAO();
		try {
			if (getConnection.getLogin(objUsuarioDTO)){
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
