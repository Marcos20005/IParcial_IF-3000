public class Caso {
private String fecha;
private  String hora;
private String descripcion;
private Victima victima;
public Caso(String fecha, String hora, String descripcion,String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil,
        String ocupacion, String nacionalidad) {
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        victima = new Victima(nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil,
        ocupacion, nacionalidad);
}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void aniadorcaso(String fecha, String hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }
    public void mostrarcaso(){
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Descripcion: " + descripcion);
    }
    public void eliminarcaso(){
        this.fecha = null;
        this.hora = null;
        this.descripcion = null;
    }
    public void modificarcaso(String fecha, String hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }
    public void buscarcaso(String fecha, String hora, String descripcion){
        if(this.fecha.equals(fecha) && this.hora.equals(hora) && this.descripcion.equals(descripcion)){
            System.out.println("Caso encontrado");
        }else{
            System.out.println("Caso no encontrado");
        }
    }
}
