package ec.edu.uce;

import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Oficina;
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

        // Inyectamos nuestro servicio
        @Inject
        private ProfesorService profesorService;

        @Override
        @Transactional
        public int run(String... args) {

            // 1. Creamos la instancia de Oficina
            Oficina oficina = new Oficina();
            oficina.setUbicacion("Facultad de Ingeniería UCE - Campus Quito");
            oficina.setNumero("Cubículo 412");

            // 2. Creamos la instancia de Profesor
            Profesor profesor = new Profesor();
            profesor.setNombre("Ing. Marco Antonio");
            profesor.setEspecialidad("Desarrollo de Software");

            // 3. Enlazamos la relación bidireccional / OneToOne
            profesor.setOficina(oficina);

            // 4. Persistimos los datos a través del servicio
            this.profesorService.guardar(profesor);

            // 5. Comprobación en consola
            System.out.println("==========================================");
            System.out.println("Profesor y Oficina insertados con éxito.");
            System.out.println("ID Profesor Asignado: " + profesor.getId());
            System.out.println("ID Oficina Asignada: " + profesor.getOficina().getId());
            System.out.println("==========================================");

            return 0;
        }
    }
}