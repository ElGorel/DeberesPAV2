package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmpleadoService {

@Inject
private EmpleadoRepository empleadoRepository;
@Inject
private CiudadanoService ciudadanoService;

@Transactional
public void registrarEmpleado(Empleado empleado) {

    //Ciudadano ciudadano = new Ciudadano();
    //        ciudadano.setNombre("Jorge Carrera");
    //        ciudadano.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 8, 30));

    //        this.ciudadanoService.registrarCiudadano(ciudadano);
    //        System.out.println("Ciudadano insertado con éxito. ID Asignado: " + ciudadano.getId());
    //        empleado.setCiudadano(ciudadano);


        this.empleadoRepository.insertar(empleado);
    }




}
