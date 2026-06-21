package modelo.insumos;

import modelo.proveedores.Proveedor;

/**
 *
 * @author inver
 */

//ATRIBUTOS Y CONSTRUCTOR

public abstract class Insumo implements interfaces.Reportable {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private int stockActual;
    private int stockMinimo;
    private Proveedor proveedor;
    private boolean activo;
    
    public Insumo(int codigo, String nombre, String descripcion, int stockActual, int stockMinimo, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.proveedor = proveedor;
        this.activo = true;
    }
    
    public Insumo(int codigo, String nombre, String descripcion, Proveedor proveedor) {
        this(codigo, nombre, descripcion, 0, 0, proveedor);
    }
    
    //METODOS LOGICOS PARA EL STOCK
    
    public void aumentarStock(int cantidad) {
        this.stockActual += cantidad;
    }
    
    public boolean restarStock(int cantidad) {
        
        if (cantidad > stockActual) {
            return false;
        }
        stockActual -= cantidad;
        return true;
    }
    
    public boolean necesitaReposicion() {
        return stockActual <= stockMinimo;
    }
    
    public boolean hayStock(int cantidad) {
        return this.stockActual >= cantidad;
    }
    
    //GETTERS
    
    public abstract String getTipo();

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    
    //GET REPORTE ----> PANEL REPORTES
    
    @Override
    public String getReporte() {
        
        return "Codigo: " + codigo + "\nNombre: " + nombre + "\nProveedor: " + proveedor.getEmpresa() + "\n " + "\nDescripcion: " + descripcion + "\n " + "\nStock Minimo: " + stockMinimo;
        
    }
    
    //ALTA ACTIVA PARA EL INSUMO
    
    public boolean isActivo() {
        return activo;
    }

    //SETTERS
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void setActivo (boolean activo) {
        this.activo = activo;
    }
    
    //TOSTRING PARA EL REPORTE
    
    @Override
    public String toString() {
        
        return "Codigo: " + codigo + "\nNombre: " + nombre + "\nProveedor: " + proveedor.getEmpresa() + "\n " + "\nDescripcion: " + descripcion + "\n " + "\nStock Minimo: " + stockMinimo;
        
    }
 
    //CSV PARA PERSISTENCIA
    
    public abstract String toCSV();
    
    public String toCSVBase() {
        return codigo + ";" + nombre + ";" + descripcion + ";" + stockActual + ";" + stockMinimo + ";" + proveedor.getIdProveedor() + ";" + activo;
    }
}
