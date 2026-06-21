package vista.paneles;

import javax.swing.table.DefaultTableModel;
import modelo.proveedores.Proveedor;
import gestion.Inventario;
import javax.swing.JOptionPane;
import vista.ModificarProveedorFrame;
import vista.CrearProveedorFrame;
import vista.DetalleFrame;

/**
 *
 * @author inver
 */
public class PanelProveedores extends javax.swing.JPanel {

    private Inventario inventario;
    
    public PanelProveedores(Inventario inventario) {
        initComponents();
        this.inventario = inventario;
        
        cargarTabla();
        
        configurarDobleClick();
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        modelo.setRowCount(0);
        
        if (chkMostrarInactivos.isSelected()) {
            for (Proveedor proveedor : inventario.listarProveedoresInactivos()) {
                modelo.addRow(new Object[] {proveedor.getIdProveedor(), proveedor.getEmpresa(), proveedor.getTelefono(), proveedor.getEmail(), proveedor.getDireccion()});
            }
        } else {
            for (Proveedor proveedor : inventario.listarProveedoresActivos()) {
                modelo.addRow(new Object[] {proveedor.getIdProveedor(), proveedor.getEmpresa(), proveedor.getTelefono(), proveedor.getEmail(), proveedor.getDireccion()});
            }
        }
    }
    
    private void configurarDobleClick() {
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int fila = tablaProveedores.getSelectedRow();
                    
                    if (fila == -1) {
                        return;
                    }
                    
                    int codigo = Integer.parseInt(tablaProveedores.getValueAt(fila, 0).toString());
                    
                    Proveedor proveedor = inventario.buscarProveedorPorId(codigo);
                    
                    new DetalleFrame("Detalle de Proveedor", proveedor.getReporte()).setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        btnCrearProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnDesactivarProveedor = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnActivarProveedor = new javax.swing.JButton();
        chkMostrarInactivos = new javax.swing.JCheckBox();

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empresa", "Telefono", "Email", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProveedores.setPreferredSize(new java.awt.Dimension(960, 500));
        jScrollPane1.setViewportView(tablaProveedores);

        btnCrearProveedor.setText("Crear Proveedor");
        btnCrearProveedor.setPreferredSize(new java.awt.Dimension(146, 23));
        btnCrearProveedor.addActionListener(this::btnCrearProveedorActionPerformed);

        btnModificarProveedor.setText("Modificar Proveedor");
        btnModificarProveedor.setPreferredSize(new java.awt.Dimension(146, 23));
        btnModificarProveedor.addActionListener(this::btnModificarProveedorActionPerformed);

        btnDesactivarProveedor.setText("Desactivar Proveedor");
        btnDesactivarProveedor.setMaximumSize(new java.awt.Dimension(152, 23));
        btnDesactivarProveedor.setMinimumSize(new java.awt.Dimension(152, 23));
        btnDesactivarProveedor.setPreferredSize(new java.awt.Dimension(154, 23));
        btnDesactivarProveedor.addActionListener(this::btnDesactivarProveedorActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setMaximumSize(new java.awt.Dimension(160, 23));
        btnActualizar.setMinimumSize(new java.awt.Dimension(160, 23));
        btnActualizar.setPreferredSize(new java.awt.Dimension(160, 23));
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnActivarProveedor.setText("Activar Proveedor");
        btnActivarProveedor.setMaximumSize(new java.awt.Dimension(154, 23));
        btnActivarProveedor.setMinimumSize(new java.awt.Dimension(154, 23));
        btnActivarProveedor.setPreferredSize(new java.awt.Dimension(152, 23));
        btnActivarProveedor.addActionListener(this::btnActivarProveedorActionPerformed);

        chkMostrarInactivos.setText("Mostrar Inactivos");
        chkMostrarInactivos.addActionListener(this::chkMostrarInactivosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActivarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarInactivos)
                        .addGap(63, 63, 63)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActivarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCrearProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkMostrarInactivos))
                    .addComponent(btnDesactivarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesactivarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarProveedorActionPerformed
        int fila = tablaProveedores.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor");
            return;
        }
        
        int codigo = Integer.parseInt(tablaProveedores.getValueAt(fila, 0).toString());
        
        Proveedor proveedor = inventario.buscarProveedorPorId(codigo);
        
        if (proveedor == null) {
            JOptionPane.showMessageDialog(this, "Proveedor no encontrado");
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea desactivar el proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            proveedor.setActivo(false);
            cargarTabla();           
        }   
    }//GEN-LAST:event_btnDesactivarProveedorActionPerformed

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        
        int fila = tablaProveedores.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor");
            return;
        }
        
        int id = Integer.parseInt(tablaProveedores.getValueAt(fila, 0).toString());
        
        Proveedor proveedor = inventario.buscarProveedorPorId(id);
        
        if (proveedor != null) {
            JOptionPane.showMessageDialog(this, "Proveedor no encontrado");
            return;
        }
        
        if (!proveedor.isActivo()) {
            JOptionPane.showMessageDialog(this, "No se puede modificar un proveedor inactivo");
            return;
        }
        
        ModificarProveedorFrame frame = new ModificarProveedorFrame(inventario, proveedor);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        
        frame.setVisible(true);
        
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnCrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProveedorActionPerformed
        CrearProveedorFrame frame = new CrearProveedorFrame(inventario);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        
        frame.setVisible(true);
    }//GEN-LAST:event_btnCrearProveedorActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActivarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarProveedorActionPerformed
        int fila = tablaProveedores.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor");
            return;
        }
        
        int id = Integer.parseInt(tablaProveedores.getValueAt(fila, 0).toString());
        
        if (inventario.reactivarProveedor(id)) {
            JOptionPane.showMessageDialog(this, "Proveedor reactivado correctamente");
            cargarTabla();
        }
    }//GEN-LAST:event_btnActivarProveedorActionPerformed

    private void chkMostrarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarInactivosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_chkMostrarInactivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarProveedor;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrearProveedor;
    private javax.swing.JButton btnDesactivarProveedor;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JCheckBox chkMostrarInactivos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
