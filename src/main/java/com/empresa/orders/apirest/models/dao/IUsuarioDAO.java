package com.empresa.orders.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.empresa.orders.apirest.models.entities.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	
	public Usuario findByuserName(String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.userName=?1")
	public Usuario findByuserName2(String usuario);

}
