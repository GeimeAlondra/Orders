package com.empresa.orders.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.empresa.orders.apirest.models.entities.Usuario;
import com.empresa.orders.apirest.services.interfaces.IUsuarioService;

@Component
public class InfoAdditionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.findByUserName(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("complete_name", usuario.getNombre());
		info.put("email", usuario.getEmail());
		info.put("user_name", authentication.getName());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
