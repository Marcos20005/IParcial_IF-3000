public class Caso {
    //Atributos de la clase caso
private String fecha;
private  String hora;
private String descripcion;
private Victima victima;
private Funcionario funci = new Funcionario();
private oRegional ofi = new oRegional();

//Constructor de la clase caso, con parametros para inicializar los atributos de la clase caso y la clase victima.
    public Caso(String fecha,String hora , String descripcion,String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil,
    String ocupacion, String nacionalidad) {
        victima = new Victima(nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
}

//Inicializacion de getters y setters de la clase caso.
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Fin de getters y setters de la clase caso.
    
  //Metodo para mostrar el caso, se utiliza para mostrar la informacion de la victima y el caso.
    public String mostrarcaso(){
        String txt="";
        txt= "Fecha: " + fecha + "    Hora: " + hora +"    Nombre de victima: "+victima.getNombre() 
        + "\nCedula de la victima:" + victima.getCedula() +"     Numero celular: " + victima.getnCelular()+"    Direccion: " + victima.getDireccion() 
        + "\nEdad de la victima: " + victima.getEdad() + "    Genero de la victima: " + victima.getGenero()+"    Estado civil de la victima: " + victima.getEstadoCivil() 
        + "\nOcupacion de la victima: " + victima.getOcupacion() + "    Nacionalidad de la victima: " + victima.getNacionalidad();
        return txt;
        
    }
  //  public void eliminarcaso(){
        //this.fecha = null;
        //this.hora = null;
      //  this.descripcion = null;
    //}

    //Metodo para modificar el caso, se utiliza para modificar la descripcion, fecha y hora.
    public void modificarcaso(String fecha, String hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    //Metodo para buscar el caso, se utiliza para buscar el caso por la cedula de la victima.
    public String buscarCaso(){
        String txt="";
        txt="Nunmero de cedula: "+victima.getCedula()+"\n";
        return txt;
       
    }
   
    //Metodo declarado para que que las subclases lo puedan implentar.
    public void iDatos(String pDigital, String agresor, String rAgresor, String gAgreasor){

    }

  //Metodo para agregar la informacion de la oficinay el funcionario .
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

    //Metodo para mostrar la informacion de la oficina y el funcionario.
    public String devolverExtras(){
    String txt="";
    txt="\n\nSe a añadido la siguiente respuesta a su caso\nInformacion de funcionario \nFacilitador de solucion\nNombre del funcionario: "+funci.getNombre()+"    Cedula de funcionario: "+funci.getCedula()+"    Codigo de empleado: "+funci.getiDempleado()+
   "\nFecha en que se dio la solucion: "+funci.getFechaAtencion()+"    Hora en que se dio la respuesta: "+funci.gethAtencion()
   +"\nSolucion: "+funci.getSolucion()+
   "\nInformacion de la oficina\nLugar de la oficina: "+ofi.getLugar()+"    Direccion de la oficina: "+ofi.getDireccion()+"    Telefono de la oficina: "+ofi.getTelefono()+"\n-----------------------***************-----------------------\n";
    return txt;    
    }
    
}
//Fin de clase caso.
