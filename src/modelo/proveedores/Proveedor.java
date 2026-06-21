package modelo.proveedores;

/**
 *
 * @author inver
 */

//ATRIBUTOS Y CONSTRUCTOR

public class Proveedor implements interfaces.Reportable {
    
    private int idProveedor;
    private String empresa;
    private String telefono;
    private String email;
    private String direccion;
    private boolean activo;
    
    public Proveedor(int idProveedor, String empresa, String telefono, String email, String direccion)
        {
            this.idProveedor = idProveedor;
            this.empresa = empresa;
            this.telefono = telefono;
            this.email = email;
            this.direccion = direccion;
            this.activo = true;
        }

    //GETTERS
    
    public String getEmpresa() {
            return this.empresa;
    }
    
    public String getEmail() {
            return this.email;
    }
    
    public int getIdProveedor() {
            return this.idProveedor;
    }
    
    public String getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    //SETTERS
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //ALTA ACTIVA DE PROVEEDOR
    
    public boolean isActivo() {
        return activo;
    }
    
    //GETREPORTE ----> PANEL REPORTES
    
    @Override
    public String getReporte() {
        return "==== PROVEEDOR ====\nID: " + idProveedor + "\nEmpresa: " + empresa + "\nTeléfono: " + telefono + "\nEmail: " + email + "\nDirección: " + direccion + "\n===================";
    }
    
    //TOSTRING PARA REPORTE
    
    @Override
    public String toString() {
        return "==== PROVEEDOR ====\nID: " + idProveedor + "\nEmpresa: " + empresa + "\nTeléfono: " + telefono + "\nEmail: " + email + "\nDirección: " + direccion + "\n===================";
    }

    //CSV PARA PERSISTENCIA
    
    public String toCSV() {
        return idProveedor + ";" + empresa + ";" + telefono + ";" + email + ";" + direccion + ";" + activo;
    }
}

