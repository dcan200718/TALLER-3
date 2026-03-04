public class Cliente {
    private int id_clinete;
    private String nombre;
    private String apellido;
    private int telefono;
    private Boolean activo;
//cliente
    public Cliente(int id_clinete, String nombre, String apellido, int telefono, boolean activo) {
        this.id_clinete = id_clinete;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getId() {return id_clinete;}
    public String getNombre() { return  nombre;}
    public String getApellido() { return  apellido;}
    public int getTelefono() { return  telefono;}
    public Boolean getActivo() {return activo;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setEstado(Boolean activo) {this.activo = activo;}

    @Override
    public String toString() {
        return id_clinete + "," + nombre + "," + apellido + "," + telefono + "," + activo;
    }
}

