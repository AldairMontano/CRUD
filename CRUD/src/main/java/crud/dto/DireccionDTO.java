package crud.dto;

import crud.entity.Direccion;
import jakarta.validation.constraints.Size;

public class DireccionDTO {
	
	private int idDireccion;
	
	@Size(max = 255)
	private String calle;
	
	@Size(max = 5)
	private String num_interior;
	
	@Size(max = 5)
	private String num_exterior;
	
	@Size(max = 150)
	private String colonia;
	
	private Integer codigo_postal, ciudad, estado;
	
	public DireccionDTO() {
		
	}
	
	public DireccionDTO(Direccion direccion) {
		this.idDireccion = direccion.getIdDireccion();
		this.calle = direccion.getCalle();
		this.num_interior = direccion.getNum_interior();
		this.num_exterior = direccion.getNum_exterior();
		this.colonia = direccion.getColonia();
		this.codigo_postal = direccion.getCodigo_postal();
		this.ciudad = direccion.getCiudad();
		this.estado = direccion.getEstadoInteger();
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	

}
