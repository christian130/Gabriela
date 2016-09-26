package conexusDTO;

import java.sql.Date;

import lombok.Data;

@Data 
public class PacientesDTO {
	private int idP;
	private String nroHistoriaP;
	private String nombreP;
	private String telefonoP;
	private String emailP;
	private String fechaNacimientoP;	
	
	//NRO_HISTORIA	VARCHAR2(30 BYTE)
	//NOMBRE	VARCHAR2(100 BYTE)
	//TELEFONO	VARCHAR2(50 BYTE)
	//EMAIL	VARCHAR2(20 BYTE)
	//FECHA_NACIMIENTO	DATE
	//ESTATUS	NUMBER
}
