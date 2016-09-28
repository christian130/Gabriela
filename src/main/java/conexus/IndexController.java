package conexus;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import conexusDTO.PacientesDTO;
import conexusDTO.UsuarioDTO;
import implDAO.PacientesDAO;
import implDAO.UsuarioDAO;
@Controller
@ComponentScan({"conexusDTO","implDAO"})
public class IndexController {
	
	@Autowired
	PacientesDTO pacientes = null;
	@Autowired
	PacientesDAO mypacienteDAO=null;
	@Autowired
	UsuarioDTO objUsuarioDTO=null;
	@Autowired
	UsuarioDAO objUsuarioDAO=null;
	@RequestMapping(value={"/","login"})
    public String login(Model model) {
		
        return "login";
    }
	@RequestMapping("/citas")
    public String citas(Model model) {        
        return "citas";
    }
	@RequestMapping(value={"/crear_paciente","/crear_paciente_mensaje"})
    public String irAPaciente(Model model) {
		
        return "crear_paciente";
    }
		
	/*@RequestMapping("/crear_paciente_mensaje")
    public String mostrarPaciente(Model model) {
		System.out.println("now 'I' will create a registry in the DB, note: i'm in the IndexController");
		
        return "crear_paciente_mensaje";
    }*/
	
	@RequestMapping (value="/guardarPaciente", method=RequestMethod.POST, 
    produces="application/json", consumes="application/x-www-form-urlencoded",params={"nro_historia", "nombre_paciente","telefono_paciente","email_paciente","Fecha_nacimiento"})
    public String crearPaciente(@RequestParam(value="nro_historia", required=false, defaultValue="N/A") 
    String nroHistoriaP, @RequestParam(value="nombre_paciente", required=false, defaultValue="N/A") String nombrePaciente,
    @RequestParam(value="telefono_paciente", required=false, defaultValue="N/A") String telefonoP,
    @RequestParam(value="email_paciente", required=false, defaultValue="N/A") String emailP,
    @RequestParam(value="Fecha_nacimiento", required=false, defaultValue="N/A") String fechaNacimientoP,
    Model model) {
		
//System.out.println(convertido);
		System.out.println(nroHistoriaP+nombrePaciente+telefonoP+emailP+fechaNacimientoP);
		//PacientesDTO pacientes = new PacientesDTO();
		pacientes.setNroHistoriaP(nroHistoriaP);
		pacientes.setEmailP(emailP);
		pacientes.setTelefonoP(telefonoP);
		pacientes.setNombreP(nombrePaciente);
		pacientes.setFechaNacimientoP(fechaNacimientoP);
		//PacientesDAO mypacienteDAO = new PacientesDAO();
		if (mypacienteDAO.save(pacientes)){
			return "crear_paciente_mensaje";	
		}else{
			return "crear_paciente";
			
		}
		
		//return "crear_paciente";
        
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
		
//		UsuarioDTO objUsuarioDTO = new UsuarioDTO();
		objUsuarioDTO.setLogin(name.toString());
		objUsuarioDTO.setPasssha256(pass.toString());
		//UsuarioDAO objUsuarioDAO = new UsuarioDAO();
		List<PacientesDTO> ListOfDTO = mypacienteDAO.findByIdUser();
		model.addAttribute("messages",ListOfDTO); 
		//model.addAttribute(attributeValue);
		if (objUsuarioDAO.findByIdUser(objUsuarioDTO)){
			return "pacientes";
		}else{
			return "login";
		}
    }
}
