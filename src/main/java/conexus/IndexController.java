package conexus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import conexusDTO.UsuarioDTO;
import implDAO.AppConfig;
import implDAO.UsuarioDAO;
@Controller
public class IndexController {
	@RequestMapping("/")
    public String login(Model model) {        
        return "login";
    }
	@RequestMapping("/citas")
    public String citas(Model model) {        
        return "citas";
    }
		
	/*@RequestMapping (value="/pacientes", method=RequestMethod.GET, 
            produces="text/xml", params={"name", "password"})
public String handleLogin(@PathVariable("id") String id, @RequestParam(value="username", required=false, defaultValue="user") 
   String username, @RequestParam(value="password", required=false, defaultValue="password") String password, 
   @ModelAttribute("submitModel") Model model, BindingResult errors) 
   throws LoginException {
		CitasMedicasImplDAO getConnection = new CitasMedicasImplDAO();
		if (getConnection.getLogin(username, password)){
			return "pacientes";
		}else{
			return "login";
		}
	
		
	}*/
	@RequestMapping("/pacientes")
    public String pacientes(@RequestParam(value="name", required=false, defaultValue="user") String name, @RequestParam(value="pass", required=false, defaultValue="password") String pass, Model model) {
		
		System.out.println("'I' received the next values: "+name + pass);
		
		UsuarioDTO objUsuarioDTO = new UsuarioDTO();
		objUsuarioDTO.setLogin(name.toString());
		objUsuarioDTO.setPasssha256(pass.toString());
		UsuarioDAO objUsuarioDAO = new UsuarioDAO();
		if (objUsuarioDAO.findByIdUser(objUsuarioDTO)){
			return "pacientes";
		}else{
			return "login";
		}
    }
}
