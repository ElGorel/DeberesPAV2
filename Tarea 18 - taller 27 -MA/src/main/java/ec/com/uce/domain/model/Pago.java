package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="pago")
@Entity
public class Pago extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_pago_generador", sequenceName = "seq_pago", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pago_generador")
    @Id
    @Column(name="pag_id")
    private Integer id;

    @Column(name="pag_pedido_id")
    private Integer pedidoId;

    @Column(name="pag_monto")
    private Double monto;

    @Column(name="pag_estado")
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
