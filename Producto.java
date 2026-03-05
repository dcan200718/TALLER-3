public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int precio;
    private int stock;

    public Producto(int id, String nombre, String categoria, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + categoria + "," + precio + "," + stock;
    }
}
