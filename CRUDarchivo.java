import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDArchivo {
    public static void RegistrarCliente(Cliente client) throws IOException {
    FileWriter fw = new FileWriter("usuarios.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(client.toString());
    bw.newLine();
    bw.close();
    }
//lista de clientes
    
    public static List<Cliente> ListarClientes(Cliente cliente) throws IOException {
        List<Cliente> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("usuarios.txt"));

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");
            lista.add(new Cliente(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2],
                Integer.parseInt(datos[3]),
                Boolean.parseBoolean(datos[4])
            ));
        }
        sc.close();
        return lista;
    }

        public static void actualizarCliente(int id, String nuevoNombre, String nuevoApellido, int nuevoTelefono, boolean nuevoEstado) throws IOException {

        List<Cliente> lista = ListarClientes(null);
        BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"));

        for (Cliente u : lista) {
            if (u.getId() == id) { //revisar eso
                u.setNombre(nuevoNombre);
                u.setApellido(nuevoApellido);
                u.setTelefono(nuevoTelefono);
                u.setEstado(nuevoEstado);
            }
            bw.write(u.toString());
            bw.newLine();
        }
        bw.close();
    }

    
    public static void eliminarCliente(int id) throws IOException {

        List<Cliente> lista = ListarClientes(null);
        BufferedWriter bw = 
            new BufferedWriter(new FileWriter("usuarios.txt"));

        for (Cliente u : lista) {
            if (u.getId() != id) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }
    public static void RegistrarPedido(Pedido pedido) throws IOException {
    FileWriter fw = new FileWriter("pedidos.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(pedido.toString());
    bw.newLine();
    bw.close();
    }
    
      
   
}