package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.inject.Inject;

public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public void registrarCiudadano(Cliente cliente) {
        System.out.println("Guardando ciudadano: " + cliente.getNombre());
        this.clienteRepository.insertar(cliente);
    }


}
