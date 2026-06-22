package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {


@SequenceGenerator(name = "seq_libr_generador", sequenceName = "seq_libr", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libr_generador")
@Id
@Column(name="libr_id")   
private Integer id;

@Column(name="libr_titulo") 
private String titulo;

@Column(name="libr_fecha_publicacion")
private LocalDate fechaPublicacion;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "libr_autor_id")
private Autor autor;




public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public LocalDate getFechaPublicacion() {
    return fechaPublicacion;
}

public void setFechaPublicacion(LocalDate fechaPublicacion) {
    this.fechaPublicacion = fechaPublicacion;
}

public Autor getAutor() {
    return autor;
}

public void setAutor(Autor autor) {
    this.autor = autor;
}






}
