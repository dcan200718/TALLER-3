public class VentasProducto {
    private int producto_id;
    private String nombre_producto;
    private long total;

    public VentasProducto(int producto_id, String nombre_producto, long total) {
        this.producto_id = producto_id;
        this.nombre_producto = nombre_producto;
        this.total = total;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return producto_id + "," + nombre_producto + "," + total;
    }
}
