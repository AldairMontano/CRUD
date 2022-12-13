package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.entity.Direccion;
import crud.repository.DireccionRepository;

@Service
public class DireccionService {
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	public List<Direccion> listaDireccion() {
		return direccionRepository.findAll();
	}
	
	public Direccion obtenerPorId(int idDireccion) {
		return this.direccionRepository.findById(idDireccion).get();
	}
	
	public Integer guardarDireccion(Direccion direccion) {
		direccionRepository.save(direccion);
		return direccion.getIdDireccion();
	}
	
	public void borrarDireccion(int idDireccion) {
		direccionRepository.deleteById(idDireccion);
	}
	
	public boolean existeDireccion(int idDireccion) {
		return direccionRepository.existsById(idDireccion);
	}

}
