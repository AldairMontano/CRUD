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

import crud.dto.PersonaDTO;
import crud.entity.Persona;
import crud.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	public PersonaService personaService;
	
	@GetMapping("/persona/{idPersona}")
	public ResponseEntity<PersonaDTO> obtenerPersona(@PathVariable("idPersona") int idPersona) {
		return new ResponseEntity<>(new PersonaDTO(this.personaService.obtenerPorId(idPersona)),HttpStatus.OK);
	}
	
	@DeleteMapping("/borrarPersona/{idPersona}")
	public ResponseEntity<?> borrarPersona(@PathVariable("idPersona") int idPersona) {
		personaService.borrarPersona(idPersona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/listaPersonas")
	public ResponseEntity<List<Persona>> listaPersonas() {
		List<Persona> personas = personaService.listaPersona();
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	
	@PutMapping("/guardarPersona")
	public ResponseEntity<Integer> guardarPersona(@RequestBody Persona persona) {
		Integer id = 0;
		try {
			id = this.personaService.guardarPersona(persona);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PutMapping("/guardarPersonaDTO")
	public ResponseEntity<Integer> guardarPersona(@RequestBody PersonaDTO persona) {
		Integer id = 0;
		Persona persona2 = new Persona(persona.getNombre(), persona.getApellido());
		try {
			id = this.personaService.guardarPersona(persona2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		if (id == 0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<>(id,HttpStatus.OK); 
	}
}
