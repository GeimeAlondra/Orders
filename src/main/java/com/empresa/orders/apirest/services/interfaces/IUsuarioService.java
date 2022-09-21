package com.empresa.orders.apirest.services.interfaces;

import com.empresa.orders.apirest.models.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario findByuserName(String username);

}
