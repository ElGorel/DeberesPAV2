package ec.edu.uce.domain.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "pelicula")
@Entity
public class Pelicula {


@SequenceGenerator(name = "seq_pelicula_generador", sequenceName = "seq_pelicula", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pelicula_generador")
@Id
@Column(name="peli_id")    
private Integer id;

@Column(name = "peli_nombre")
private String nombre;

@Column(name = "peli_fecha_estreno")
private LocalDate fechaEstreno;


@ManyToMany
@JoinTable(name= "pelicula_actor", joinColumns= @JoinColumn(name="peli_id"),inverseJoinColumns = @JoinColumn(name="acto_id"))
private List<Actor> actores;


}
