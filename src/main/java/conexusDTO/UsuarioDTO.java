package conexusDTO;

public class UsuarioDTO {
private int id;
private int id_perfil;
private String login;
private String passsha256;
private int status;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
	public int getId_perfil() {
	return id_perfil;
}

public void setId_perfil(int id_perfil) {
	this.id_perfil = id_perfil;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPasssha256() {
	return passsha256;
}

public void setPasssha256(String passsha256) {
	this.passsha256 = passsha256;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}


}
