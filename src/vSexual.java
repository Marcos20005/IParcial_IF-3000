public class vSexual extends Caso{
    //Atributos de la clase vSexual
    private String agresor;
    private String rAgresor;
    private String gAgresor;
    private String tipoAbusoSexual;

    //Constructor de la clase vSexual, con parametros para inicializar los atributos.
    public vSexual(String fecha, String hora, String descripcion, String nombre, String cedula, int nCelular, 
                   String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha, hora, descripcion, nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }

    //Metododo para inicializar los atributos de la clase vSexual.
    @Override
    public void iDatos(String tipoAbusoSexual, String agresor, String rAgresor, String gAgresor) {
        this.tipoAbusoSexual = tipoAbusoSexual;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgresor = gAgresor;
    }

    //Metodo sobreescrito para mostrar el caso, se utiliza para mostrar la informacion de la victima y el caso de manera completa.
    @Override
    public String mostrarcaso() {
        String txt = super.mostrarcaso();
        txt += "\nTipo de violencia: Violencia sexual" +
               "\nTipo de abuso sexual: " + tipoAbusoSexual +
               "\nNombre del agresor: " + agresor +
               "\nRelación con el agresor: " + rAgresor +
               "\nGénero del agresor: " + gAgresor +
               "\nDescripción del caso: " + super.getDescripcion() ;
               
              
        return txt;
    }

   // @Override
    //public String buscarCaso() {
      //  return getVictima().getCedula();
    //}

    //Getters y Setters de la clase vSexual.
    protected String getAgresor() {
        return agresor;
    }

    protected void setAgresor(String agresor) {
        this.agresor = agresor;
    }

    protected String getrAgresor() {
        return rAgresor;
    }

    protected void setrAgresor(String rAgresor) {
        this.rAgresor = rAgresor;
    }

    protected String getgAgresor() {
        return gAgresor;
    }

    protected void setgAgresor(String gAgresor) {
        this.gAgresor = gAgresor;
    }

    protected String getTipoAbusoSexual() {
        return tipoAbusoSexual;
    }

    protected void setTipoAbusoSexual(String tipoAbusoSexual) {
        this.tipoAbusoSexual = tipoAbusoSexual;
    }
}