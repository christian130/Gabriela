package conexusDTO;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PacientesDTO {
	public PacientesDTO() {
		super();
	}
	 @Bean
	 @Primary
	    public PacientesDTO miBean() {
	        return new PacientesDTO();
	    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailP == null) ? 0 : emailP.hashCode());
		result = prime * result + ((fechaNacimientoP == null) ? 0 : fechaNacimientoP.hashCode());
		result = prime * result + idP;
		result = prime * result + ((nombreP == null) ? 0 : nombreP.hashCode());
		result = prime * result + ((nroHistoriaP == null) ? 0 : nroHistoriaP.hashCode());
		result = prime * result + ((telefonoP == null) ? 0 : telefonoP.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacientesDTO other = (PacientesDTO) obj;
		if (emailP == null) {
			if (other.emailP != null)
				return false;
		} else if (!emailP.equals(other.emailP))
			return false;
		if (fechaNacimientoP == null) {
			if (other.fechaNacimientoP != null)
				return false;
		} else if (!fechaNacimientoP.equals(other.fechaNacimientoP))
			return false;
		if (idP != other.idP)
			return false;
		if (nombreP == null) {
			if (other.nombreP != null)
				return false;
		} else if (!nombreP.equals(other.nombreP))
			return false;
		if (nroHistoriaP == null) {
			if (other.nroHistoriaP != null)
				return false;
		} else if (!nroHistoriaP.equals(other.nroHistoriaP))
			return false;
		if (telefonoP == null) {
			if (other.telefonoP != null)
				return false;
		} else if (!telefonoP.equals(other.telefonoP))
			return false;
		return true;
	}
	
	public int getIdP() {
		return idP;
	}
	
	
	public String getNroHistoriaP() {
		return nroHistoriaP;
	}
	
	public void setNroHistoriaP(String nroHistoriaP) {
		this.nroHistoriaP = nroHistoriaP;
	}
	
	public String getNombreP() {
		return nombreP;
	}
	
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	
	public String getTelefonoP() {
		return telefonoP;
	}
	
	public void setTelefonoP(String telefonoP) {
		this.telefonoP = telefonoP;
	}
	
	public String getEmailP() {
		return emailP;
	}
	
	public void setEmailP(String emailP) {
		this.emailP = emailP;
	}
	
	public String getFechaNacimientoP() {
		return fechaNacimientoP;
	}
	
	public void setFechaNacimientoP(String fechaNacimientoP) {
		this.fechaNacimientoP = fechaNacimientoP;
	}
	
	public int getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		//System.out.println(calculateAge(edad));
		this.Edad = calculateAge(edad);
	}

	private int idP;
	private String nroHistoriaP;
	private String nombreP;
	private String telefonoP;
	private String emailP;
	private String fechaNacimientoP;	
	private int Edad;
	//NRO_HISTORIA	VARCHAR2(30 BYTE)
	//NOMBRE	VARCHAR2(100 BYTE)
	//TELEFONO	VARCHAR2(50 BYTE)
	//EMAIL	VARCHAR2(20 BYTE)
	//FECHA_NACIMIENTO	DATE
	//ESTATUS	NUMBER
	public int calculateAge(String fechaBirhdayP){
		String[] split = fechaBirhdayP.split("-");
		String dia=split[2].substring(0, 2);
		LocalDate today = LocalDate.of(new Integer(split[0]).intValue(), new Integer(split[1]).intValue(), new Integer(dia).intValue());
		LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
		LocalDate now= LocalDate.now();
		Period p = Period.between(now, today);
		return  Math.abs(p.getYears());
	}
}
