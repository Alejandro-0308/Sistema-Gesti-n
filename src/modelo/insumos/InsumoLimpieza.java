package modelo.insumos;

import modelo.proveedores.Proveedor;

//ATRIBUTO Y CONSTRUCTOR

public class InsumoLimpieza extends Insumo {
    
    private boolean quimico;

    public InsumoLimpieza(int codigo, String nombre, String descripcion, int stockActual, int stockMinimo, Proveedor proveedor, boolean quimico) {
        
        super(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor);
        
        this.quimico = quimico;
        
    }
    
    //GETTER
    
    @Override
    public String getTipo() {
        return "Limpieza";
    }
    
    //SETTER

    public void setQuimico(boolean quimico) {
        this.quimico = quimico;
    }
    
    //VERIFICACIONES ESPECIALES DE TIPO
    
    public boolean requiereManipulacionEspecial() {
        return this.quimico;
    }

    public boolean isQuimico() {
        return quimico;
    }
    
    //TOSTRING PARA REPORTE
    
    @Override
    public String toString() {
        String textoQuimico;
        
        if (quimico) {
            textoQuimico = "Sí";
        } else {
            textoQuimico = "No";
        }
        
        String textoManipulacion;
        
        return "==== INSUMO LIMPIEZA ====\n" + super.toString() + "\nQuimico: " + textoQuimico + "\n=========================";
    }
    
    //GETREPORTE ----> PANEL REPORTES
    
    @Override
    public String getReporte() {
        String textoQuimico;
        
        if (quimico) {
            textoQuimico = "Sí";
        } else {
            textoQuimico = "No";
        }
        
        return "==== INSUMO LIMPIEZA ====\n" + super.toString() + "\nQuimico: " + textoQuimico + "\n=========================";
    }
    
    //CSV PARA PERSISTENCIA
    
    @Override
    public String toCSV() {
        return "LIMPIEZA;" + toCSVBase() + ";" + quimico;
    }
}
