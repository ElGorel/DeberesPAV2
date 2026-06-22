package ec.edu.uce;

import ec.edu.uce.application.service.AutorService;
import ec.edu.uce.application.service.ActorService;
import ec.edu.uce.application.service.PeliculaService;
import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.model.Libro;
import ec.edu.uce.domain.model.Actor;
import ec.edu.uce.domain.model.Pelicula;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private AutorService autorService;

        @Inject
        private ActorService actorService;

        @Inject
        private PeliculaService peliculaService;

        @Inject
        EntityManager em;

        @Override
        @ActivateRequestContext
        public int run(String... args) {
            System.out.println("\n============ INICIO TAREA 15: CASCADE Y FETCH ============");

            // --- 1. PROBANDO CASCADE Y FETCH EN ONETOMANY (Autor -> Libro) ---
            System.out.println("\n1. Creando Autor y Libros...");
            Autor autor = new Autor();
            autor.setNombre("Gabriel Garcia Marquez");

            Libro libro1 = new Libro();
            libro1.setTitulo("Cien anos de soledad");
            libro1.setFechaPublicacion(LocalDate.of(1967, 5, 30));
            libro1.setAutor(autor);

            Libro libro2 = new Libro();
            libro2.setTitulo("El amor en los tiempos del colera");
            libro2.setFechaPublicacion(LocalDate.of(1985, 10, 5));
            libro2.setAutor(autor);

            autor.setLibros(new ArrayList<>(List.of(libro1, libro2)));

            System.out.println("Registrando Autor (los Libros se registraran en cascada)...");
            autorService.registrarAutor(autor);

            // Limpiamos la caché de primer nivel para forzar la lectura real de la BD
            em.clear();

            System.out.println("Consultando Autor con ID 1 (EAGER Fetch cargara los libros)...");
            Autor autorConsultado = autorService.consultarAutor(1);

            if (autorConsultado != null) {
                System.out.println("Autor: " + autorConsultado.getNombre());
                System.out.println("--- Libros del Autor (Cargados por EAGER Fetch) ---");
                for (Libro lib : autorConsultado.getLibros()) {
                    System.out.println("- " + lib.getTitulo() + " (Publicacion: " + lib.getFechaPublicacion() + ")");
                }
            } else {
                System.out.println("No se encontro el autor.");
            }

            // --- 2. PROBANDO CASCADE Y FETCH EN MANYTOMANY (Actor <-> Pelicula) ---
            System.out.println("\n2. Creando Actores y Pelicula...");
            Actor actor1 = new Actor();
            actor1.setNombre("Al Pacino");

            Actor actor2 = new Actor();
            actor2.setNombre("Marlon Brando");

            Pelicula pelicula = new Pelicula();
            pelicula.setNombre("El Padrino");
            pelicula.setFechaEstreno(LocalDate.of(1972, 3, 24));

            // Relacionar bidireccionalmente
            pelicula.setActores(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setPeliculas(new ArrayList<>(List.of(pelicula)));
            actor2.setPeliculas(new ArrayList<>(List.of(pelicula)));

            System.out.println("Registrando Pelicula (los Actores se registraran en cascada)...");
            peliculaService.registrarPelicula(pelicula);

            // Limpiamos la caché de primer nivel para forzar la lectura real de la BD
            em.clear();

            System.out.println("Consultando Pelicula con ID 1 (EAGER Fetch cargara los actores)...");
            Pelicula peliculaConsultada = peliculaService.consultarPelicula(1);

            if (peliculaConsultada != null) {
                System.out.println("Pelicula: " + peliculaConsultada.getNombre() + " (" + peliculaConsultada.getFechaEstreno() + ")");
                System.out.println("--- Actores en esta Pelicula (Cargados por EAGER Fetch) ---");
                for (Actor act : peliculaConsultada.getActores()) {
                    System.out.println("- " + act.getNombre());
                }
            } else {
                System.out.println("No se encontro la pelicula.");
            }

            System.out.println("Consultando Actor con ID 1 (EAGER Fetch cargara sus peliculas)...");
            Actor actorConsultado = actorService.consultarActor(1);
            if (actorConsultado != null) {
                System.out.println("Actor: " + actorConsultado.getNombre());
                System.out.println("--- Peliculas de este Actor (Cargadas por EAGER Fetch) ---");
                for (Pelicula peliAsoc : actorConsultado.getPeliculas()) {
                    System.out.println("- " + peliAsoc.getNombre());
                }
            } else {
                System.out.println("No se encontro el actor.");
            }

            System.out.println("\n============ FIN TAREA 15: CASCADE Y FETCH ============");
            return 0;
        }
    }
}
