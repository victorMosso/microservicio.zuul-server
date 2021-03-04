package com.udemy.ms.springboot.app.zuul.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{

	@Value("${config.security.oauth.jwt.key}")
	private String keyToken;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/seguridad/oauth/token").permitAll()
		.antMatchers(HttpMethod.GET,"/api/productos/prd/listar","/api/items/itm/listar",
				"/api/usuarios/repoUsuarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api/productos/prd/ver/{id}",
				"/api/items/itm/ver/{id}/cantidad/{cant}",
				"/api/usuarios/repoUsuarios/{id}").hasAnyRole("ADMIN","USER")
/*		Forma generica
		.antMatchers("/api/productos/prd/**","/api/items/itm/**","/api/usuarios/repoUsuarios/**").hasRole("ADMIN")*/
//Forma especifica 
		.antMatchers(HttpMethod.POST,"/api/productos/prd/crear",
				"/api/items/itm/crear",
				"/api/usuarios/repoUsuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/api/productos/prd/editar/{id}",
				"/api/items/itm/editar/{id}",
				"/api/usuarios/repoUsuarios/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/productos/prd/eliminar/{id}",
				"/api/items/itm/eliminar/{id}",
				"/api/usuarios/repoUsuarios/{id}").hasRole("ADMIN")
		.anyRequest().authenticated();
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(keyToken);
		return tokenConverter;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}


}
