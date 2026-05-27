package ec.edu.uce;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.repository.ProfesorRepository;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private ProfesorRepository profesorRepository;

        @Inject
        private EstudianteService estudianteService;

        @Inject
        EntityManager em;

        @Override
        @Transactional
        public int run(String... args) {

            // profesorRepository.reiniciarSecuencia();
            Profesor p1 = new Profesor();
            p1.setCedula("1111111111");
            p1.setNombre("Zoila");
            p1.setApellido("Ruiz");
            p1.setGenero("Femenino");
            p1.setEspecialidad("Programacion");
            p1.setFechaNacimiento(LocalDate.of(1979, 3, 14));
            profesorRepository.crearProfe(p1);
            System.out.println("Guardado con exito");

            Profesor p2 = new Profesor();
            p2.setCedula("2222222222");
            p2.setNombre("Alex");
            p2.setApellido("Soldad");
            p2.setGenero("Masculino");
            p2.setEspecialidad("Programacion");
            p2.setFechaNacimiento(LocalDate.of(1985, 10, 7));
            profesorRepository.crearProfe(p2);
            System.out.println("Guardado con exito");


            Profesor p3 = new Profesor();
            p3.setCedula("3333333333");
            p3.setNombre("Oscar");
            p3.setApellido("Toalombo");
            p3.setGenero("Masculino");
            p3.setEspecialidad("Optimizacion"); 
            p3.setFechaNacimiento(LocalDate.of(1964, 1, 4)); 
            profesorRepository.crearProfe(p3);
            System.out.println("Guardado con exito");

            System.out.println("Lista completa de profesores \n");
            List<Profesor> todos = profesorRepository.listar();
            todos.forEach(p -> System.out.println("ID: " + p.getId() + ",  " + p.getNombre() + " " + p.getApellido()));

            System.out.println("Por cedula");
            Profesor profeCedula = profesorRepository.seleccionarPorCedula("2222222222");
            System.out.println("Buscando cédula '2222222222' -> Encontrado: " + profeCedula.getNombre() + " " + profeCedula.getApellido());

            System.out.println("Por Apellido");
            Profesor profeLike = profesorRepository.seleccionarPorApellido("Rui"); 
            System.out.println("Buscando apellido con 'Rui': " + profeLike.getNombre() + " " + profeLike.getApellido());

            System.out.println("Primero por especialidad");
            Profesor primerFisico = profesorRepository.seleccionarPrimeroPorEspecialidad("Programacion");
            System.out.println("Primer profe de programacion-> " + primerFisico.getNombre() + ". Del: "  + primerFisico.getFechaNacimiento());

            System.out.println("Ultipo por genero");
            Profesor ultimoMasculino = profesorRepository.seleccionarUltimoPorGenero("Masculino");
            System.out.println("Último profesor masculino insertado: " + ultimoMasculino.getNombre() + " ID: " + ultimoMasculino.getId() );

            System.out.println("Actualizacion");
            p2.setNombre("");
            p2.setApellido("Salvador");
            profesorRepository.actualizar(p2);
            Profesor profeActualizado = profesorRepository.buscarPorId(p2.getId());
            System.out.println("Nombre actualizado de ID " + p2.getId() + " a " + profeActualizado.getNombre());

            System.out.println("Eliminar profesor ID");
            profesorRepository.eliminar(p3.getId());
            System.out.println("Profesor con ID " + p3.getId() + " eliminado.");
            System.out.println("Cantidad de profesores restantes: " + profesorRepository.listar().size());

            return 0;
        }
    }
}