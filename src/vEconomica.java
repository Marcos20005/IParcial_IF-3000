public class vEconomica {
   private String agresor;
   private String rAgresor;
   private String gAgreasor;
   private String tIngreso;
   private double cantidadIngreso;

    public vEconomica(String agresor, double cantidadIngreso, String gAgreasor, String rAgresor, String tIngreso) {
        this.agresor = agresor;
        this.cantidadIngreso = cantidadIngreso;
        this.gAgreasor = gAgreasor;
        this.rAgresor = rAgresor;
        this.tIngreso = tIngreso;
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

    public String gettIngreso() {
        return tIngreso;
    }

    public void settIngreso(String tIngreso) {
        this.tIngreso = tIngreso;
    }

    public double getCantidadIngreso() {
        return cantidadIngreso;
    }

    public void setCantidadIngreso(double cantidadIngreso) {
        this.cantidadIngreso = cantidadIngreso;
    }


}
