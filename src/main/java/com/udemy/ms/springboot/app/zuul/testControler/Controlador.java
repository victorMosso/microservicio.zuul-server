package com.udemy.ms.springboot.app.zuul.testControler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

	@Autowired
	private Environment env;

	@Value("${config.security.oauth.client.id}")
	private String clientId;

	@GetMapping("/obtenerConfiguracion")
	public ResponseEntity<?> getConfig(@Value("${config.security.oauth.client.secret}") String clientSecret) {
		String tokenKey = this.env.getProperty("config.security.oauth.jwt.key");

		Map<String, String> datosConfig = new HashMap<String, String>();
		datosConfig.put("TokenKey", tokenKey);
		datosConfig.put("ClientId", this.clientId);
		datosConfig.put("ClientSecret", clientSecret);
		return new ResponseEntity<Map<String, String>>(datosConfig, HttpStatus.OK);
	}

}
