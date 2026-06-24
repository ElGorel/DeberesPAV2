package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Transferencia;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface TranferenciaRepository {

    public void realizarTranferencia (Transferencia transferencia);

    public Transferencia consultar (Integer id);

}
