public class productos {
    private int id;
    private String nombre;
    private String categoria;
    private int precio;
    private int stock;
    
//productos
    public productos(int id, String nombre, String categoria, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {return id;}
    public String getNombre() { return  nombre;}
    public String getcategoria() { return  categoria;}
    public int getstock() { return  stock;}
    public Boolean getprecio() {return precio;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setcategoria(String categoria) {this.categoria = categoria;}
    public void setstock(int stock) {this.stock = stock;}
    public void setprecio(int precio) {this.precio = precio;}

    @Override
    public String toString() {
        return id + "," + nombre + "," + categoria + "," + precio + "," + stock;
    }
}

