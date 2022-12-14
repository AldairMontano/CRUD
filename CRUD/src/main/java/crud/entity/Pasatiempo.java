package crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	private Integer pasatiempo;
	
	@OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;
	
	public Pasatiempo() {
		
	}


	public Pasatiempo(@Size(max = 50) String nombre, Integer pasatiempo) {
		this.nombre = nombre;
		this.pasatiempo = pasatiempo;
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
