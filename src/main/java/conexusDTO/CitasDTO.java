package conexusDTO;



import java.sql.Date;

import lombok.Data;

@Data
public class CitasDTO {
	private int idCitasC;
	private int id_PacienteC;
	private String lucarC;
	private String sintomasC;
	private String diagnosticoC;
	private String tratamientoC;
	private Date fechaConsultaC;
	private Date fechaProximaC;
	private int statusC;
	/*ID_CITA_T52	NUMBER
	ID_PACIENTE_Z24	NUMBER
	LUGAR	VARCHAR2(100 BYTE)
	SINTOMAS	VARCHAR2(500 BYTE)
	DIAGNOSTICO	VARCHAR2(500 BYTE)
	TRATAMIENTO	VARCHAR2(500 BYTE)
	FECHA_CONSULTA	DATE
	FECHA_PROXIMA_CITA	DATE
	ESTATUS	NUMBER*/
}
