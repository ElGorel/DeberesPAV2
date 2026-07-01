package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="notificacion")
@Entity
public class Notificacion extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_notificacion_generador", sequenceName = "seq_notificacion", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notificacion_generador")
    @Id
    @Column(name="not_id")
    private Integer id;

    @Column(name="not_destinatario")
    private String destinatario;

    @Column(name="not_mensaje")
    private String mensaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
