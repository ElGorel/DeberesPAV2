package ec.com.uce.web.resource;

import ec.com.uce.application.service.ProductoService;
import ec.com.uce.domain.model.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/productos")
public class ProductoResource {

     @Inject
    private ProductoService productoService;

    public Producto buscarPorId(Integer id){
        return this.productoService.buscarporId(id);
    }


}
