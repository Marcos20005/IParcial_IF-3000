public class Funcionario {
String nombre;
String cedula;
int iDempleado;
String hAtencion;
String fechaAtencion;
String solucion;

    public Funcionario() {
       
    }
public String getSolucion() {
    return solucion;
}

public void setSolucion(String solucion) {
    this.solucion = solucion;
}



    protected String getNombre() {
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
