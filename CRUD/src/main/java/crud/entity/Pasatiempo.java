package crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pasatiempo", schema = "public")
public class Pasatiempo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPasatiempo;
	
	@Size(max = 50)
	private String nombre;
	
	private Integer pasatiempo, id_persona;
	
	public Pasatiempo() {
		
	}


	public Pasatiempo(int idPasatiempo, @Size(max = 50) String nombre, Integer pasatiempo, Integer id_persona) {
		this.idPasatiempo = idPasatiempo;
		this.nombre = nombre;
		this.pasatiempo = pasatiempo;
		this.id_persona = id_persona;
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
