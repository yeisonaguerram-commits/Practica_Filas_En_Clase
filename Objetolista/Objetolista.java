package Objetolista;

public class Objetolista {
    private String Numero_Factura;
    private String Nombre_Cliente;
    private String Nombre_Vendedor;
    private double Valor;
    private int Cantidad;
    private String Estado;
    private Objetolista Siguiente;
    private Objetolista Anterior;
    public Objetolista(String numero_Factura, String nombre_Cliente, String nombre_Vendedor, double valor, int cantidad,
            String estado) {
        Numero_Factura = numero_Factura;
        Nombre_Cliente = nombre_Cliente;
        Nombre_Vendedor = nombre_Vendedor;
        Valor = valor;
        Cantidad = cantidad;
        Estado = estado;
        Siguiente = null;
        Anterior = null;
    }
    public String getNumero_Factura() {
        return Numero_Factura;
    }
    public void setNumero_Factura(String numero_Factura) {
        Numero_Factura = numero_Factura;
    }
    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }
    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }
    public String getNombre_Vendedor() {
        return Nombre_Vendedor;
    }
    public void setNombre_Vendedor(String nombre_Vendedor) {
        Nombre_Vendedor = nombre_Vendedor;
    }
    public double getValor() {
        return Valor;
    }
    public void setValor(double valor) {
        Valor = valor;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public Objetolista getSiguiente() {
        return Siguiente;
    }
    public void setSiguiente(Objetolista siguiente) {
        Siguiente = siguiente;
    }
    public Objetolista getAnterior() {
        return Anterior;
    }
    public void setAnterior(Objetolista anterior) {
        Anterior = anterior;
    }
}
