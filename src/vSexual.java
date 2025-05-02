public class vSexual extends Caso{
    private String agresor;
    private String rAgresor;
    private String gAgreasor;

    public vSexual(String agresor, String gAgreasor, String rAgresor) {
        this.agresor = agresor;
        this.gAgreasor = gAgreasor;
        this.rAgresor = rAgresor;
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
