package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public void registrarMateria(Materia materia) {
        System.out.println("Guardando Materia: " + materia.getNombre());
        this.materiaRepository.insertar(materia);
    }

    public Materia consultarMateria(Integer idmateria) {
        System.out.println("consutltando Materia: " + idmateria);
        Materia materia = this.materiaRepository.consultar(idmateria);
        return materia;
    }

}
