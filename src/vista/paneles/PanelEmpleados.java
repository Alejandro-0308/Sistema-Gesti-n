package vista.paneles;

import gestion.Inventario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.empleados.Empleado;
import vista.CrearEmpleadoFrame;
import vista.DetalleFrame;
import vista.ModificarEmpleadoFrame;

public class PanelEmpleados extends javax.swing.JPanel {
    
    private Inventario inventario;

    public PanelEmpleados(Inventario inventario) {
        initComponents();
        
        this.inventario = inventario;
        
        cargarTabla();
        
        configurarDobleClick();
    }
    
    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        modelo.setRowCount(0);
        
        if (chkMostrarInactivos.isSelected()) {
            for (Empleado empleado : inventario.listarEmpleadosInactivos()) {
                modelo.addRow(new Object[] {empleado.getLegajo(), empleado.getNombre(), empleado.getApellido(), empleado.getSector(), empleado.getRol()});
            }
        } else {
            for (Empleado empleado : inventario.listarEmpleadosActivos()) {
                modelo.addRow(new Object[] {empleado.getLegajo(), empleado.getNombre(), empleado.getApellido(), empleado.getSector(), empleado.getRol()});
            }
        }
    }

    private void configurarDobleClick() {
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int fila = tablaEmpleados.getSelectedRow();
                    
                    if (fila == -1) {
                        return;
                    }
                    
                    int codigo = Integer.parseInt(tablaEmpleados.getValueAt(fila, 0).toString());
                    
                    Empleado empleado = inventario.buscarEmpleadoPorLegajo(codigo);
                    
                    new DetalleFrame("Detalle de Empleado", empleado.getReporte()).setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearEmpleado = new javax.swing.JButton();
        btnModificarEmpleado = new javax.swing.JButton();
        btnDesactivarEmpleado = new javax.swing.JButton();
        btnReactivarEmpleado = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        chkMostrarInactivos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        btnCrearEmpleado.setText("Crear Empleado");
        btnCrearEmpleado.setMaximumSize(new java.awt.Dimension(137, 23));
        btnCrearEmpleado.setMinimumSize(new java.awt.Dimension(137, 23));
        btnCrearEmpleado.setPreferredSize(new java.awt.Dimension(137, 23));
        btnCrearEmpleado.addActionListener(this::btnCrearEmpleadoActionPerformed);

        btnModificarEmpleado.setText("Modificar Empleado");
        btnModificarEmpleado.setMaximumSize(new java.awt.Dimension(148, 23));
        btnModificarEmpleado.setMinimumSize(new java.awt.Dimension(148, 23));
        btnModificarEmpleado.setPreferredSize(new java.awt.Dimension(148, 23));
        btnModificarEmpleado.addActionListener(this::btnModificarEmpleadoActionPerformed);

        btnDesactivarEmpleado.setText("Desactivar Empleado");
        btnDesactivarEmpleado.setMaximumSize(new java.awt.Dimension(168, 23));
        btnDesactivarEmpleado.setMinimumSize(new java.awt.Dimension(168, 23));
        btnDesactivarEmpleado.setPreferredSize(new java.awt.Dimension(168, 23));
        btnDesactivarEmpleado.addActionListener(this::btnDesactivarEmpleadoActionPerformed);

        btnReactivarEmpleado.setText("Reactivar Empleado");
        btnReactivarEmpleado.setMaximumSize(new java.awt.Dimension(150, 23));
        btnReactivarEmpleado.setMinimumSize(new java.awt.Dimension(150, 23));
        btnReactivarEmpleado.setPreferredSize(new java.awt.Dimension(150, 23));
        btnReactivarEmpleado.addActionListener(this::btnReactivarEmpleadoActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        chkMostrarInactivos.setText("Mostrar Inactivos");
        chkMostrarInactivos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkMostrarInactivos.addActionListener(this::chkMostrarInactivosActionPerformed);

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Legajo", "Nombre", "Apellido", "Sector", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpleados.setPreferredSize(new java.awt.Dimension(960, 500));
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReactivarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkMostrarInactivos)
                    .addComponent(btnReactivarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEmpleadoActionPerformed
        CrearEmpleadoFrame frame = new CrearEmpleadoFrame(inventario);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        
        frame.setVisible(true);
    }//GEN-LAST:event_btnCrearEmpleadoActionPerformed

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        int fila = tablaEmpleados.getSelectedRow();
        
        int id = Integer.parseInt(tablaEmpleados.getValueAt(fila, 0).toString());
        
        Empleado empleado = inventario.buscarEmpleadoPorLegajo(id);
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado");
            return;
        }
        
        if (!empleado.isActivo()) {
            JOptionPane.showMessageDialog(this, "No se puede modificar un empleado inactivo");
            return;
        }
        
        if (empleado != null) {
            new ModificarEmpleadoFrame(inventario, empleado).setVisible(true);
            cargarTabla();
        }
        
        ModificarEmpleadoFrame frame = new ModificarEmpleadoFrame(inventario, empleado);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        
        frame.setVisible(true);
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void btnDesactivarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarEmpleadoActionPerformed
        int fila = tablaEmpleados.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado");
            return;
        }
        
        int codigo = Integer.parseInt(tablaEmpleados.getValueAt(fila, 0).toString());
        
        Empleado empleado = inventario.buscarEmpleadoPorLegajo(codigo);
        
        if (empleado == null) {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado");
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea desactivar el Empleado?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            empleado.setActivo(false);
            cargarTabla();           
        }   
    }//GEN-LAST:event_btnDesactivarEmpleadoActionPerformed

    private void btnReactivarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarEmpleadoActionPerformed
        int fila = tablaEmpleados.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado");
            return;
        }
        
        int id = Integer.parseInt(tablaEmpleados.getValueAt(fila, 0).toString());
        
        if (inventario.reactivarEmpleado(id)) {
            JOptionPane.showMessageDialog(this, "Empleado reactivado correctamente");
            cargarTabla();
        }
    }//GEN-LAST:event_btnReactivarEmpleadoActionPerformed

    private void chkMostrarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarInactivosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_chkMostrarInactivosActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrearEmpleado;
    private javax.swing.JButton btnDesactivarEmpleado;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnReactivarEmpleado;
    private javax.swing.JCheckBox chkMostrarInactivos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
