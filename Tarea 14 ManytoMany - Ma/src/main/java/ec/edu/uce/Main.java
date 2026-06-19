package ec.edu.uce;

import ec.edu.uce.application.service.AutorService;
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
        private AutorService autorService;
        

        @Inject
        EntityManager em;

        @Override
        public int run(String... args) {

            

            return 0;
        }
    }
}
