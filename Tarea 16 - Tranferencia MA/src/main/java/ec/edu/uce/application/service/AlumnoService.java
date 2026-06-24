package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoService {

    @Inject
    private AlumnoRepository alumnoRepository;

    public void registrarAlumno(Alumno alumno) {
        System.out.println("Guardando Alumno: " + alumno.getNombre());
        this.alumnoRepository.insertar(alumno);
    }

    public Alumno consultarAlumno(Integer idalumno) {
        System.out.println("consutltando alumno: " + idalumno);
        Alumno alumno = this.alumnoRepository.consultar(idalumno);
        return alumno;
    }
}
