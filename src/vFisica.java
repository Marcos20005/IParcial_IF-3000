public class vFisica extends Caso{
    private String agresor;
    private String rAgresor;
    private String gAgreasor;
    private String tipoLesion;
    private String atencionMedica;

    public vFisica(String fecha, String hora, String descripcion, String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha, hora, descripcion, nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }

    @Override
    public void iDatos(String tipoLesion, String agresor, String rAgresor, String gAgreasor) {
        this.tipoLesion = tipoLesion;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;
    }

    @Override
    public String mostrarcaso() {
        String txt = super.mostrarcaso();
        txt += "\nTipo de violencia: Violencia física" +
               "\nTipo de lesión: " + tipoLesion +
               "\nAtención médica recibida: " + atencionMedica +
               "\nNombre del agresor: " + agresor +
               "\nRelación con el agresor: " + rAgresor +
               "\nGénero del agresor: " + gAgreasor +
               "\nDescripción del caso: " + super.getDescripcion() +
               "\n-----------------------***************-----------------------\n";
        return txt;
    }

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

    protected String getTipoLesion() {
        return tipoLesion;
    }

    protected void setTipoLesion(String tipoLesion) {
        this.tipoLesion = tipoLesion;
    }

    protected String getAtencionMedica() {
        return atencionMedica;
    }

    protected void setAtencionMedica(String atencionMedica) {
        this.atencionMedica = atencionMedica;
    }
}