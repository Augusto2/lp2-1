package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.spring.mongo.Usuario;
import br.com.herbertrausch.spring.mongo.UsuarioService;


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UsuarioResource {

	UsuarioService service = new UsuarioService();
	
	@GET
	public List<Usuario> get() {
		
		return service.getAll();
		
	}
	
	@GET
	@Path("/nickname/{nickname}")
	public List<Usuario> getByNickname(@PathParam("nickname") String nickname) {
		return service.getByNickname(nickname);
	}
	
	
	
	@POST
	public void save(Usuario e){
		
		service.insert(e);
		
	}
    
}
