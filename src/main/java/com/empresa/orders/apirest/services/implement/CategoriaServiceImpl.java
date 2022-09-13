package com.empresa.orders.apirest.services.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.orders.apirest.models.dao.ICategoriaDAO;
import com.empresa.orders.apirest.models.entities.Categoria;
import com.empresa.orders.apirest.services.interfaces.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>)categoriaDAO.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return categoriaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDAO.save(categoria);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoriaDAO.deleteById(id);
	}

	@Override
	public List<Categoria> findByNombre(String nombre) {
		return categoriaDAO.findByNombreIgnoreCase(nombre);
	}
}
