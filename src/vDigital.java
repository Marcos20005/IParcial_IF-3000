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

    public void iDatos(String pDigital, String agresor, String rAgresor, String gAgreasor){
        this.pDigital = pDigital;
        this.agresor = agresor;
        this.rAgresor = rAgresor;
        this.gAgreasor = gAgreasor;

    }
   
   public String mostrarcaso(){
    String txt = super.mostrarcaso();

    txt =txt + "\nTipo de violencia digital: Violencia digital"  + "    Nombre del agresor: " + agresor + "    Relacion con el agresor: " + rAgresor  +
            "\nGenero del agresor: " + gAgreasor +"    Tipo de violecia registrada: Violencia digital" + "\nDescripcion del caso: " + super.getDescripcion() 
     +"\n----------------------------***************------------------------------\n";

    return txt;
   }

}