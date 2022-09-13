package com.empresa.orders.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.orders.apirest.models.entities.Categoria;
import com.empresa.orders.apirest.services.interfaces.ICategoriaService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")

public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/categorias")
	public List<Categoria> getAll(){
		return categoriaService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/categorias/{id}")
	public ResponseEntity <?>getById(@PathVariable Long id) {
		Categoria categoria = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoria = categoriaService.findById(id);
		}catch(DataAccessException e) {
			response.put("message","Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage());
		}
		if(categoria == null) {
			response.put("message", "La categoria con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/categorias")
	public ResponseEntity<?> save(@RequestBody Categoria categoria){
		Map<String, Object> response = new HashMap<>();
		try {
			if(categoriaService.findByNombre(categoria.getNombre()).size() > 0 && categoria.getId() == null) {
				response.put("message", "Ya existe una categoria con este nombre en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
			}else {
				categoriaService.save(categoria);
			}
		}catch(DataAccessException e){
			response.put("message", "Error al insertar el registro en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("message", "Categoria registrado con exito");
		response.put("categoria", categoria);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/categorias/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Long id){
		Categoria categoriaActual = categoriaService.findById(id);
		Categoria categoriaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if(categoriaActual == null) {
			response.put("message", "Error: no se puede editar, la categoria con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
		}
		try {
			categoriaActual.setNombre(categoria.getNombre());
			categoriaUpdated = categoriaService.save(categoriaActual);
		}catch(DataAccessException e){
			response.put("message", "Error al actualizar el registro en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("message", "Categoria actualizada con exito");
		response.put("categoria", categoriaUpdated);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			categoriaService.delete(id);
		}catch(DataAccessException e) {
			response.put("message", "Error al eliminar la categoria de la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("message", "Categoria ha sido eliminada...");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
