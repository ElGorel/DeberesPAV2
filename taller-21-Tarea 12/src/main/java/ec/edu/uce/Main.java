package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private CiudadanoService ciudadanoService;
        @Inject
        private EmpleadoService empleadoService;

        @Inject
        EntityManager em;

        @Override
        public int run(String... args) {


            //Ciudadano ciudadano = new Ciudadano();
            //ciudadano.setNombre("Edison Cayambe");
            //ciudadano.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 8, 30));

            //this.ciudadanoService.registrarCiudadano(ciudadano);
            // System.out.println("Ciudadano insertado con éxito. ID Asignado: " + ciudadano.getId());

            //Ciudadano ciudadano1 = new Ciudadano();
            //ciudadano1.setNombre("Marco Andrade");
            //ciudadano1.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 8, 30));


            //Empleado empleado = new Empleado();
            //empleado.setFechaIngreso(LocalDateTime.of(2026, 06, 14, 8, 30));
            //empleado.setSalario((double) 2000);
            //empleado.setCiudadano(ciudadano1);
            
            //this.empleadoService.registrarEmpleado(empleado);

            Ciudadano ciudadano3 = new Ciudadano();
            ciudadano3.setNombre("Jorge Carrera");
            ciudadano3.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 8, 30));

            //this.ciudadanoService.registrarCiudadano(ciudadano3);
            //System.out.println("Ciudadano insertado con éxito. ID Asignado: " + ciudadano3.getId());

            //ciudadano3.setNombre("Carlos Marin");

            Empleado empleado2 = new Empleado();
            empleado2.setFechaIngreso(LocalDateTime.of(2026, 06, 14, 8, 30));
            empleado2.setSalario( null);
            empleado2.setCiudadano(ciudadano3);
            
            this.empleadoService.registrarEmpleado(empleado2);








            return 0;
        }
    }
}
