import java.util.Scanner;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> inventario = new HashMap<>();
        HashMap<String, Integer> inventarioInicial = new HashMap<>();
        int opcion;

        do {
            System.out.println("\n--- Gestión de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Consultar un producto específico");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine().toLowerCase();
                    if (inventario.containsKey(nombre)) {
                        System.out.println("El producto ya existe en el inventario.");
                        break;
                    }
                    System.out.print("Ingrese cantidad en stock: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor a 0.");
                        break;
                    }
                    inventario.put(nombre, cantidad);
                    inventarioInicial.put(nombre, cantidad);
                    System.out.println("Producto agregado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese nombre del producto a vender: ");
                    String productoVender = scanner.nextLine().toLowerCase();
                    if (!inventario.containsKey(productoVender)) {
                        System.out.println("El producto no existe en el inventario.");
                        break;
                    }
                    System.out.print("Ingrese cantidad a vender: ");
                    int cantidadVendida = scanner.nextInt();
                    scanner.nextLine();
                    if (cantidadVendida <= 0) {
                        System.out.println("La cantidad debe ser mayor a 0.");
                        break;
                    }
                    if (inventario.get(productoVender) >= cantidadVendida) {
                        inventario.put(productoVender, inventario.get(productoVender) - cantidadVendida);
                        System.out.println("Venta realizada exitosamente.");

                        
                    } else {
                        System.out.println("Stock insuficiente.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese nombre del producto a reponer: ");
                    String productoReponer = scanner.nextLine().toLowerCase();
                    if (inventario.containsKey(productoReponer) && inventario.get(productoReponer) == 0) {
                        inventario.put(productoReponer, inventarioInicial.get(productoReponer) * 2);
                        System.out.println("Inventario duplicado para " + productoReponer + ".");
                    } else {
                        System.out.println("No es necesario reponer o producto inexistente.");
                    }
                    break;
                case 4:
                    System.out.println("\nInventario Actual:");
                    if (inventario.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (String key : inventario.keySet()) {
                            System.out.println("Producto: " + key + ", Cantidad: " + inventario.get(key));
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del producto a consultar: ");
                    String productoConsulta = scanner.nextLine().toLowerCase();
                    if (inventario.containsKey(productoConsulta)) {
                        System.out.println("Producto: " + productoConsulta + ", Cantidad: " + inventario.get(productoConsulta));
                    } else {
                        System.out.println("El producto no existe en el inventario.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
