package ec.com.uce.infrastructure.repository;

import ec.com.uce.domain.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PedidoRepositoryImpl implements PanacheRepositoryBase<Pedido, Integer> {

    public Pedido buscarPorClienteRuc(String clienteRuc) {
        return find("clienteRuc", clienteRuc).firstResult();
    }
}
