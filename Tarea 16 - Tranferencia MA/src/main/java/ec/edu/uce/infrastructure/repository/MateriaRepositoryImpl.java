package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class MateriaRepositoryImpl implements MateriaRepository{

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Materia materia) {
      this.em.persist(materia);
    }

    @Override
    public Materia consultar(Integer id) {
      return this.em.find(Materia.class, id);
      
    }

}
