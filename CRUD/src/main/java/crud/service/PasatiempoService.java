package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.entity.Pasatiempo;
import crud.repository.PasatiempoRepository;

@Service
public class PasatiempoService {

	@Autowired
	private PasatiempoRepository pasatiempoRepository;
	
	public List<Pasatiempo> listaPasatiempo() {
		return pasatiempoRepository.findAll();
	}
	
	public Pasatiempo obtenerPorId(int idPasatiempo) {
		return this.pasatiempoRepository.findById(idPasatiempo).get();
	}
	
	public Integer guardarPasatiempo(Pasatiempo pasatiempo) {
		pasatiempoRepository.save(pasatiempo);
		return pasatiempo.getIdPasatiempo();
	}
	
	public void borrarPasatiempo(int idPasatiempo) {
		pasatiempoRepository.deleteById(idPasatiempo);
	}
	
	public boolean existePasatiempo(int idPasatiempo) {
		return pasatiempoRepository.existsById(idPasatiempo);
	}
}
