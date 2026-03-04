public class Cliente {
    private int id_clinete;
    private String nombre;
    private String apellido;
    private int email;
    
    public Cliente(int id_clinete, String nombre, String apellido, String email) {
        this.id_clinete = id_clinete;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getId() {return id_clinete;}
    public String getNombre() { return  nombre;}
    public String getApellido() { return  apellido;}
    public String getTelefono() { return  email;}
    

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setemail(String email) {this.email = email;}
   

    @Override
    public String toString() {
        return id_clinete + "," + nombre + "," + apellido + "," + email;
    }
}

