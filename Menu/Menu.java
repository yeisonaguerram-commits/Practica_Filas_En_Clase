package Menu;

import java.util.Scanner;
import Validaciones.Validaciones;
import Metodos.Metodos;
import Importaciones.Importaciones;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validaciones V = new Validaciones();
        Metodos m = new Metodos();
        Importaciones imp = new Importaciones();

        System.out.println("Cargando base de datos de canciones...");
        String resultadoCarga = imp.ImportarArchivo(m);
        System.out.println("[SISTEMA] " + resultadoCarga);
        System.out.println();

        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println();
            System.out.println("1) Registrar venta");
            System.out.println("2) Mostrar las ventas");
            System.out.println("3) Buscar una venta");
            System.out.println("4) modificar venta");
            System.out.println("5) Cancelar una venta");
            System.out.println("6) Eliminar una venta");
            System.out.println("7) Generar informe");
            System.out.println("8) Salir del programa");

            int opcion = V.ValidarEntero(sc);

            switch (opcion) {
                case 1:
                    m.RegistrarVenta(sc, V);
                    break;
                case 2:
                    m.MostrarFacturas(sc, V);
                    break;
                case 3:
                    System.out.println("en mantenimiento");
                    break;
                case 4:
                    System.out.println("en mantenimiento");
                    break;
                case 5:
                    System.out.println("en mantenimiento");
                    break;
                case 6:
                    System.out.println("en mantenimiento");
                    break;
                case 7:
                    System.out.println("en mantenimiento");
                    break;
                case 8:
                    System.out.println("Saliendo del programa, hasta luego XD");
                    ejecutar = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Opcion invalida. Por favor, marca 1, 2 o 3.");
                    break;
            }
        }
        sc.close();
    }
}
