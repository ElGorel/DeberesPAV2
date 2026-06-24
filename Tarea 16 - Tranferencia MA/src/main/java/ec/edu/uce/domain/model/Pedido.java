package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Table(name="pedido")
@Entity
public class Pedido {


    @SequenceGenerator(name = "seq_pedi_generador", sequenceName = "seq_pedi", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedi_generador")
    @Id
    @Column(name="pedi_id")
    private Integer id;
    @Column(name="pedi_total")
    private Double total;
    @Column(name="pedi_fecha")
    private LocalDate fecha;

    // al momento de mapear tiene que ser exato el nombre !!
    @ManyToOne
    private Cliente cliente;



    // set y get
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    




}
