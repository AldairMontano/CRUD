package crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "direcciones", schema = "public")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDireccion;
	
	@Size(max = 255)
	private String calle;
	
	@Size(max = 5)
	private String num_interior;
	
	@Size(max = 5)
	private String num_exterior;
	
	@Size(max = 150)
	private String colonia;
	
	private Integer codigo_postal, ciudad, estadoInteger;
	
	public Direccion() {
		
	}

	
	
	public Direccion(int idDireccion, @Size(max = 255) String calle, @Size(max = 5) String num_interior,
			@Size(max = 5) String num_exterior, @Size(max = 150) String colonia, Integer codigo_postal, Integer ciudad,
			Integer estadoInteger) {
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.num_interior = num_interior;
		this.num_exterior = num_exterior;
		this.colonia = colonia;
		this.codigo_postal = codigo_postal;
		this.ciudad = ciudad;
		this.estadoInteger = estadoInteger;
	}



	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNum_interior() {
		return num_interior;
	}

	public void setNum_interior(String num_interior) {
		this.num_interior = num_interior;
	}

	public String getNum_exterior() {
		return num_exterior;
	}

	public void setNum_exterior(String num_exterior) {
		this.num_exterior = num_exterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public Integer getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public Integer getCiudad() {
		return ciudad;
	}

	public void setCiudad(Integer ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getEstadoInteger() {
		return estadoInteger;
	}

	public void setEstadoInteger(Integer estadoInteger) {
		this.estadoInteger = estadoInteger;
	}

}
