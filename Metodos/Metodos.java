package Metodos;

import java.util.Scanner;

import Objetolista.Objetolista;
import Validaciones.Validaciones;

public class Metodos {
    private Objetolista cabeza = null;
    private Objetolista cola = null;
    private Objetolista actual = null;
    private int Contador = 106;

    public String agregarNodoDirecto(Objetolista importado) {
        if (cabeza == null) {
            cabeza = importado;
            cola = importado;
            actual = importado;
        } else {
            cola.setSiguiente(importado);
            importado.setAnterior(cola);
            cola = importado;
        }
        return "OK";
    }

    public String RegistrarVenta(Scanner sc, Validaciones V) {
        System.out.println("Ingrese nombre del ciente: ");
        String NombreCliente = V.ValidarTexto(sc);
        System.out.println("Ingrese el nombre del vendedor: ");
        String NombreVendedor = V.ValidarTexto(sc);
        System.out.println("Ingrese la cantidad de productos vendidos: ");
        int Cantidad = V.ValidarEntero(sc);
        System.out.println("Valor total de la venta: ");
        double ValorTotal = V.ValidarDecimal(sc);
        String Estado = "Registrado";
        Contador++;
        String NumeroFactura = "F-" + Contador;

        Objetolista nuevo = new Objetolista(NumeroFactura, NombreCliente, NombreVendedor, ValorTotal, Cantidad, Estado);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }

        return "Factura agregada correctamente";
    } // FIN REGISTRAR VENTA

    public String MostrarFacturas(Scanner sc, Validaciones V) {
        Objetolista aux = cabeza;

        while (aux != null) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Factura#: "+ aux.getNumero_Factura());
            System.out.println("Nombre del cliente: " + aux.getNombre_Cliente());
            System.out.println("Nombre del vendedor: " + aux.getNombre_Vendedor());
            System.out.println("Cantidad de productos vendidos: "+ aux.getCantidad());
            System.out.println("Valor total de la venta: " + aux.getValor());
            System.out.println("Estado de la venta: " + aux.getEstado());
            System.out.println("---------------------------------------------------------");
            aux = aux.getSiguiente();
        }

        return "Lista de facturas";
    } // fin mostrar facturas
}
