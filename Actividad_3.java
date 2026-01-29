import java.util.Scanner;

public class Actividad_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto po1 = new Producto();
        Producto po2 = new Producto();

        System.out.println("--- Ingreso de datos para el producto 1 ---");
        capturarDatosProducto(scanner, po1);
        System.out.println("\n--- Ingreso de datos para el producto 2 ---");
        capturarDatosProducto(scanner, po2);

        System.out.println("\n--- Visualización de Productos ---");
        po1.muestraProducto();
        System.out.println("");
        po2.muestraProducto();

        System.out.println("\n--- Comparación de Precios ---");
        String resultado = compararProductos(po1, po2);
        System.out.println(resultado);

        scanner.close();
    }
    public static void capturarDatosProducto(Scanner scanner, Producto p) {
        try {
            System.out.println("Ingrese el código: ");
            p.setCodigo(scanner.nextLine());

            System.out.println("Ingrese la descripción: ");
            p.setDescripcion(scanner.nextLine());

            System.out.println("Ingrese el tipo: ");
            p.setTipo(scanner.nextLine());

            System.out.println("Ingrese el costo: ");
            p.setCosto(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ingrese el impuesto %: ");
            p.setImpuesto(Double.parseDouble(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido.");
            capturarDatosProducto(scanner, p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String compararProductos(Producto po1, Producto po2) {
        double utilidadEstandar = 20.0;

        double precio1 = po1.calcularPrecio(utilidadEstandar);
        double precio2 = po2.calcularPrecio(utilidadEstandar);

        if (precio1 > precio2) {
            return "El producto más caro es: " + po1.getDescripcion() +
                    " (Precio: $" + String.format("%.2f", precio1) + ")";
        } else if (precio2 > precio1) {
            return "El producto con mayor precio es: " + po2.getDescripcion() +
                    " (Precio: $" + String.format("%.2f", precio2) + ")";
        } else {
            return "Los productos tienen el mismo precio: $" + String.format("%.2f", precio1);
        }
    }
}