package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="estudiante")
@Entity
public class Estudiante extends PanacheEntityBase {

    @SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante_generador")
    @Id
    @Column(name="est_id")
    private Integer id;

    @Column(name="est_nombre")
    private String nombre;

    @Column(name="est_apellido")
    private String apellido;

    @Column(name="est_cedula")
    private String cedula;

    @Column(name="est_correo")
    private String correo;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
