package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta_bancaria")
public class CuentaBancaria {


    @SequenceGenerator(name = "seq_cuen_generador", sequenceName = "seq_cuen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuen_generador")
    @Id
    @Column(name="cuen_id")    
    private Integer id;

    @Column(name="cuen_titular") 
    private String titular;

    @Column(name="cuen_saldo") 
    private Double saldo;

    @Column(name="cuen_numero_cuenta") 
    private String numeroCuenta;


    @OneToMany(mappedBy = "cuentaOrigen")
    private List<Transferencia> transferenciasEnviadas;

    @OneToMany(mappedBy = "cuentaDestino")
    private List<Transferencia> transferenciasRecibidas;



    //Get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<Transferencia> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }

    public void setTransferenciasEnviadas(List<Transferencia> transferenciasEnviadas) {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }

    public List<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }

    public void setTransferenciasRecibidas(List<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }


    
}
