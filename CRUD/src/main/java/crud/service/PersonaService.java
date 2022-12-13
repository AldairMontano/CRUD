package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.entity.Persona;
import crud.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> listaPersona() {
		return personaRepository.findAll();
	}
	
	public Persona obtenerPorId(int idPersona) {
		return this.personaRepository.findById(idPersona).get();
	}
	
	public Integer guardarPersona(Persona persona) {
		personaRepository.save(persona);
		return persona.getIdPersona();
	}
	
	public void borrarPersona(int idPersona) {
		personaRepository.deleteById(idPersona);
	}
	
	public boolean existePersona(int idPersona) {
		return personaRepository.existsById(idPersona);
	}
}
