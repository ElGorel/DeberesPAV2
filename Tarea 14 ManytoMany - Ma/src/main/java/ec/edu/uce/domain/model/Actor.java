package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "actor")
@Entity
public class Actor {

@SequenceGenerator(name = "seq_actor_generador", sequenceName = "seq_actor", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_actor_generador")
@Id
@Column(name="acto_id")
private Integer id;

@Column(name = "acto_nombre")   
private String nombre;

@ManyToMany
private List<Pelicula> peliculas;



}
