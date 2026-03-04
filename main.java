import java.io.IOException;
import java.util.List;
import java.util.Scanner;
//main
public class Main{
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            int e = 0;
            do {
                mostrarMenu();
                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1: {
                        System.out.print("ID: ");
                        int id_cliente = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Telefono: ");
                        int telefono = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Estado (true/false): ");
                        boolean estado = sc.nextBoolean();
                        CRUDArchivo.RegistrarCliente(new Cliente(id_cliente, nombre, apellido, telefono, estado));
                        break;
                    }
                    case 2: {
                        var clientes = CRUDArchivo.ListarClientes(null);
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("ID: ");
                        int id_cliente = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Telefono: ");
                        int telefono = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Estado (true/false): ");
                        boolean estado = sc.nextBoolean();
                        CRUDArchivo.actualizarCliente(id_cliente, nombre, apellido, telefono, estado);
                        break;
                    }
                    case 4: {
                        System.out.print("ID: ");
                        int id_cliente = sc.nextInt();
                        sc.nextLine();
                        CRUDArchivo.eliminarCliente(id_cliente);
                        break;
                    }
                    case 5:{
                        System.out.print("ID: ");
                        int id_cliente = sc.nextInt();
                        sc.nextLine();
                        List<Cliente> lista = CRUDArchivo.ListarClientes(null);
                        for (Cliente u : lista) {
                                if (u.getId() == id_cliente) {
                                    System.out.print("ID_pedido: ");
                                    int id_pedido = sc.nextInt();
                                    sc.nextLine();
                                    int id_cliente_pedido = id_cliente;
                                    System.out.print("Producto: ");
                                    String producto = sc.nextLine();
                                    System.out.print("precio: ");
                                    int precio = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Cantidad: ");
                                    int cantidad = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Estado (true/false): ");
                                    boolean estado = sc.nextBoolean();
                                    CRUDArchivo.RegistrarPedido(new Pedido(id_pedido, id_cliente_pedido, producto, precio, cantidad, estado));
                                    break;
                                }
                            }
                        if (e == 0) {
                            System.out.println("No se encontró el cliente.");
                        }else{
                            System.out.println("Pedido registrado con éxito."   );
                        }
                        break;
                    }
                    case 6:
                        System.out.println("Saliendo del programa");
                        break;
                    default: 
                        System.out.println("Opción inválida.");
                }
                System.out.println();
            } while (opcion != 6);
        }
    }

    static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE GESTIÓN DE CLIENTES  ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  1. Crear Cliente                  ║");
        System.out.println("║  2. Leer Clientes                  ║");
        System.out.println("║  3. Actualizar Cliente             ║");
        System.out.println("║  4. Eliminar Cliente               ║");
        System.out.println("║  5. Registrar Pedido               ║");
        System.out.println("║  6. Salir                          ║");
        System.out.println("╚════════════════════════════════════╝");
    }

}