package crud.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

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
		Document document = new Document();
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte_personas.pdf"));
			document.open();
			PdfPTable tabla = new PdfPTable(4);
			tabla.addCell("Id");
			tabla.addCell("Nombre");
			tabla.addCell("Apellidos");
			tabla.addCell("Id_Direccion");
			try {
				Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456");
				PreparedStatement pStatement = cn.prepareStatement("select * from personas2");
				
				ResultSet rSet = pStatement.executeQuery();
				
				if (rSet.next()) {
					do {
						tabla.addCell(rSet.getString(1));
						tabla.addCell(rSet.getString(3));
						tabla.addCell(rSet.getString(2));
						tabla.addCell(rSet.getString(4));
					} while (rSet.next());
					
					document.add(tabla);
				}
			} catch (Exception e) {
				
			}
			document.close();
			JOptionPane.showMessageDialog(null, "Reporte Creado");
		} catch (Exception e) {
			
		}
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
