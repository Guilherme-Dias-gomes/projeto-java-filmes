package br.com.Fiap.filmeapi;

import java.sql.SQLException;
import java.util.List;

import br.com.Fiap.filmeapi.model.Filme;
import br.com.Fiap.filmeapi.service.FilmeService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("filme")
public class FilmeResource {
	
	private FilmeService service;

	public FilmeResource() throws SQLException {
		service = new FilmeService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filme> index() throws SQLException {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById() throws SQLException {
		var filme = service.findById();
		
		if (filme == null) {
			return Response.status(404).build();
		}
		
		return Response.ok(filme).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(Filme filme) throws SQLException{
		var filmeEncontrado = service.findById();
		
		if (filmeEncontrado == null) 
			return Response.status(Response.Status.NOT_FOUND).build();

		if (!service.atualizar(filme)) {
			return Response.status(Response.Status.BAD_REQUEST).build();			
		}
		
		return Response.ok().build();
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Filme filmes) {
    	if (!service.save(filmes)) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    }
    return Response.ok(filmes).build();
    	
    }
	
	@DELETE
	@Path("{id}")
	public Response delete() throws SQLException{
		var filme = service.findById();
		
		if (filme == null) 
			return Response.status(Response.Status.NOT_FOUND).build();
		
		return Response.ok(filme).build();
	}
}
