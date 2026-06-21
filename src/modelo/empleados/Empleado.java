package modelo.empleados;

import enums.Sector;
import enums.Rol;

/**
 *
 * @author inver
 */

// ATRIBUTOS Y CONSTRUCTOR

public class Empleado implements interfaces.Reportable {
    
    private int legajo;
    private String nombre;
    private String apellido;
    private Sector sector;
    private Rol rol;
    private String contrasena;
    private boolean activo;
    
    public Empleado(int legajo, String nombre, String apellido, Sector sector, Rol rol, String contrasena){
            this.legajo = legajo;
            this.nombre = nombre;
            this.apellido = apellido;
            this.sector = sector;
            this.rol = rol;
            this.contrasena = contrasena;
            this.activo = true;
        }
    
    public Empleado(int legajo, String nombre, String apellido, Rol rol, String contrasena){
        this(legajo, nombre, apellido, Sector.GENERAL, rol, contrasena);
    }

    //GETTERS
    
    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public Sector getSector() {
        return sector;
    }
    
    public Rol getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    //GET REPORTE ---> PANEL REPORTES
    
    @Override
    public String getReporte() {
        return "==== EMPLEADO ====\nLegajo: " + legajo 
                + "\nNombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nSector: " + sector 
                + "\nRol: " + rol
                + "\n==================";
    }
    
    // SETTERS
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //ALTA ACTIVA PARA EL EMPLEADO
    
    public boolean isActivo() {
        return activo;
    }
    
    //VALIDACION DE CONTRASEÑA DEL LOGIN
    
    public boolean validarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
    
    //TO STRING PARA EL REPORTE
    
    @Override
    public String toString() {
        return "==== EMPLEADO ====\nLegajo: " + legajo 
                + "\nNombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nSector: " + sector 
                + "\nRol: " + rol
                + "\n==================";
    }
    
    //CSV PARA PERSISTENCIA
    
    public String toCSV() {
        return legajo + ";" + nombre + ";" + apellido + ";" + sector + ";" + rol + ";" + contrasena+ ";" + activo;
    }
    
}
