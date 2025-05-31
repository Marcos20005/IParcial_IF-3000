public class vEconomica extends Caso {
    //Atributos de la clase vEconomica
    private String agresor;
    private String rAgresor;
    private String gAgreasor;
    private String tIngreso;
    private double cantidadIngreso;

    //Constructor de la clase vEconomica, con parametros para inicializar los atributos de la clase Caso.
    public vEconomica(String fecha, String hora, String descripcion, String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha, hora, descripcion, nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }

    //Metododo para inicializar los atributos de la clase vEconomica.
    @Override
    public void iDatos(String tIngreso, String agresor, String rAgresor, String gAgreasor) {
        this.tIngreso = tIngreso;   
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;
    }

    //Metodo sobreescrito para mostrar el caso, se utiliza para mostrar la informacion de la victima y el caso de manera completa.
    @Override
    public String mostrarcaso() {
        String txt = super.mostrarcaso();
        txt += "\nTipo de violencia: Violencia económica" +
               "\nTipo de ingreso afectado: " + tIngreso +
               "\nCantidad de ingreso afectado: " + cantidadIngreso +
               "\nNombre del agresor: " + agresor +
               "\nRelación con el agresor: " + rAgresor +
               "\nGénero del agresor: " + gAgreasor +
               "\nDescripción del caso: " + super.getDescripcion() ;
              
        return txt;
    }


    //Getters y Setters de la clase vEconomica.
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

    protected String getgAgreasor() {
        return gAgreasor;
    }

    protected void setgAgreasor(String gAgreasor) {
        this.gAgreasor = gAgreasor;
    }

    protected String gettIngreso() {
        return tIngreso;
    }

    protected void settIngreso(String tIngreso) {
        this.tIngreso = tIngreso;
    }

    protected double getCantidadIngreso() {
        return cantidadIngreso;
    }

    protected void setCantidadIngreso(double cantidadIngreso) {
        this.cantidadIngreso = cantidadIngreso;
    }
}
