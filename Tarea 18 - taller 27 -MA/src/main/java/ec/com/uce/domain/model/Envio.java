package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="envio")
@Entity
public class Envio extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_envio_generador", sequenceName = "seq_envio", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_envio_generador")
    @Id
    @Column(name="env_id")
    private Integer id;

    @Column(name="env_direccion")
    private String direccion;

    @Column(name="env_empresa_transporte")
    private String empresaTransporte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }
}
