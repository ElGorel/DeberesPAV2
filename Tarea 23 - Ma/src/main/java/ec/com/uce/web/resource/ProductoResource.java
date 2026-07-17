package ec.com.uce.web.resource;

import java.util.List;

import ec.com.uce.application.service.ProductoService;
import ec.com.uce.domain.model.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/producto")
public class ProductoResource {
    @Inject
    public ProductoService productoService;

    @Path("/porId/{id}")
    @GET
    public Producto buscarPorId(@PathParam("id") Integer id){
        return this.productoService.buscarporId(id);
    }

     @Path("/todos")   
    @GET
    public List<Producto> buscarTodos(){
        return this.productoService.buscartodos();
    }

    @Path("/guardar")
    @POST
    public void guardar(Producto producto){
        this.productoService.guardar(producto);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Producto producto, @PathParam("id") Integer id){
        this.productoService.actualizar(producto, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){
        this.productoService.eliminar(id);
    }

}