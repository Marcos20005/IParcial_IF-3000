public class vEmocional extends Caso{
    private String agresor;
    private String rAgresor;
    private String gAgreasor;
    private String impactoPsicologico;

    public vEmocional(String fecha, String hora, String descripcion, String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha, hora, descripcion, nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }

    @Override
    public void iDatos(String impactoPsicologico, String agresor, String rAgresor, String gAgreasor) {
        this.impactoPsicologico = impactoPsicologico;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;
    }

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