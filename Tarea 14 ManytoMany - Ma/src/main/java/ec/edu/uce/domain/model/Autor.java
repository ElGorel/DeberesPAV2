package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="autor")
public class Autor {

@SequenceGenerator(name = "seq_auto_generador", sequenceName = "seq_auto", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auto_generador")
@Id
@Column(name="auto_id")    
private Integer id;

@Column(name="auto_nombre")
private String nombre;

@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
private List<Libro> libros;






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

public List<Libro> getLibros() {
    return libros;
}

public void setLibros(List<Libro> libros) {
    this.libros = libros;
}







}
