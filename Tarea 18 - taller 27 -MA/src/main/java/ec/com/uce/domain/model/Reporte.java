package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="reporte")
@Entity
public class Reporte extends PanacheEntityBase{

    @SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")
    @Id
    @Column(name="repo_id")
    private Integer id;
    @Column(name="repo_nombre")
    private String nombre;
    @Column(name="repo_texto")
    private String texto;



    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }



    
}
