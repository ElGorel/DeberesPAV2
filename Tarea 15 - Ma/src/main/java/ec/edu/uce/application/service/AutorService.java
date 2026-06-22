package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AutorService {

    @Inject
    private AutorRepository autorRepository;

    public void registrarAutor(Autor autor) {
        System.out.println("Guardando autor: " + autor.getNombre());
        this.autorRepository.insertar(autor);
    }

    public Autor consultarAutor(Integer id) {
        System.out.println("Consultando autor: " + id);
        return this.autorRepository.consultar(id);
    }



}
