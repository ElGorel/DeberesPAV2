package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.inject.Inject;

public class AutorService {

    @Inject
    private AutorRepository autorRepository;

    public void registrarAutor(Autor autor) {
        System.out.println("Guardando autor: " + autor.getNombre());
        this.autorRepository.insertar(autor);
    }



}
