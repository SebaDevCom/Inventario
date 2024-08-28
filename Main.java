package Proyectos.Inventario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("1. Agregar Producto");
                System.out.println("2. Eliminar Producto");
                System.out.println("3. Buscar Producto");
                System.out.println("4. Mostrar Inventario");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        boolean datosValidos = false;
                        do {
                            try {
                                String nombreProducto = "";
                                while (true) {
                                    System.out.print("Nombre: ");
                                    nombreProducto = scanner.nextLine();
                                    if (!nombreProducto.matches("[\\p{L}\\s]+")) {
                                        System.out.println("Error: El nombre del producto debe contener solo letras y espacios.");
                                    } else {
                                        break;
                                    }
                                }

                                int cantidad;

                                while (true) {
                                    try {
                                        System.out.print("Ingrese la cantidad de productos: ");
                                        cantidad = scanner.nextInt();
                                        if (cantidad <= 0) {
                                            System.out.println("Error el numero de productos agregados necesita ser mayor a 0...");
                                        } else {
                                            break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida... ¡Intente nuevamente!");
                                        scanner.nextLine();
                                    }

                                }

                                double precio;
                                while (true) {
                                    try {

                                        System.out.print("Ingrese el precio del producto:");
                                        precio = scanner.nextDouble();
                                        if (precio <= 0) {
                                            System.out.println("Error: El precio debe ser mayor a cero...");
                                        } else {
                                            break;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada invalida... ¡Intente de nuevo!");
                                        scanner.nextLine();
                                    }
                                }

                                inventario.agregarProducto(new Producto(nombreProducto, cantidad, precio));
                                datosValidos = true;

                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida... ¡Intente nuevamente!");
                                scanner.nextLine();
                            }

                        } while (!datosValidos);

                        break;

                    case 2:

                        boolean datosValidoss = false;
                        do {

                            try {

                                System.out.println("Nombre del producto que desea eliminar:");
                                String nombreEliminar = scanner.next();
                                if (!nombreEliminar.matches("[\\p{L}\\s]+")) {
                                    System.out.println("Error: El nombre del producto debe contener solo letras y espacios.");
                                } else {

                                    inventario.eliminarProducto(nombreEliminar);
                                    datosValidoss = true;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida... ¡Intente de nuevo!");
                                scanner.nextLine();
                            }

                        } while (!datosValidoss);
                        break;

                    case 3:
                        boolean datosValidosss = false;
                        do {

                            try {
                                System.out.println("Nombre del producto a buscar: ");
                                String nombreBuscar = scanner.next();
                                if (!nombreBuscar.matches("[\\p{L}\\s]+")) {
                                    System.out.println("Entrada invalida... ¡Intente de nuevo!");
                                    scanner.nextLine();

                                } else {
                                    Producto producto = inventario.buscarProducto(nombreBuscar);
                                    if (producto != null) {
                                        System.out.println(producto);
                                    } else {
                                        System.out.println("Producto no encontrado...");
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida... ¡Intente de nuevo!");
                                scanner.nextLine();
                            }

                        } while (!datosValidosss);
                        break;
                    case 4:
                        inventario.mostrarInventario();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida... ¡Intente nuevamente!");
                scanner.nextLine();
            }
        }
    }
}
