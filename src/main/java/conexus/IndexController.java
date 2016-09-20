package conexus;
import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import implDAO.CitasMedicasImplDAO;
@Controller
public class IndexController {
	@RequestMapping("/3333")
    public String login(Model model) {        
        return "login";
    }
		
	@RequestMapping (value="/pacientes", method=RequestMethod.POST, 
            produces="text/xml", params={"name", "password"})
public String handleLogin(@PathVariable("id") String id, @RequestParam("name") 
   String username, @RequestParam("password") String password, 
   @ModelAttribute("submitModel") Model model, BindingResult errors) 
   throws LoginException {
		CitasMedicasImplDAO getConnection = new CitasMedicasImplDAO();
		if (getConnection.getLogin(username, password)){
			return "pacientes";
		}else{
			return "login";
		}
	
		
	}

}
