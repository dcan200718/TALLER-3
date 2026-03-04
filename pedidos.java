public class Pedido{
    int id_pedido;
    int id_cliente;
    String producto;
    int precio;
    int cantidad; 
    boolean activo;
// pedido
    public Pedido(int id_pedido, int id_cliente, String producto, int precio, int cantidad, boolean activo) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_pedido + "," + id_cliente + "," + producto + "," + precio + "," + cantidad + "," + activo;
    }


}