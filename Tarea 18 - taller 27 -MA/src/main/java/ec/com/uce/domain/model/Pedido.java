package ec.com.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="pedido")
@Entity
public class Pedido extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_pedido_generador", sequenceName = "seq_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido_generador")
    @Id
    @Column(name="pedi_id")
    private Integer id;

    @Column(name="pedi_fecha")
    private LocalDate fecha;

    @Column(name="pedi_cliente_ruc")
    private String clienteRuc;

    @Column(name="pedi_total")
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getClienteRuc() {
        return clienteRuc;
    }

    public void setClienteRuc(String clienteRuc) {
        this.clienteRuc = clienteRuc;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
