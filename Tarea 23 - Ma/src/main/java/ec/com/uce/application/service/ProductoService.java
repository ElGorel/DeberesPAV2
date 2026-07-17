package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.Infraestructure.repository.ProductoRepositoryImpl;
import ec.com.uce.domain.model.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProductoService {

     @Inject
    private ProductoRepositoryImpl productoRepositoryImpl;

    public List<Producto> buscartodos(){
        return (List<Producto>) this.productoRepositoryImpl.findAll();
    }


    public Producto buscarporId(Integer id){
        return (Producto) this.productoRepositoryImpl.findById(id);
    }

    public void guardar (Producto producto){
        this.productoRepositoryImpl.persist(producto);
    }

    public void eliminar ( Integer id ){
        this.productoRepositoryImpl.delete(this.buscarporId(id));
    }

    public void actualizar (Producto productoactualizado,Integer id){
        Producto productoBase=this.buscarporId(id);
        productoBase.setNombre(productoactualizado.getNombre());
        productoBase.setCategoria(productoactualizado.getCategoria());
        productoBase.setPrecio(productoactualizado.getPrecio());
        productoBase.setStock(productoactualizado.getStock());
        // no hace falta realizar explicitamente un update, se sincroniza con la base automaticamente
    }

   


}
