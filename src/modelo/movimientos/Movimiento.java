package modelo.movimientos;

import java.util.Date;
import java.text.SimpleDateFormat;
import enums.TipoMovimiento;
import modelo.insumos.Insumo;
import modelo.empleados.Empleado;

/**
 *
 * @author inver
 */

//ATRIBUTOS Y CONSTRUCTOR

public class Movimiento implements interfaces.Reportable {
    
    private int idMovimiento;
    private Date fechaMovimiento;
    private TipoMovimiento tipo;
    private int cantidad;
    private String observacion;
    private Insumo insumo;
    private Empleado empleado;
    
    public Movimiento(int idMovimiento, Date fechaMovimiento, TipoMovimiento tipo, int cantidad, String observacion, Insumo insumo, Empleado empleado) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.insumo = insumo;
        this.empleado = empleado;
    }
    
    //CONSTRUCTOR SOBRECARGADO
    
    public Movimiento(int idMovimiento, Date fechaMovimiento, TipoMovimiento tipo, int cantidad, Insumo insumo, Empleado empleado) {
        
        this(idMovimiento, fechaMovimiento, tipo, cantidad, "Nada que reportar", insumo, empleado);
        
    }
    
    //GETTERS
    
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
    //GETREPORTE ----> PANEL REPORTES
    
    @Override
    public String getReporte() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = sdf.format(fechaMovimiento);
        return "Movimiento N°: " + idMovimiento + " [" + tipo + "] " 
                + "\nFecha: " + fechaTexto 
                + "\nInsumo: " + insumo.getNombre() 
                + "\nCantidad: " + cantidad 
                + "\nResponsable: " + empleado.getNombre() + " " + empleado.getApellido()
                + "\nObservaciones: " + observacion;
    }

    //SETTERS

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    //TOSTRING PARA REPORTE
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = sdf.format(fechaMovimiento);
        return "==== MOVIMIENTO ====\nID: " + idMovimiento 
                + "\nFecha: " + fechaTexto
                + "\nTipo: " + tipo 
                + "\nCantidad: " + cantidad 
                + "\nObservacion: " + observacion 
                + "\nInsumo: " + insumo.getNombre()
                + "\nEmpleado: " + empleado.getNombre() + " " + empleado.getApellido()
                + "\n====================";
    }
    
    //CSV PARA PERSISTENCIA
    
    public String toCSV() {
        return idMovimiento + ";" + fechaMovimiento.getTime() + ";" + tipo + ";" + cantidad + ";" + observacion + ";" + insumo.getCodigo() + ";" + empleado.getLegajo();
    }
}
