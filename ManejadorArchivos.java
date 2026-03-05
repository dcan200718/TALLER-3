import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejadorArchivos {

    // ====== PRODUCTO ======
    public static List<Producto> leerProductos(String archivo) throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(archivo))) {
            // Saltamos el encabezado
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length >= 5) {
                    try {
                        Producto p = new Producto(
                            Integer.parseInt(datos[0].trim()),
                            datos[1].trim(),
                            datos[2].trim(),
                            Integer.parseInt(datos[3].trim()),
                            Integer.parseInt(datos[4].trim())
                        );
                        productos.add(p);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear producto: " + e.getMessage());
                    }
                }
            }
        }
        return productos;
    }

    public static void guardarProductos(String archivo, List<Producto> productos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("id,nombre,categoria,precio,stock");
            bw.newLine();
            for (Producto p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }
        }
    }

    // ====== CLIENTE ======
    public static List<Cliente> leerClientes(String archivo) throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(archivo))) {
            // Saltamos el encabezado
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length >= 3) {
                    try {
                        Cliente c = new Cliente(
                            Integer.parseInt(datos[0].trim()),
                            datos[1].trim(),
                            datos[2].trim()
                        );
                        clientes.add(c);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear cliente: " + e.getMessage());
                    }
                }
            }
        }
        return clientes;
    }

    public static void guardarClientes(String archivo, List<Cliente> clientes) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("id,nombre,email");
            bw.newLine();
            for (Cliente c : clientes) {
                bw.write(c.toString());
                bw.newLine();
            }
        }
    }

    public static int obtenerMaximoIdCliente(String archivo) throws IOException {
        List<Cliente> clientes = leerClientes(archivo);
        int maxId = 0;
        for (Cliente c : clientes) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        return maxId;
    }

    // ====== PEDIDO ======
    public static List<Pedido> leerPedidos(String archivo) throws IOException {
        List<Pedido> pedidos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(archivo))) {
            // Saltamos el encabezado
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length >= 5) {
                    try {
                        Pedido p = new Pedido(
                            Integer.parseInt(datos[0].trim()),
                            Integer.parseInt(datos[1].trim()),
                            Integer.parseInt(datos[2].trim()),
                            Integer.parseInt(datos[3].trim()),
                            datos[4].trim()
                        );
                        pedidos.add(p);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear pedido: " + e.getMessage());
                    }
                }
            }
        }
        return pedidos;
    }

    public static void guardarVentas(String archivo, List<VentasProducto> ventas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("producto_id,nombre_producto,total");
            bw.newLine();
            for (VentasProducto v : ventas) {
                bw.write(v.toString());
                bw.newLine();
            }
        }
    }

    public static int obtenerMaximoIdPedido(String archivo) throws IOException {
        List<Pedido> pedidos = leerPedidos(archivo);
        int maxId = 0;
        for (Pedido p : pedidos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId;
    }

    public static void guardarPedidos(String archivo, List<Pedido> pedidos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("id,cliente_id,producto_id,cantidad,fecha");
            bw.newLine();
            for (Pedido p : pedidos) {
                bw.write(p.toString());
                bw.newLine();
            }
        }
    }
}
