import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        opcion1_OrdenarProductos(sc);
                        break;
                    case 2:
                        opcion2_AgregarCliente(sc);
                        break;
                    case 3:
                        opcion3_CalcularVentas();
                        break;
                    case 4:
                        opcion4_ClientesConCompras();
                        break;
                    case 5:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
                opcion = -1;
            }
        } while (opcion != 5);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n========== MENÚ E-COMMERCE ==========");
        System.out.println("1. Ver productos ordenados por precio");
        System.out.println("2. Agregar un nuevo cliente");
        System.out.println("3. Calcular total de ventas por producto");
        System.out.println("4. Ver clientes que han realizado compras");
        System.out.println("5. Salir");
        System.out.println("=====================================");
    }

    // OPCIÓN 1: Ordenar productos por precio (con opción de registrar pedido)
    static void opcion1_OrdenarProductos(Scanner sc) throws IOException {
        System.out.println("\n========== PRODUCTOS ORDENADOS POR PRECIO ==========");
        
        List<Producto> productos = ManejadorArchivos.leerProductos("productos.csv");
        
        // Algoritmo de ordenamiento (de menor a mayor): Bubble Sort
        ordenarProductosPorPrecio(productos);
        
        System.out.println(String.format("%-5s %-25s %-15s %-12s %-8s", 
            "ID", "Nombre", "Categoría", "Precio", "Stock"));
        System.out.println("====================================================================");
        
        for (Producto p : productos) {
            System.out.println(String.format("%-5d %-25s %-15s $%-11d %-8d", 
                p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock()));
        }
        
        // Submenu para registrar pedido
        System.out.println("\n¿Desea registrar un pedido? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();
        if (respuesta.equals("s") || respuesta.equals("si")) {
            registrarPedidoDesdeProductos(sc);
        }
    }

    // Función para ordenar productos por precio (menor a mayor) - Bubble Sort
    static void ordenarProductosPorPrecio(List<Producto> productos) {
        int n = productos.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {
                    // Intercambiar
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    // OPCIÓN 2: Agregar nuevo cliente
    static void opcion2_AgregarCliente(Scanner sc) throws IOException {
        System.out.println("\n========== AGREGAR NUEVO CLIENTE ==========");
        
        // Obtener el siguiente ID
        int nuevoId = ManejadorArchivos.obtenerMaximoIdCliente("clientes.csv") + 1;
        
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese el email del cliente: ");
        String email = sc.nextLine();
        
        // Crear nuevo cliente
        Cliente nuevoCliente = new Cliente(nuevoId, nombre, email);
        
        // Leer clientes existentes
        List<Cliente> clientes = ManejadorArchivos.leerClientes("clientes.csv");
        
        // Agregar el nuevo cliente
        clientes.add(nuevoCliente);
        
        // Guardar los clientes
        ManejadorArchivos.guardarClientes("clientes.csv", clientes);
        
        System.out.println("\n¡Cliente agregado exitosamente!");
        System.out.println("ID: " + nuevoId);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
    }

    // Función auxiliar: Registrar pedido desde la vista de productos
    static void registrarPedidoDesdeProductos(Scanner sc) throws IOException {
        System.out.println("\n========== REGISTRAR PEDIDO DE CLIENTE ==========");
        
        // Listar clientes
        List<Cliente> clientes = ManejadorArchivos.leerClientes("clientes.csv");
        
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados. Primero debe agregar un cliente.");
            return;
        }
        
        System.out.println("\n--- Clientes disponibles ---");
        for (Cliente c : clientes) {
            System.out.println(c.getId() + ". " + c.getNombre() + " (" + c.getEmail() + ")");
        }
        
        System.out.print("\nIngrese el ID del cliente: ");
        int cliente_id = sc.nextInt();
        sc.nextLine();
        
        // Validar que el cliente existe
        Cliente clienteSeleccionado = null;
        for (Cliente c : clientes) {
            if (c.getId() == cliente_id) {
                clienteSeleccionado = c;
                break;
            }
        }
        
        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        
        System.out.println("\nCliente seleccionado: " + clienteSeleccionado.getNombre());
        
        // Listar productos disponibles
        List<Producto> productos = ManejadorArchivos.leerProductos("productos.csv");
        
        System.out.println("\n--- Productos disponibles ---");
        for (Producto p : productos) {
            System.out.println(p.getId() + ". " + p.getNombre() + " - $" + p.getPrecio() + " (Stock: " + p.getStock() + ")");
        }
        
        System.out.print("\nIngrese el ID del producto: ");
        int producto_id = sc.nextInt();
        sc.nextLine();
        
        // Validar que el producto existe
        Producto productoSeleccionado = null;
        for (Producto p : productos) {
            if (p.getId() == producto_id) {
                productoSeleccionado = p;
                break;
            }
        }
        
        if (productoSeleccionado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        
        System.out.print("\nIngrese la cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }
        
        if (cantidad > productoSeleccionado.getStock()) {
            System.out.println("No hay suficiente stock. Stock disponible: " + productoSeleccionado.getStock());
            return;
        }
        
        // Obtener la fecha actual
        String fecha = java.time.LocalDate.now().toString();
        
        // Crear el nuevo pedido
        int nuevoPedidoId = ManejadorArchivos.obtenerMaximoIdPedido("pedidos.csv") + 1;
        Pedido nuevoPedido = new Pedido(nuevoPedidoId, cliente_id, producto_id, cantidad, fecha);
        
        // Leer pedidos existentes
        List<Pedido> pedidos = ManejadorArchivos.leerPedidos("pedidos.csv");
        pedidos.add(nuevoPedido);
        
        // Guardar pedidos actualizados
        ManejadorArchivos.guardarPedidos("pedidos.csv", pedidos);
        
        // Actualizar stock del producto
        productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
        ManejadorArchivos.guardarProductos("productos.csv", productos);
        
        System.out.println("\n¡Pedido registrado exitosamente!");
        System.out.println("ID Pedido: " + nuevoPedidoId);
        System.out.println("Cliente: " + clienteSeleccionado.getNombre());
        System.out.println("Producto: " + productoSeleccionado.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + productoSeleccionado.getPrecio());
        System.out.println("Total: $" + (cantidad * productoSeleccionado.getPrecio()));
        System.out.println("Fecha: " + fecha);
    }

    // OPCIÓN 3: Calcular total de ventas por producto
    static void opcion3_CalcularVentas() throws IOException {
        System.out.println("\n========== CALCULANDO TOTAL DE VENTAS ==========");
        
        List<Producto> productos = ManejadorArchivos.leerProductos("productos.csv");
        List<Pedido> pedidos = ManejadorArchivos.leerPedidos("pedidos.csv");
        
        // Crear lista de ventas
        List<VentasProducto> ventas = new ArrayList<>();
        
        for (Producto p : productos) {
            long total = 0;
            
            for (Pedido ped : pedidos) {
                if (ped.getProducto_id() == p.getId()) {
                    total += (long) ped.getCantidad() * p.getPrecio();
                }
            }
            
            if (total > 0) {
                ventas.add(new VentasProducto(p.getId(), p.getNombre(), total));
            }
        }
        
        // Ordenar por total de ventas (de mayor a menor)
        ordenarVentasPorTotal(ventas);
        
        System.out.println(String.format("%-5s %-25s %-15s", "ID", "Producto", "Total Ventas"));
        System.out.println("==================================================");
        
        for (VentasProducto v : ventas) {
            System.out.println(String.format("%-5d %-25s $%-14d", v.getProducto_id(), v.getNombre_producto(), v.getTotal()));
        }
        
        // Guardar en archivo
        ManejadorArchivos.guardarVentas("total_ventas.csv", ventas);
        System.out.println("\n¡Resultados guardados en total_ventas.csv!");
    }

    // Función para ordenar ventas por total (mayor a menor) - Bubble Sort
    static void ordenarVentasPorTotal(List<VentasProducto> ventas) {
        int n = ventas.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ventas.get(j).getTotal() < ventas.get(j + 1).getTotal()) {
                    // Intercambiar (de mayor a menor)
                    VentasProducto temp = ventas.get(j);
                    ventas.set(j, ventas.get(j + 1));
                    ventas.set(j + 1, temp);
                }
            }
        }
    }

    // OPCIÓN 4: Ver clientes que han realizado compras
    static void opcion4_ClientesConCompras() throws IOException {
        System.out.println("\n========== CLIENTES CON COMPRAS ==========");
        
        List<Cliente> clientes = ManejadorArchivos.leerClientes("clientes.csv");
        List<Pedido> pedidos = ManejadorArchivos.leerPedidos("pedidos.csv");
        
        // Crear lista de clientes que han hecho compras
        List<Cliente> clientesConCompras = new ArrayList<>();
        
        for (Pedido ped : pedidos) {
            for (Cliente c : clientes) {
                if (c.getId() == ped.getCliente_id()) {
                    // Verificar si el cliente ya está en la lista
                    boolean existe = false;
                    for (Cliente cc : clientesConCompras) {
                        if (cc.getId() == c.getId()) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        clientesConCompras.add(c);
                    }
                    break;
                }
            }
        }
        
        // Ordenar alfabéticamente por nombre
        ordenarClientesAlfabeticamente(clientesConCompras);
        
        System.out.println(String.format("%-5s %-25s %-30s", "ID", "Nombre", "Email"));
        System.out.println("==================================================================");
        
        for (Cliente c : clientesConCompras) {
            System.out.println(String.format("%-5d %-25s %-30s", c.getId(), c.getNombre(), c.getEmail()));
        }
        
        System.out.println("\nTotal de clientes con compras: " + clientesConCompras.size());
    }

    // Función para ordenar clientes alfabéticamente por nombre - Bubble Sort
    static void ordenarClientesAlfabeticamente(List<Cliente> clientes) {
        int n = clientes.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clientes.get(j).getNombre().compareTo(clientes.get(j + 1).getNombre()) > 0) {
                    // Intercambiar
                    Cliente temp = clientes.get(j);
                    clientes.set(j, clientes.get(j + 1));
                    clientes.set(j + 1, temp);
                }
            }
        }
    }
}