package Importaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import Metodos.Metodos;
import Objetolista.Objetolista;

public class Importaciones {
    public String ImportarArchivo(Metodos m) {
        String rutaArchivo = "datos.txt";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            Objetolista obj = null;

            // Variables temporales para acumular los datos de la factura actual
            String numeroFactura = "";
            String nombreCliente = "";
            String nombreVendedor = "";
            double valor = 0.0;
            int cantidad = 0;
            String estado = "";

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Ignora líneas vacías o separadores como "-------"
                if (linea.isEmpty() || linea.startsWith("-")) {
                    continue;
                }

                // Cada vez que encuentra "Factura: ", guarda la anterior (si existe) e inicia una nueva
                if (linea.startsWith("Factura: ")) {
                    if (obj != null) {
                        m.agregarNodoDirecto(obj);
                        contador++;
                    }
                    numeroFactura = linea.substring(9).trim();
                    
                    // Creamos el objeto con los datos iniciales (usando el constructor corregido que no pide siguiente/anterior)
                    obj = new Objetolista(numeroFactura, "", "", 0.0, 0, "");

                } else if (linea.startsWith("Cliente: ")) {
                    if (obj != null) {
                        nombreCliente = linea.substring(9).trim();
                        obj.setNombre_Cliente(nombreCliente);
                    }

                } else if (linea.startsWith("Vendedor: ")) {
                    if (obj != null) {
                        nombreVendedor = linea.substring(10).trim();
                        obj.setNombre_Vendedor(nombreVendedor);
                    }

                } else if (linea.startsWith("Valor: ")) {
                    if (obj != null) {
                        valor = Double.parseDouble(linea.substring(7).trim());
                        obj.setValor(valor);
                    }

                } else if (linea.startsWith("Cantidad: ")) {
                    if (obj != null) {
                        cantidad = Integer.parseInt(linea.substring(10).trim());
                        obj.setCantidad(cantidad);
                    }

                } else if (linea.startsWith("Estado: ")) {
                    if (obj != null) {
                        estado = linea.substring(8).trim();
                        obj.setEstado(estado);
                    }
                }
            }

            // Al terminar el archivo, guardamos la última factura procesada
            if (obj != null) {
                m.agregarNodoDirecto(obj);
                contador++;
            }

        } catch (Exception e) {
            return "Error al cargar el archivo de datos: " + e.getMessage();
        }

        return "Archivo importado correctamente. Facturas cargadas: " + contador;
    }
}
