package com.tfc.torneo.restJpa.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	protected void configure(AuthenticationManagerBuilder auth)  throws Exception{

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select nick,"
				+ "password from Usuarios where nick=?").authoritiesByUsernameQuery("select"
						+ " u.id_usuario, p.descripcion from Usuario_priv up inner join Usuarios u on"
						+ " u.id_usuario= up.id_usuario inner join tipo_priv p on p.id_tpriv = up.id_tpriv"
						+ " where u.id_usuario= ?");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/bootstrap/**","/imagenes/**","/css/**","/script/**").permitAll()
		.antMatchers("/rest/usuario/alta", "/rest/usuario/iniciar/{nick}/{clave}","/rest/torneo/todos",
				 "/rest/torneo/crearTorneo/{idUsuario}/{tJuego}","/rest/usuario/mostrarUsu/{idUsuario}",
				 "/rest/usuario/editarUsu","/rest/torneo/buscador/{nombre}", "/rest/torneo/buscadorTj/{videojuego}",
				 "/rest/reserva/reTor/{idUsuario}", "/rest/tarjeta/all/{idUsuario}", "/rest/tarjeta/num/{numero}",
				 "/rest/tarjeta/deleteTar/{numero}/{idUsuario}", "/rest/tarjeta/addTar/{idUsuario}", 
				 "/rest/reserva/todos/{idUsurio}", "/rest/torneo/todosCreados/{idUsuario}",
				 "/rest/usuario/tipoUsu/{idUsuario}", "/rest/usuario/suscribirseTusu/{idUsuario}/{idTusu}").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll();
	}

}
