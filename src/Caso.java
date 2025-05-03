public class Caso {
private String fecha;
private  String hora;
private String descripcion;
private Victima victima;


    public Caso(String fecha,String hora , String descripcion,String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil,
    String ocupacion, String nacionalidad) {
        victima = new Victima(nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
}

    protected String getFecha() {
        return fecha;
    }

    protected void setFecha(String fecha) {
        this.fecha = fecha;
    }

    protected String getHora() {
        return hora;
    }

    protected void setHora(String hora) {
        this.hora = hora;
    }

    protected String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    protected Victima getVictima() {
        return victima;
    }

    protected void setVictima(Victima victima) {
        this.victima = victima;
    }
    
    
    public void aniadorcaso(String fecha, String hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }
    public String mostrarcaso(){
        String txt="";
        //System.out.println("Fecha: " + fecha);
        //System.out.println("Hora: " + hora);
        //System.out.println("Descripcion: " + descripcion);
        txt= "Fecha: " + fecha + "    Hora: " + hora +"    Nombre de victima: "+victima.getNombre() 
        + "\nCedula de la victima:" + victima.getCedula() +"     Numero celular: " + victima.getnCelular()+"    Direccion: " + victima.getDireccion() 
        + "\nEdad de la victima: " + victima.getEdad() + "    Genero de la victima: " + victima.getGenero()+"    Estado civil de la victima: " + victima.getEstadoCivil() 
        + "\nOcupacion de la victima: " + victima.getOcupacion() + "    Nacionalidad de la victima: " + victima.getNacionalidad();
        return txt;
        
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
    public String buscarCaso(){
        String txt="";
        txt="Nunmero de cedula: "+victima.getCedula()+"\n";
        return txt;
       
    }

    public void iDatos(String pDigital, String agresor, String rAgresor, String gAgreasor){

    }

    
}
