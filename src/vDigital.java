public class vDigital extends Caso {
String pDigital;
String agresor;
String rAgresor;
String gAgreasor;

    public vDigital(String nombre, String cedula, int nCelular, String direccion, int edad, String sexo, String estadoCivil, String ocupacion, String nacionalidad) {
        super(nombre, cedula, nCelular, direccion, edad, sexo, estadoCivil, ocupacion, nacionalidad);
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






}