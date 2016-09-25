package conexus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import conexusDTO.UsuarioDTO;
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
	@RequestMapping("/crear_paciente")
    public String irAPaciente(Model model) {
		
        return "crear_paciente";
    }	
	/*@RequestMapping("/crear_paciente_mensaje")
    public String mostrarPaciente(Model model) {
		System.out.println("now 'I' will create a registry in the DB, note: i'm in the IndexController");
		
        return "crear_paciente_mensaje";
    }*/
	
	@RequestMapping (value="/guardarPaciente", method=RequestMethod.POST, 
    produces="application/json", consumes="application/json",params={"nro_historia", "nombre_paciente","telefono_paciente","email_paciente","Fecha_nacimiento"})
    public String crearPaciente(@PathVariable("nro_historia") String id, @RequestParam(value="username", required=false, defaultValue="user") 
    String username, @RequestParam(value="password", required=false, defaultValue="password") String password, 
    @ModelAttribute("submitModel") Model model, BindingResult errors) {
		System.out.println("now 'I' will create a registry in the DB, note: i'm in the IndexController");
		
        return "crear_paciente_mensaje";
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
