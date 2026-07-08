package ec.com.uce;

import ec.com.uce.application.service.EstudianteService;
import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.model.Estudiante;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private EstudianteService estudianteService;

        @Override
        @Transactional
        public int run(String... args) {
            System.out.println("\n=== INICIANDO PRUEBA DE AUDITORÍA CON INTERCEPTORES ===");

            // 1. Crear y Guardar Estudiante
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Juan");
            estudiante.setApellido("Perez");
            estudiante.setCedula("1712345678");
            estudiante.setCorreo("juan.perez@uce.edu.ec");

            System.out.println("\nEjecutando: guardarEstudiante...");
            this.estudianteService.guardarEstudiante(estudiante);

            // 2. Modificar y Actualizar Estudiante
            estudiante.setNombre("Juan Carlos");
            estudiante.setApellido("Perez Gomez");
            System.out.println("\nEjecutando: actualizarEstudiante...");
            this.estudianteService.actualizarEstudiante(estudiante);

            // 3. Eliminar Estudiante
            System.out.println("\nEjecutando: eliminarEstudiante...");
            this.estudianteService.eliminarEstudiante(estudiante.getId());

            // 4. Mostrar Resultados de la Tabla Auditoría
            System.out.println("\n=== REGISTROS EN LA TABLA DE AUDITORÍA ===");
            List<Auditoria> auditorias = Auditoria.listAll();
            if (auditorias.isEmpty()) {
                System.out.println("No se registraron auditorías en la base de datos.");
            } else {
                for (Auditoria aud : auditorias) {
                    System.out.println("ID Auditoría: " + aud.getId());
                    System.out.println("Método Interceptado: " + aud.getNombreMetodo());
                    System.out.println("Argumentos: " + aud.getArgumentos());
                    System.out.println("Fecha y Hora de Ejecución: " + aud.getFechaHoraEjecucion()); // Wait, was it getFechaHoraEjecucion or getFechaHoraExecution? In Auditoria.java we used getFechaHoraEjecucion!
                    // Let's make sure it is getFechaHoraEjecucion.
                    System.out.println("Tiempo de Ejecución: " + aud.getTiempoEjecucionMs() + " ms");
                    System.out.println("--------------------------------------------------");
                }
            }

            return 0;
        }
    }
}
