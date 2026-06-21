package modelo.insumos;

import modelo.proveedores.Proveedor;
import enums.TiposAdministrativos;

//ATRIBUTOS Y CONSTRUCTOR

public class InsumoAdministrativo extends Insumo{
    
    private TiposAdministrativos categoria;

    public InsumoAdministrativo(int codigo, String nombre, String descripcion, int stockActual, int stockMinimo, Proveedor proveedor, TiposAdministrativos categoria) {
        
        super(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor);
        
        this.categoria = categoria;
        
    }
    
    //GETTERS
    
    @Override
    public String getTipo() {
        return "Administrativo";
    }

    public TiposAdministrativos getCategoria() {
        return categoria;
    }

    //SETER
    
    public void setCategoria(TiposAdministrativos categoria) {
        this.categoria = categoria;
    }
    
    //TOSTRING PARA REPORTE
    
    @Override
    public String toString() {
        return "==== INSUMO ADMINISTRATIVO ====\n" + super.toString() + "\nCategoria: " + categoria + "\n===============================";
    }
    
    //GETREPORTE ----> PANEL REPORTE
    
    @Override
    public String getReporte() {
        return "==== INSUMO ADMINISTRATIVO ====\n" + super.toString() + "\nCategoria: " + categoria + "\n===============================";
    }
    
    //CSV PARA PERSISTENCIA
    
    @Override
    public String toCSV() {
        return "ADMINISTRATIVO;" + toCSVBase() + ";" + categoria;
    }
}
