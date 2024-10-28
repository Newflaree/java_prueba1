/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionparcialuno;


public class Miembro {
    private String nombre;
    private String id;
    private String codigoAcceso;
    private RegistroAcceso registro;

    public Miembro(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.codigoAcceso = GenerarCodigoAcceso.generarCodigo();
        this.registro = new RegistroAcceso(); // Inicializa el registro de acceso
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoAcceso() {
        return this.codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public RegistroAcceso getRegistro() {
        return this.registro;
    }

    public void setRegistro(RegistroAcceso registro) {
        this.registro = registro;
    }

    public boolean validaAcceso(String id, String codigoAcceso) {
        return this.id.equals(id) && this.codigoAcceso.equals(codigoAcceso);
    }

    public void registrarEntrada() {
        this.registro.registrarEntrada();
    }

    public void registrarSalida() {
        this.registro.registrarSalida();
    }

    @Override
    public String toString() {
        return "Miembro{" + "nombre=" + nombre + ", id=" + id + ", codigoAcceso=" + codigoAcceso + ", registro=" + registro + '}';
    }
}