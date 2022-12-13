package crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.dto.DireccionDTO;
import crud.entity.Direccion;
import crud.service.DireccionService;

@RestController
public class DireccionController {
	
	@Autowired
	public DireccionService direccionService;
	
	
	@PutMapping("/listaDirecciones")
	public ResponseEntity<List<Direccion>> listaDireccion() {
		List<Direccion> listaDirecciones = direccionService.listaDireccion();
		return new ResponseEntity<List<Direccion>>(listaDirecciones, HttpStatus.OK);
	}
	
	@PutMapping("/pasatiempos/{idDireccion}")
	public ResponseEntity<DireccionDTO> obtenerDireccion(@PathVariable("idDireccion") int idDireccion) {
		return new ResponseEntity<>(new DireccionDTO(this.direccionService.obtenerPorId(idDireccion)),HttpStatus.OK);
	}
	
	@PutMapping("/guardar")
	public ResponseEntity<Integer> guardarDireccion(Direccion direccion) {
		Integer id = 0;
		try {
			id = this.direccionService.guardarDireccion(direccion);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@PutMapping("/guardarDTO")
	public ResponseEntity<Integer> guardarDireccion(DireccionDTO direccionDTO) {
		Integer id = 0;
		Direccion direccion2 = new Direccion(direccionDTO.getIdDireccion(), direccionDTO.getCalle(), direccionDTO.getNum_interior(), direccionDTO.getNum_exterior(), direccionDTO.getColonia(), direccionDTO.getCodigo_postal(), direccionDTO.getCiudad(), direccionDTO.getEstado());			
		try {
			id = this.direccionService.guardarDireccion(direccion2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@DeleteMapping("/borrarDireccion/{idDireccion}")
	public ResponseEntity<?> borrarDireccion(@PathVariable("idDireccion") int idDireccion) {
		direccionService.borrarDireccion(idDireccion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
