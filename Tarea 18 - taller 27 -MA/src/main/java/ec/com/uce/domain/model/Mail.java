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

@Table(name="mail")
@Entity
public class Mail extends PanacheEntityBase{

@SequenceGenerator(name = "seq_mail_generador", sequenceName = "seq_mail", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mail_generador")
    @Id
    @Column(name="mail_id")
    private Integer id;
    @Column(name="mail_asunto")
    private String asunto;
    @Column(name="mail_destinatario")
    private String destinatario;
    @Column(name="mail_fecha_envio")
    private LocalDate fecha_envio;







    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDate getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(LocalDate fecha_envio) {
        this.fecha_envio = fecha_envio;
    }





    
}
