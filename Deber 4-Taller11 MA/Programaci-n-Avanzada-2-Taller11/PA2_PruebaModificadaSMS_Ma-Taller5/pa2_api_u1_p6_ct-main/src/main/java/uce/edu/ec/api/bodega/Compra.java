package uce.edu.ec.api.bodega;

public class Compra {

    private String cliente;
    private double subTotal;
    private double total;

    // Constructores
    public Compra(){

    }
    public Compra(String cliente, double subtotal) {
        this.cliente = cliente;
        this.subTotal = subtotal;
    }



    // set y get
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    

}
