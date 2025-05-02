public class Victima {
private String nombre;
private String cedula;
private int nCelular;
private String direccion;
private int edad;
private String genero;
private String estadoCivil;
private String ocupacion;
private String nacionalidad;

    public Victima(String nombre, String cedula, int nCelular, String direccion, int edad, String genero, String estadoCivil,
        String ocupacion, String nacionalidad) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.nCelular = nCelular;
    this.direccion = direccion;
    this.edad = edad;
    this.genero = genero;
    this.estadoCivil = estadoCivil;
    this.ocupacion = ocupacion;
    this.nacionalidad = nacionalidad;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getnCelular() {
        return nCelular;
    }

    public void setnCelular(int nCelular) {
        this.nCelular = nCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public void reportarCaso(){

    }
}
