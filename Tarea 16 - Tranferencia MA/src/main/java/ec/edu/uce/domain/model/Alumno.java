package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="alumno")
@Entity
public class Alumno {



    @SequenceGenerator(name = "seq_alum_generador", sequenceName = "seq_alum", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alum_generador")
    @Id
    @Column(name="alum_id")
    private Integer id;
    @Column(name="alum_nombre")
    private String nombre;

    @ManyToMany (cascade= CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name= "alumno_materia", joinColumns= @JoinColumn(name="alma_id_alumno"),inverseJoinColumns = @JoinColumn(name="alma_id_materia"))
    private List<Materia> materias;




    // set y get
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


    public List<Materia> getMaterias() {
        return materias;
    }

    
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

}
