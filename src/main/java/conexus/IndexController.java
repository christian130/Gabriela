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
	@RequestMapping (value="/guardarPaciente", method=RequestMethod.POST, 
    produces="application/json", consumes="application/x-www-form-urlencoded",params={"nro_historia", "nombre_paciente","telefono_paciente","email_paciente","Fecha_nacimiento"})
    public String crearPaciente(@RequestParam(value="nro_historia", required=false, defaultValue="N/A") 
    String nroHistoriaP, @RequestParam(value="nombre_paciente", required=false, defaultValue="N/A") String nombrePaciente,
    @RequestParam(value="telefono_paciente", required=false, defaultValue="N/A") String telefonoP,
    @RequestParam(value="email_paciente", required=false, defaultValue="N/A") String emailP,
    @RequestParam(value="Fecha_nacimiento", required=false, defaultValue="N/A") String fechaNacimientoP,
    Model model) {
		pacientes.setNroHistoriaP(nroHistoriaP);
		pacientes.setEmailP(emailP);
		pacientes.setTelefonoP(telefonoP);
		pacientes.setNombreP(nombrePaciente);
		pacientes.setFechaNacimientoP(fechaNacimientoP);
		if (mypacienteDAO.save(pacientes)){
			return "crear_paciente_mensaje";	
		}else{
			return "crear_paciente";
		}
    }	
	@RequestMapping("/pacientes")
    public String pacientes(@RequestParam(value="name", required=false, defaultValue="user") String name, @RequestParam(value="pass", required=false, defaultValue="password") String pass, Model model) {
		objUsuarioDTO.setLogin(name.toString());
		objUsuarioDTO.setPasssha256(pass.toString());
		List<PacientesDTO> ListOfDTO = mypacienteDAO.findByIdUser();
		model.addAttribute("messages",ListOfDTO); 
		if (objUsuarioDAO.findByIdUser(objUsuarioDTO)){
			return "pacientes";
		}else{
			return "login";
		}
    }
	@RequestMapping("/detalle_paciente")
    public String getDetallePaciente(@RequestParam(value="name", required=false, defaultValue="user") String name, @RequestParam(value="pass", required=false, defaultValue="password") String pass, Model model) {
		return "detalle_paciente";
	}
	@RequestMapping("/delete")
    public String borrarPaciente(@RequestParam(value="nroHistoria", required=false, defaultValue="user") String numeroHistoria, Model model) {
		pacientes.setNroHistoriaP(numeroHistoria);
		if (mypacienteDAO.delete(pacientes)){
			List<PacientesDTO> ListOfDTO = mypacienteDAO.findByIdUser();
			model.addAttribute("messages",ListOfDTO); 
			System.out.println("aplicado borrado logico de paciente con numero de historia: "+ numeroHistoria);
			return "pacientes";
		}else{
			return "login";
		}
	}
}
