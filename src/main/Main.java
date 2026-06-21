package main;

import gestion.Inventario;
import vista.LoginFrame;
import persistencia.PersistenciaCSV;
import vista.CargaFrame;
import javax.swing.SwingWorker;

/**
 *
 * @author inver
 */

//CONSTRUCTOR DEL MAIN PARA LA EJECUCION

public class Main {
    
    public static void main(String[] args) {
        
        Inventario inventario = new Inventario();
        
        CargaFrame carga = new CargaFrame();
        carga.setVisible(true);
        
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            
            @Override
            protected Void doInBackground() throws Exception {
                
                PersistenciaCSV.cargarTodo(inventario);
                
                return null;
            }
            
            @Override
            protected void done() {
                
                carga.dispose();
                
                LoginFrame login = new LoginFrame(inventario);
                login.setVisible(true);
                
            }
            
        };
        
        worker.execute();
        
    }
    
}
