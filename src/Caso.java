public class Caso {
private String fecha;
private  String hora;
private String descripcion;
private Victima victima;
private Funcionario funci = new Funcionario();
private oRegional ofi = new oRegional();


    public Caso(String fecha,String hora , String descripcion,String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil,
    String ocupacion, String nacionalidad) {
        victima = new Victima(nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
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

  
    
    public Victima getVictima() {
        return victima;
    }

    public void setVictima(Victima victima) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void editarExtras(String nombre,String cedula,String fecha,int cEmpleado,String hora,String solucion,String lugar, String direccion, int telefono){
    funci.setNombre(nombre);
    funci.setCedula(cedula);
    funci.setFechaAtencion(fecha);
    funci.setiDempleado(cEmpleado);
    funci.sethAtencion(hora);
    funci.setSolucion(solucion);
    ofi.setLugar(lugar);
    ofi.setDireccion(direccion);
    ofi.setTelefono(telefono);
    }
    public String devolverExtras(){
    String txt="";
    txt="\n\nSe a añadido la siguiente respuesta a su caso\nInformacion de funcionario \nFacilitador de solucion\nNombre del funcionario: "+funci.getNombre()+"    Cedula de funcionario: "+funci.getCedula()+"    Codigo de empleado: "+funci.getiDempleado()+
   "\nFecha en que se dio la solucion: "+funci.getFechaAtencion()+"    Hora en que se dio la respuesta: "+funci.gethAtencion()
   +"\nSolucion: "+funci.getSolucion()+
   "\nInformacion de la oficina\nLugar de la oficina: "+ofi.getLugar()+"    Direccion de la oficina: "+ofi.getDireccion()+"    Telefono de la oficina: "+ofi.getTelefono()+"\n-----------------------***************-----------------------\n";
    return txt;    
    }
    
}
