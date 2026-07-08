package ec.com.uce.application.service;

import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.infrastructure.repository.AuditoriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class AuditoriaService {

    @Inject
    private AuditoriaRepositoryImpl auditoriaRepositoryImpl;

    public void guardarAuditoria(Auditoria auditoria) {
        this.auditoriaRepositoryImpl.persist(auditoria);
    }
}
