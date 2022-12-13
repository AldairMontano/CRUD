package crud.dto;

import crud.entity.Persona;
import jakarta.validation.constraints.Size;

public class PersonaDTO {
	
public PersonaDTO() {
		
	}
	
	public PersonaDTO(Persona persona) {
		this.id = persona.getIdPersona();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellidos();
	}
	
	public Integer id;
	
	@Size(max = 50)
	public String nombre;
	
	@Size(max = 50)
	public String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
