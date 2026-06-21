package persistencia;

import gestion.Inventario;
import java.io.BufferedReader;
import java.io.FileReader;
import modelo.insumos.Insumo;
import java.io.PrintWriter;
import modelo.proveedores.Proveedor;
import modelo.empleados.Empleado;
import modelo.movimientos.Movimiento;
import modelo.insumos.InsumoAdministrativo;
import modelo.insumos.InsumoLimpieza;
import modelo.insumos.InsumoMedico;
import enums.TiposAdministrativos;
import enums.Rol;
import enums.Sector;
import enums.TipoMovimiento;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author inver
 */

//ATRIBUTOS Y METODOS

public class PersistenciaCSV {
    
    private Inventario inventario;
 
    //INSUMOS
    
    public static void guardarInsumos(Inventario inventario) {
        
        try (PrintWriter pw = new PrintWriter("insumos.csv")) {
            for (Insumo insumo : inventario.getListaInsumos()) {
                pw.println(insumo.toCSV());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void cargarInsumos(Inventario inventario) {
        
        File archivo = new File("insumos.csv");
        
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("insumos.csv"))) {
            String linea;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                String tipo = datos[0];
                
                int codigo = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                String descripcion = datos[3];
                int stockActual = Integer.parseInt(datos[4]);
                int stockMinimo = Integer.parseInt(datos[5]);
                int idProveedor = Integer.parseInt(datos[6]);
                
                Proveedor proveedor = inventario.buscarProveedorPorId(idProveedor);
                
                boolean activo = Boolean.parseBoolean(datos[7]);
                
                Insumo insumo = null;
                
                switch (tipo) {
                    case "ADMINISTRATIVO":
                        TiposAdministrativos categoria = TiposAdministrativos.valueOf(datos[8]);

                        insumo = new InsumoAdministrativo(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor, categoria);
                        break;
                    
                    case "LIMPIEZA":
                        boolean quimico = Boolean.parseBoolean(datos[8]);
                    
                        insumo = new InsumoLimpieza(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor, quimico);
                        break;
                    
                    case "MEDICO":
                        Date fechaVencimiento = sdf.parse(datos[8]);
                        
                        boolean requiereFrio = Boolean.parseBoolean(datos[9]);
                        
                        insumo = new InsumoMedico(codigo, nombre, descripcion, stockActual, stockMinimo, proveedor, fechaVencimiento, requiereFrio);
                        break;
                }
                if (insumo != null) {
                    insumo.setActivo(activo);
                    inventario.agregarInsumo(insumo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //PROVEEDORES
    
    public static void guardarProveedores(Inventario inventario) {
        
        try (PrintWriter pw = new PrintWriter("proveedores.csv")) {
            for (Proveedor proveedor : inventario.getListaProveedores()) {
                pw.println(proveedor.toCSV());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void cargarProveedores(Inventario inventario) {
        
        File archivo = new File("proveedores.csv");
        
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("proveedores.csv"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                int id = Integer.parseInt(datos[0]);
                String empresa = datos[1];
                String telefono = datos[2];
                String email = datos[3];
                String direccion = datos[4];
                boolean activo = Boolean.parseBoolean(datos[5]);
                
                Proveedor proveedor = new Proveedor(id, empresa, telefono, email, direccion);
                
                proveedor.setActivo(activo);
                
                inventario.agregarProveedor(proveedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //EMPLEADOS
    
    public static void guardarEmpleados(Inventario inventario) {
        
        try (PrintWriter pw = new PrintWriter("empleados.csv")) {
            for (Empleado empleado : inventario.getListaEmpleados()) {
                pw.println(empleado.toCSV());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void cargarEmpleados(Inventario inventario) {
        
        File archivo = new File("empleados.csv");
        
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("empleados.csv"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                int legajo = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                Sector sector = Sector.valueOf(datos[3]);
                Rol rol = Rol.valueOf(datos[4]);
                String contrasena = datos[5];
                boolean activo = Boolean.parseBoolean(datos[6]);
                
                Empleado empleado = new Empleado(legajo, nombre, apellido, sector, rol, contrasena);
                
                empleado.setActivo(activo);
                
                inventario.agregarEmpleado(empleado);
            }
        } catch (Exception e) {
                e.printStackTrace();
                }
        
    }
    
    //MOVIMIENTOS
    
    public static void guardarMovimientos(Inventario inventario) {
        
        try (PrintWriter pw = new PrintWriter("movimientos.csv")) {

            for (Movimiento movimiento : inventario.getListaMovimientos()) {
                pw.println(movimiento.toCSV());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void cargarMovimientos(Inventario inventario) {
        
        File archivo = new File("movimientos.csv");
        
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("movimientos.csv"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                int idMovimiento = Integer.parseInt(datos[0]);
                Date fechaMovimiento = new Date(Long.parseLong(datos[1]));
                TipoMovimiento tipo = TipoMovimiento.valueOf(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                String observacion = datos[4];
                int codigoInsumo = Integer.parseInt(datos[5]);
                int legajoEmpleado = Integer.parseInt(datos[6]);
                Insumo insumo = inventario.buscarInsumoPorCodigo(codigoInsumo);
                Empleado empleado = inventario.buscarEmpleadoPorLegajo(legajoEmpleado);
                
                if (insumo != null && empleado != null) {
                    Movimiento movimiento = new Movimiento(idMovimiento, fechaMovimiento, tipo, cantidad, observacion, insumo, empleado);
                    inventario.agregarMovimiento(movimiento);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //METODOS DE GUARDAR Y CARGAR TODO PARA EL INICIO DEL PROGRAMA
    
    public static void guardarTodo(Inventario inventario) {
        
        guardarProveedores(inventario);
        guardarEmpleados(inventario);
        guardarInsumos(inventario);
        guardarMovimientos(inventario);
        
    }
    
    public static void cargarTodo(Inventario inventario) {
        
        cargarProveedores(inventario);
        cargarEmpleados(inventario);
        cargarInsumos(inventario);
        cargarMovimientos(inventario);
        
        inventario.recalcularIds();
        
    }
}

