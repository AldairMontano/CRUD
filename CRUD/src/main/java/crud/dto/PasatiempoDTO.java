package crud.dto;

import crud.entity.Pasatiempo;
import jakarta.validation.constraints.Size;

public class PasatiempoDTO {
	
	private int idPasatiempo;
	
	@Size(max = 50)
	private String nombre;
	
	private Integer pasatiempo, id_persona;
	
	public PasatiempoDTO() {
		
	}
	
	public PasatiempoDTO(Pasatiempo pasatiempo) {
		this.idPasatiempo = pasatiempo.getIdPasatiempo();
		this.nombre = pasatiempo.getNombre();
		this.pasatiempo = pasatiempo.getPasatiempo();
		this.id_persona = pasatiempo.getId_persona();
	}

	public int getIdPasatiempo() {
		return idPasatiempo;
	}

	public void setIdPasatiempo(int idPasatiempo) {
		this.idPasatiempo = idPasatiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(Integer pasatiempo) {
		this.pasatiempo = pasatiempo;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
	
}
