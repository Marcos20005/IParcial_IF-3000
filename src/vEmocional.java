public class vEmocional extends Caso{
    //Atributos de la clase vEmocional
    private String agresor;
    private String rAgresor;
    private String gAgreasor;
    private String impactoPsicologico;

    //Constructor de la clase vEmocional, con parametros para inicializar los atributos de la clase caso.
    public vEmocional(String fecha, String hora, String descripcion, String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha, hora, descripcion, nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }


    //Metododo para inicializar los atributos de la clase vEmocional.
    @Override
    public void iDatos(String impactoPsicologico, String agresor, String rAgresor, String gAgreasor) {
        this.impactoPsicologico = impactoPsicologico;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;
    }

    //Metodo sobreescrito para mostrar el caso, se utiliza para mostrar la informacion de la victima y el caso de manera completa.
    @Override
    public String mostrarcaso() {
        String txt = super.mostrarcaso();
        txt += "\nTipo de violencia: Violencia emocional" +
               "\nImpacto psicológico: " + impactoPsicologico +
               "\nNombre del agresor: " + agresor +
               "\nRelación con el agresor: " + rAgresor +
               "\nGénero del agresor: " + gAgreasor +
               "\nDescripción del caso: " + super.getDescripcion() ;
              
        return txt;
    }


    //Getters y Setters de la clase vEmocional.
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

    protected String getImpactoPsicologico() {
        return impactoPsicologico;
    }

    protected void setImpactoPsicologico(String impactoPsicologico) {
        this.impactoPsicologico = impactoPsicologico;
    }
}