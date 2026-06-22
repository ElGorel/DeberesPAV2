package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Pelicula;
import ec.edu.uce.domain.repository.PeliculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PeliculaService {

    @Inject
    private PeliculaRepository peliculaRepository;

    public void registrarPelicula(Pelicula pelicula) {
        System.out.println("Guardando Pelicula: " + pelicula.getNombre());
        this.peliculaRepository.insertar(pelicula);
    }

    public Pelicula consultarPelicula(Integer id) {
        System.out.println("Consultando Pelicula: " + id);
        return this.peliculaRepository.consultar(id);
    }
}
