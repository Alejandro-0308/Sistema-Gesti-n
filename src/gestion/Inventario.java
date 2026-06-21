package gestion;

import enums.TipoMovimiento;
import java.util.ArrayList;    
import modelo.insumos.Insumo; 
import modelo.movimientos.Movimiento;
import modelo.proveedores.Proveedor;
import modelo.empleados.Empleado;
import java.util.Date;
import enums.Rol;

//ATRIBUTOS & CONSTRUCTOR

public class Inventario {
    
    private ArrayList<Insumo> listaInsumos;
    private ArrayList<Movimiento> listaMovimientos;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Empleado> listaEmpleados;
    private Empleado empleadoLogueado;
    private int proximoCodigoInsumo;
    private int proximoIdProveedor;
    private int proximoLegajo;
    private int proximoIdMovimiento;
    
    public Inventario() {
        
        this.listaInsumos = new ArrayList<>();
        this.listaMovimientos = new ArrayList<>();
        this.listaProveedores = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();

        this.proximoCodigoInsumo = 1;
        this.proximoIdMovimiento = 1;
        this.proximoLegajo = 1;
        this.proximoIdProveedor = 1;
        
    }

    // GETTERS
    
    public ArrayList<Insumo> getListaInsumos() {
        return listaInsumos;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public Empleado getEmpleadoLogueado() {
        return empleadoLogueado;
    }
    
    // AGREGAR
    
    public void agregarProveedor(Proveedor proveedor) {
        listaProveedores.add(proveedor);
    }
    
    public void agregarInsumo(Insumo insumo) {
        listaInsumos.add(insumo);
    }
    
    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }
    
    public void agregarMovimiento(Movimiento movimiento) {
        listaMovimientos.add(movimiento);
    }
    
    //GENERAR
    
    public int generarCodigoInsumo() {
        return proximoCodigoInsumo++;
    }
    
    public int generarIdProveedor() {
        return proximoIdProveedor++;
    }
    
    public int generarLegajo() {
        return proximoLegajo++;
    }
    
    public int generarIdMovimiento() {
        return proximoIdMovimiento++;
    }
    
// REGISTAR ENTRADA/SALIDA
    
    public boolean registrarEntrada(String nombreInsumo, int cantidad, String observacion) {
        if (cantidad <= 0 || empleadoLogueado == null) {
            return false;
        }
        
        Insumo insumo = buscarInsumoPorNombre(nombreInsumo);
        
        if (insumo != null) {
            insumo.aumentarStock(cantidad);
            Movimiento movimiento = new Movimiento(generarIdMovimiento(), new Date(), TipoMovimiento.ENTRADA, cantidad, observacion, insumo, empleadoLogueado);
            agregarMovimiento(movimiento);
            return true;
        }
        return false;
    }
    
    public boolean registrarSalida(String nombreInsumo, int cantidad, String observacion) {
        if (cantidad <= 0 || empleadoLogueado == null) {
            return false;
        }
        
        Insumo insumo = buscarInsumoPorNombre(nombreInsumo);
        
        if (insumo == null || !insumo.isActivo()) {
            return false;
        }
        
        if (insumo != null && insumo.hayStock(cantidad)) {
            
            insumo.restarStock(cantidad);
                
            Movimiento movimiento = new Movimiento(generarIdMovimiento(), new Date(), TipoMovimiento.SALIDA, cantidad, observacion, insumo, empleadoLogueado);
            
            agregarMovimiento(movimiento);
            
            return true;
        }
        return false;
    }
    
// DESACTIVAR & REACTIVAR
    
    public boolean desactivarInsumo(int codigo) {
        Insumo insumo = buscarInsumoPorCodigo(codigo);
        if (insumo != null) {
            insumo.setActivo(false);
            return true;
        }
        return false;
    }
    
    public boolean desactivarProveedor(String empresa) {
        Proveedor proveedor = buscarProveedorPorNombre(empresa);
        if (proveedor != null) {
            proveedor.setActivo(false);
            return true;
        }
        return false;
    }
    
    public boolean desactivarEmpleado(int legajo) {
        Empleado empleado = buscarEmpleadoPorLegajo(legajo);
        if (empleado != null) {
            empleado.setActivo(false);
            return true;
        }
        return false;
    }
    
    public boolean reactivarProveedor(int idProveedor) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdProveedor() == idProveedor) {
                proveedor.setActivo(true);
                return true;
            }
        }
        return false;
    }
    
    public boolean reactivarInsumo(int codigo) {
        for (Insumo insumo : listaInsumos) {
            if (insumo.getCodigo() == codigo) {
                insumo.setActivo(true);
                return true;
            }
        }
        return false;
    }
    
    public boolean reactivarEmpleado(int legajo) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getLegajo() == legajo) {
                empleado.setActivo(true);
                return true;
            }
        }
        return false;
    }
    
// BUSQUEDAS
    
    public Proveedor buscarProveedorPorId(int idProveedor) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdProveedor() == idProveedor) {
                return proveedor;
            } 
        }
        return null;
    }
    
    public Empleado buscarEmpleadoPorLegajo(int legajo) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getLegajo() == legajo) {
                return empleado;
            } 
        }
        return null;
    }
    
    public Insumo buscarInsumoPorCodigo(int codigo) {
        for (Insumo insumo : listaInsumos) {
            if (insumo.getCodigo() == codigo) {
                return insumo;
            }
        }
        return null;
    }
    
    public Insumo buscarInsumoPorNombre(String nombre) {
        for (Insumo insumo : listaInsumos) {
            if(insumo.getNombre().equalsIgnoreCase(nombre)) {
                return insumo;
            }
        }
        return null;
    }

    public Proveedor buscarProveedorPorNombre(String empresa) {
        for (Proveedor proveedor : listaProveedores) {
            if(proveedor.getEmpresa().equalsIgnoreCase(empresa)) {
                return proveedor;
            }
        }
        return null;
    }
    
    public Movimiento buscarMovimientoPorId(int codigo) {
        for (Movimiento movimiento : listaMovimientos) {
            if(movimiento.getIdMovimiento() == codigo) {
                return movimiento;
            }
        }
        return null;
    }


// GETS TOTALES
   
    public ArrayList<Movimiento> getHistorialMovimientos() {
        return listaMovimientos;
    }
    
    public int getStockTotal() {
        
        int total = 0;
        
        for (Insumo insumo : listaInsumos) {
            total += insumo.getStockActual();
        }
        return total;
    }
    
    public int getTotalEntradas() {
        int totalEntradas =0;
        for (Movimiento movimiento : listaMovimientos) {
            if (movimiento.getTipo() == TipoMovimiento.ENTRADA) {
                totalEntradas += movimiento.getCantidad();
            }
        }
        return totalEntradas;
    }
    
    public int getTotalSalidas() {
        int totalSalidas =0;
        for (Movimiento movimiento : listaMovimientos) {
            if (movimiento.getTipo() == TipoMovimiento.SALIDA) {
                totalSalidas += movimiento.getCantidad();
            }
        }
        return totalSalidas;
    }
    
    public int getTotalMovimientos() {
        return listaMovimientos.size();
    }
    
// LISTAR
    
    public ArrayList<Insumo> listarInsumosBajoMinimo() {
        ArrayList<Insumo> bajoMinimo = new ArrayList<>();
        
        for (Insumo insumo : listaInsumos) {
            if (insumo.isActivo() && insumo.necesitaReposicion()) {
                bajoMinimo.add(insumo);
            }
        }
        return bajoMinimo;
    }
    
    public ArrayList<Insumo> listarInsumosActivos() {
        ArrayList<Insumo> activos = new ArrayList<>();
        for (Insumo insumo : listaInsumos) {
            if (insumo.isActivo()) {
                activos.add(insumo);
            }
        }
        return activos;
    }
    
    public ArrayList<Insumo> listarInsumosInactivos() {
        ArrayList<Insumo> inactivos = new ArrayList<>();
        for (Insumo insumo : listaInsumos) {
            if (!insumo.isActivo()) {
                inactivos.add(insumo);
            }
        }
        return inactivos;
    }

    public ArrayList<Proveedor> listarProveedoresActivos() {
        ArrayList<Proveedor> activos = new ArrayList<>();
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.isActivo()) {
                activos.add(proveedor);
            }
        }
        return activos;
    }
    
    public ArrayList<Proveedor> listarProveedoresInactivos() {
        ArrayList<Proveedor> inactivos = new ArrayList<>();
        for (Proveedor proveedor : listaProveedores) {
            if (!proveedor.isActivo()) {
                inactivos.add(proveedor);
            }
        }
        return inactivos;
    }
    
    public ArrayList<Empleado> listarEmpleadosActivos() {
        ArrayList<Empleado> activos = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.isActivo()) {
                activos.add(empleado);
            }
        }
        return activos;
    }
    
    public ArrayList<Empleado> listarEmpleadosInactivos() {
        ArrayList<Empleado> inactivos = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (!empleado.isActivo()) {
                inactivos.add(empleado);
            }
        }
        return inactivos;
    }
    
    // REPORTES
    
    public String generarReporteEmpleados() {
        
        StringBuilder sb = new StringBuilder();
        
        for (Empleado empleado : listaEmpleados) {
            sb.append(empleado.getReporte()).append("\n\n");
        }
        
        return sb.toString();
    }
    
    public String generarReporteProveedores() {
        
        StringBuilder sb = new StringBuilder();
        
        for (Proveedor proveedor : listaProveedores) {
            sb.append(proveedor.getReporte()).append("\n\n");
        }
        
        return sb.toString();
    }
    
    public String generarReporteInsumos() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("===== RESUMEN DE INSUMOS =====\n");
        sb.append("Cantidad de insumos: ").append(listaInsumos.size()).append("\n");
        sb.append("Stock total: ").append(getStockTotal()).append("\n\n");
        
        for (Insumo insumo : listaInsumos) {
            sb.append(insumo.getReporte()).append("\n\n");
        }
        
        return sb.toString();
    }
    
    public String generarReporteMovimientos() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("===== RESUMEN DE MOVIMIENTOS =====\n");
        sb.append("Cantidad de movimientos: ").append(getTotalMovimientos()).append("\n");
        sb.append("Total de entradas: ").append(getTotalEntradas()).append("\n");
        sb.append("Total de salidas: ").append(getTotalSalidas()).append("\n\n");
        
        for (Movimiento movimiento : listaMovimientos) {
            sb.append(movimiento.getReporte()).append("\n\n");
        }
        
        return sb.toString();
    }
    
    // LOGIN
    
    public boolean login(int legajo, String contrasena) {
        
        Empleado empleado = buscarEmpleadoPorLegajo(legajo);
        
        if (empleado != null && empleado.getContrasena().equals(contrasena)) {
            empleadoLogueado = empleado;
            return true;
        }
        return false;
    }
    
    public void logout() {
        empleadoLogueado = null;
    }
    
    public boolean haySesionesActivas() {
        return empleadoLogueado != null;
    }
    
    // CALCULOS
    
    public void recalcularIds() {
        
        int maxInsumo = 1000;
        int maxProveedor = 1000;
        int maxEmpleado = 1000;
        int maxMovimiento = 1000;
        
        for (Insumo insumo : listaInsumos) {
            if (insumo.getCodigo() > maxInsumo) {
                maxInsumo = insumo.getCodigo();
            }
        }
        
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdProveedor() > maxProveedor) {
                maxProveedor = proveedor.getIdProveedor();
            }
        }
        
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getLegajo() > maxEmpleado) {
                maxEmpleado = empleado.getLegajo();
            }
        }
        
        for (Movimiento movimiento : listaMovimientos) {
            if (movimiento.getIdMovimiento() > maxMovimiento) {
                maxMovimiento = movimiento.getIdMovimiento();
            }
        }
        
        proximoCodigoInsumo = maxInsumo + 1;
        proximoIdProveedor = maxProveedor + 1;
        proximoLegajo = maxEmpleado + 1;
        proximoIdMovimiento = maxMovimiento + 1;
        
    }
    
}