package crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.dto.PasatiempoDTO;
import crud.entity.Pasatiempo;
import crud.service.PasatiempoService;

@RestController
public class PasatiempoController {
	
	@Autowired
	public PasatiempoService pasatiempoService;
	
	@GetMapping("/listaPasatiempos")
	public ResponseEntity<List<Pasatiempo>> listaPasatiempo() {
		List<Pasatiempo> Pasatiempos = pasatiempoService.listaPasatiempo();
		return new ResponseEntity<List<Pasatiempo>>(Pasatiempos, HttpStatus.OK);	
	}
	
	
	@GetMapping("/pasatiempo/{idPasatiempo}")
	public ResponseEntity<PasatiempoDTO> obtenerPasatiempo(@PathVariable("idPasatiempo") int idPasatiempo) { 
		return new ResponseEntity<>(new PasatiempoDTO(this.pasatiempoService.obtenerPorId(idPasatiempo)),HttpStatus.OK);
	}
	
	
	@PutMapping("/guardarPasatiempo")
	public ResponseEntity<Integer> guardarPasatiempo(@RequestBody Pasatiempo pasatiempo) {
		Integer id = 0;
		try {
			id = this.pasatiempoService.guardarPasatiempo(pasatiempo);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@PutMapping("/guardarPasatiempoDTO")
	public ResponseEntity<Integer> guardarPasatiempo(@RequestBody PasatiempoDTO pasatiempoDTO) {
		Integer id = 0;
		Pasatiempo pasatiempo2 = new Pasatiempo(pasatiempoDTO.getNombre(), pasatiempoDTO.getPasatiempo());
		try {
			id = this.pasatiempoService.guardarPasatiempo(pasatiempo2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@DeleteMapping("/borrarPasatiempo/{idPasatiempo}")
	public ResponseEntity<?> borrarPersona(@PathVariable("idPasatiempo") int idpasatiempo) {
		pasatiempoService.borrarPasatiempo(idpasatiempo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
