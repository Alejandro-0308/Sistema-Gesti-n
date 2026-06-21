package modelo.insumos;

import java.util.Date;
import java.text.SimpleDateFormat;
import modelo.proveedores.Proveedor;

//ATRIBUTO Y CONSTRUCTOR

public class InsumoMedico extends Insumo{
    
    private Date fechaVencimiento;
    private boolean requiereFrio;
    
    public InsumoMedico(int codigo, String nombre, String descripcion, int stockActual, int stockMinimo, Proveedor proveedor, Date fechaVencimiento, boolean requiereFrio) {
        
        super(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor);
        this.fechaVencimiento = fechaVencimiento;
        this.requiereFrio = requiereFrio;
        
    }
    
    //GETTER
    
    @Override
    public String getTipo() {
        return "Médico";
    }    
    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    //SETTER
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setRequiereFrio(boolean requiereFrio) {
        this.requiereFrio = requiereFrio;
    }

    //VERIFICACIONES ESPECIALES DE TIPO

    public boolean estaVencido() {
        Date hoy = new Date();
        
        if (this.fechaVencimiento.before(hoy)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isRequiereFrio() {
        return requiereFrio;
    }

    //TOSTRING PARA REPORTE
    
    @Override
    public String toString() {
        String textoFrio;
        
        if (requiereFrio) {
            textoFrio = "Sí";
        } else {
            textoFrio = "No";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String fechaTexto = sdf.format(fechaVencimiento);
        
        return "==== INSUMO MEDICO ====\n" + super.toString() + "\nFecha de vencimiento: " + fechaTexto + "\nRequiere Frio: " + textoFrio + "\n=======================";
    }
    
    //GETREPORTE ----> PANEL REPORTES
    
    @Override
    public String getReporte() {
        String textoFrio;
        
        if (requiereFrio) {
            textoFrio = "Sí";
        } else {
            textoFrio = "No";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String fechaTexto = sdf.format(fechaVencimiento);
        
        return "==== INSUMO MEDICO ====\n" + super.toString() + "\nFecha de vencimiento: " + fechaTexto + "\nRequiere Frio: " + textoFrio + "\n=======================";
    }
    
    //CSV PARA PERSISTENCIA
    
    @Override
    public String toCSV() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return "MEDICO;" + toCSVBase() + ";" + sdf.format(fechaVencimiento) + ";" + requiereFrio;
    }
    
}
