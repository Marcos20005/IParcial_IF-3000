public class vDigital extends Caso {
private String pDigital;
private String agresor;
private String rAgresor;
private String gAgreasor;

    public vDigital(String fecha,String Hora , String descripcion,String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(fecha,Hora,descripcion,nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
    }


    public String getpDigital() {
        return pDigital;
    }

    public void setpDigital(String pDigital) {
        this.pDigital = pDigital;
    }

    public String getAgresor() {
        return agresor;
    }

    public void setAgresor(String agresor) {
        this.agresor = agresor;
    }

    public String getrAgresor() {
        return rAgresor;
    }

    public void setrAgresor(String rAgresor) {
        this.rAgresor = rAgresor;
    }

    public String getgAgreasor() {
        return gAgreasor;
    }

    public void setgAgreasor(String gAgreasor) {
        this.gAgreasor = gAgreasor;
    }

@Override
    public void iDatos(String pDigital, String agresor, String rAgresor, String gAgreasor){
        
        this.pDigital = pDigital;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;

    }
   @Override
   public String mostrarcaso(){
    String txt = super.mostrarcaso();

    txt =txt + "\nTipo de violencia registrada: Violencia digital"  + "    Nombre del agresor: " + agresor + "    Relacion con el agresor: " + rAgresor  +
            "\nGenero del agresor: " + gAgreasor +"    Plataforma en la cual se dio el caso: "+ pDigital+ "\nDescripcion del caso: " + super.getDescripcion() ;

    return txt;
   }

}