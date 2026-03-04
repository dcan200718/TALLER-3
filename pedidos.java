public class Pedido{
    int id_pedido;
    int id_cliente;
    String producto;
    int precio;
    int cantidad; 
   
// pedido
    public Pedido(int id_pedido, int id_cliente, String producto, int precio, int cantidad) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
     
    }

    @Override
    public String toString() {
        return id_pedido + "," + id_cliente + "," + producto + "," + precio + "," + cantidad;
    }


}