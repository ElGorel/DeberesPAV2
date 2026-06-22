package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Pelicula;

public interface PeliculaRepository {
    void insertar(Pelicula pelicula);
    Pelicula consultar(Integer id);
}
