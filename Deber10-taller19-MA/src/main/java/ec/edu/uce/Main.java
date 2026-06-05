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
            
            System.out.println("Conexion a base de datos exitosa\n");

            Profesor p1 = new Profesor();
            p1.setCedula("1805223045");
            p1.setNombre("Marco");
            p1.setApellido("Andrade");
            p1.setGenero("Masculino");
            p1.setEspecialidad("Programacion");
            p1.setFechaDocencia(LocalDate.of(2000, 7, 07)); // Nuevo campo
            this.profesorService.guardarProfesor(p1);
            System.out.println("Guardado con exito: " + p1.getNombre());

            Profesor p2 = new Profesor();
            p2.setCedula("23146549825");
            p2.setNombre("Edison");
            p2.setApellido("Cayambe");
            p2.setGenero("Masculino");
            p2.setEspecialidad("Programacion");
            p2.setFechaDocencia(LocalDate.of(1985, 10, 7)); // Nuevo campo
            this.profesorService.guardarProfesor(p2);
            System.out.println("Guardado con exito: " + p2.getNombre());


            Profesor p3 = new Profesor();
            p3.setCedula("32154855421");
            p3.setNombre("Oscar");
            p3.setApellido("Toalombo");
            p3.setGenero("Masculino");
            p3.setEspecialidad("Algebra"); 
            p3.setFechaDocencia(LocalDate.of(1964, 1, 4)); // Nuevo campo
            this.profesorService.guardarProfesor(p3);
            System.out.println("Guardado con exito: " + p3.getNombre());
            
            System.out.println("Lista completa de profesores:");
            this.profesorService.listarTodos();

            System.out.println("Por cedula:");
            Profesor profeCedula = this.profesorService.consultarPorCedula("1805223045");
            System.out.println("Buscando cédula '1805223045' -> Encontrado: " + profeCedula.getNombre() + " " + profeCedula.getApellido());

            System.out.println("Por Apellido (Andrade):");
            this.profesorService.consultarPorApellido("Andrade"); 

            System.out.println("Por Especialidad (Programacion):");
            this.profesorService.consultarPorEspecialidad("Programacion");

            System.out.println("Actualizacion:");
            p2.setNombre("Alexander"); 
            p2.setApellido("Salvador");
            this.profesorService.actualizarProfesor(p2);
            Profesor profeActualizado = this.profesorService.buscarProfesor(p2.getId());
            System.out.println("Nombre actualizado de ID " + p2.getId() + " a: " + profeActualizado.getNombre() + " " + profeActualizado.getApellido());

            System.out.println("Eliminar profesor:");
            this.profesorService.eliminarProfesor(p3.getId());
            System.out.println("Profesor con ID " + p3.getId() + " eliminado.");

            System.out.println("Contar profesores restantes:");
            this.profesorService.contarProfesores();

            System.out.println("NativeQuery");
            this.profesorService.consultarTodosNative().forEach(p -> 
                System.out.println("Registrado: " + p.getNombre() + " " + p.getApellido())
            );

            this.profesorService.consultarPorEspecialidadNative("Programacion").forEach(p -> 
                System.out.println("Encontrado profe de Programacion: " + p.getNombre())
            );

            this.profesorService.consultarPorApellidoNative("Salvador").forEach(p -> 
                System.out.println("Encontrado apellido Salvador: " + p.getNombre())
            );

            Profesor profeCedulaNative = this.profesorService.consultarPorCedulaNative("1805223045");
            System.out.println("Encontrado por cédula (1805223045): " + profeCedulaNative.getNombre());

            System.out.println("Criteria API Query");
            this.profesorService.consultarTodosCriteria().forEach(p -> 
                System.out.println("- " + p.getNombre() + " " + p.getApellido())
            );

            System.out.println("API Query por nombre");
            this.profesorService.consultarPorNombreCriteria("Marco").forEach(p -> 
                System.out.println("- Encontrado: " + p.getNombre() + " " + p.getApellido())
            );
            
            System.out.println("API Query dinamica par los casos");
            this.profesorService.consultarDinamico("Alexander", "Salvador");
            this.profesorService.consultarDinamico("Alexander", null);
            this.profesorService.consultarDinamico(null, "Salvador");
            this.profesorService.consultarDinamico(null, null);
            
            return 0;
        }
    }
}