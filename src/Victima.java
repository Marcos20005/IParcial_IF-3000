public class Victima {
//Atributos de la clase victima
private String nombre;
private String cedula;
private int nCelular;
private String direccion;
private int edad;
private String genero;
private String estadoCivil;
private String ocupacion;
private String nacionalidad;

//Constructor de la clase victima, con parametros para inicializar los atributos de la clase victima.
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

//Inicializacion de getters y setters de la clase victima.
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

    protected int getnCelular() {
        return nCelular;
    }

    protected void setnCelular(int nCelular) {
        this.nCelular = nCelular;
    }

    protected String getDireccion() {
        return direccion;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    protected int getEdad() {
        return edad;
    }

    protected void setEdad(int edad) {
        this.edad = edad;
    }

    protected String getGenero() {
        return genero;
    }

    protected void setGenero(String genero) {
        this.genero = genero;
    }

    protected String getEstadoCivil() {
        return estadoCivil;
    }

    protected void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    protected String getOcupacion() {
        return ocupacion;
    }

    protected void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    protected String getNacionalidad() {
        return nacionalidad;
    }

    protected void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    protected void reportarCaso(){

    }
}
