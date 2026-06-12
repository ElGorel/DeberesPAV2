package ec.edu.uce.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "oficinas")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubicacion; // Ej: "Facultad de Ingeniería UCE, 3er Piso"
    private String numero;    // Ej: "Cubículo 304"

    // Relación bidireccional (opcional, pero útil si necesitas saber quién ocupa la oficina)
    @OneToOne(mappedBy = "oficina")
    private Profesor profesor;

    // Constructores
    public Oficina() {}

    public Oficina(String ubicacion, String numero) {
        this.ubicacion = ubicacion;
        this.numero = numero;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
}
