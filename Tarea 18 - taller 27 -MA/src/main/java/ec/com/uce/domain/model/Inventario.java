package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="inventario")
@Entity
public class Inventario extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_inventario_generador", sequenceName = "seq_inventario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventario_generador")
    @Id
    @Column(name="inv_id")
    private Integer id;

    @Column(name="inv_producto")
    private String producto;

    @Column(name="inv_cantidad_reservada")
    private Integer cantidadReservada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(Integer cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }
}
