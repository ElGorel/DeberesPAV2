package ec.edu.uce;

import java.time.LocalDate;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Profesor;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusMain
public class Main {
 
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private ProfesorService profesorService;
        
        @Override
        @Transactional
        public int run(String... args) {
            
            System.out.println("Conexion a base de datos exitosa");
            Profesor p1 = new Profesor();
            p1.setNombre("Alan");
            p1.setApellido("Turing");
            p1.setGenero("Masculino");
            p1.setCedula("0987654321");
            p1.setEspecialidad("Matematicas");
            // Nueva fecha de docencia
            p1.setFechaDocencia(LocalDate.of(2015, 6, 23));

            // Crear
            this.profesorService.guardarProfesor(p1);
            System.out.println("Profesor ID asignado: " + p1.getId());

            // Consultas
            this.profesorService.consultarPorNombre("Alan");
            this.profesorService.consultarPorCedula("0987654321");
            
            // Buscar 
            Profesor profesorBuscado = this.profesorService.buscarProfesor(p1.getId());
            System.out.println("Profesor encontrado: " + profesorBuscado.getNombre() );
            
            // Actualizar
            profesorBuscado.setNombre("Albert");
            profesorBuscado.setApellido("Einstein");
            profesorBuscado.setEspecialidad("Fisica");
            this.profesorService.actualizarProfesor(profesorBuscado);
            System.out.println("Profesor actualizado correctamente en la base de datos.");

            // Seleccionar por especialidad
            this.profesorService.consultarPorEspecialidad("Fisica");
            
            // Consultar por Apellido
            this.profesorService.consultarPorApellido(profesorBuscado.getApellido());

            // Contar
            this.profesorService.contarProfesores();
            
            return 0;
        }
    }
}