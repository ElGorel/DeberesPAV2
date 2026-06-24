package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repository.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CiudadanoService {

    @Inject
    private CiudadanoRepository ciudadanoRepository;

    public void registrarCiudadano(Ciudadano ciudadano) {
        System.out.println("Guardando ciudadano: " + ciudadano.getNombre());
        this.ciudadanoRepository.insertar(ciudadano);
    }
}
