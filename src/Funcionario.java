public class Funcionario {
    //Atributos de la clase Funcionario
private String nombre;
private String cedula;
private int iDempleado;
private String hAtencion;
private String fechaAtencion;
private String solucion;
//Constructor de clase Funcionario.
    public Funcionario() {
       
    }

//declaracion de los metodos get y set de la clase Funcionario.
    public Funcionario(String nombre, String cedula, int iDempleado, String hAtencion, String fechaAtencion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.iDempleado = iDempleado;
        this.hAtencion = hAtencion;
        this.fechaAtencion = fechaAtencion;
    }
 protected  String getSolucion() {
    return solucion;
}

 protected  void setSolucion(String solucion) {
    this.solucion = solucion;
}



    protected   String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getCedula() {
        return cedula;
    }

    protected void setCedula(String cedula) {
        this.cedula = cedula;
    }

    protected int getiDempleado() {
        return iDempleado;
    }

    protected void setiDempleado(int iDempleado) {
        this.iDempleado = iDempleado;
    }

    protected String gethAtencion() {
        return hAtencion;
    }

    protected void sethAtencion(String hAtencion) {
        this.hAtencion = hAtencion;
    }
;

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }


}
