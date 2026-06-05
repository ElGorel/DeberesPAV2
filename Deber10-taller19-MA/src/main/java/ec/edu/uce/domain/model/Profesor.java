package ec.edu.uce.domain.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
@NamedQueries({
        @NamedQuery(name = "Profesor.buscarPorEspecialidad", query = "SELECT p FROM Profesor p WHERE p.especialidad = :especialidad"),
        @NamedQuery(name = "Profesor.buscarPorApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
        @NamedQuery(name = "Profesor.contar", query = "SELECT COUNT(p) FROM Profesor p")
})
public class Profesor {

    @SequenceGenerator(name = "seq_profesor_generador", sequenceName = "seq_profesor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generador")
    @Column(name = "prof_id")
    @Id
    private Integer id;

    @Column(name = "prof_cedula", unique = true)
    private String cedula;

    @Column(name = "prof_nombre")
    private String nombre;

    @Column(name = "prof_apellido")
    private String apellido;

    @Column(name = "prof_genero")
    private String genero;

    @Column(name = "prof_especialidad")
    private String especialidad;

    @Column(name = "prof_fecha_docencia")
    private LocalDate fechaDocencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaDocencia() {
        return fechaDocencia;
    }

    public void setFechaDocencia(LocalDate fechaDocencia) {
        this.fechaDocencia = fechaDocencia;
    }
}