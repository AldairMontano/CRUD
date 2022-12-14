package crud.dto;

import crud.entity.Pasatiempo;
import jakarta.validation.constraints.Size;

public class PasatiempoDTO {
	
	private int idPasatiempo;
	
	@Size(max = 50)
	private String nombre;
	
	private Integer pasatiempo;
	
	public PasatiempoDTO() {
		
	}
	
	public PasatiempoDTO(Pasatiempo pasatiempo) {
		this.idPasatiempo = pasatiempo.getIdPasatiempo();
		this.nombre = pasatiempo.getNombre();
		this.pasatiempo = pasatiempo.getPasatiempo();
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
	
}
