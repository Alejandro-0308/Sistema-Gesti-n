package vista.paneles;

import modelo.movimientos.Movimiento;
import gestion.Inventario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.insumos.Insumo;
import java.text.SimpleDateFormat;
import vista.DetalleFrame;

/**
 *
 * @author inver
 */
public class PanelMovimientos extends javax.swing.JPanel {

    private Inventario inventario;
    
    public PanelMovimientos(Inventario inventario) {
        initComponents();
        
        this.inventario = inventario;
        
        cargarInsumos();
        cargarTabla();
        
        configurarDobleClick();
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();
        
        modelo.setRowCount(0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        for (Movimiento movimiento : inventario.getListaMovimientos()) {
            modelo.addRow(new Object[] {movimiento.getIdMovimiento(), sdf.format(movimiento.getFechaMovimiento()), movimiento.getTipo(), movimiento.getInsumo().getNombre(), movimiento.getCantidad(), movimiento.getEmpleado().getNombre() + " " + movimiento.getEmpleado().getApellido(), movimiento.getObservacion()});
        }
    }
    
    private void cargarInsumos() {
        cmbInsumos.removeAllItems();
        
        for (Insumo insumo: inventario.listarInsumosActivos()) {
            cmbInsumos.addItem(insumo.getNombre());
        }
    }
    
    private void configurarDobleClick() {
        tablaMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int fila = tablaMovimientos.getSelectedRow();
                    
                    if (fila == -1) {
                        return;
                    }
                    
                    int codigo = Integer.parseInt(tablaMovimientos.getValueAt(fila, 0).toString());
                    
                    Movimiento movimiento = inventario.buscarMovimientoPorId(codigo);
                    
                    new DetalleFrame("Detalle de Movimiento", movimiento.getReporte()).setVisible(true);
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        lblInsumo = new javax.swing.JLabel();
        cmbInsumos = new javax.swing.JComboBox<>();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblObservacion = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();

        btnEntrada.setText("Entrada");
        btnEntrada.setMinimumSize(new java.awt.Dimension(92, 23));
        btnEntrada.addActionListener(this::btnEntradaActionPerformed);

        btnSalida.setText("Salida");
        btnSalida.setMaximumSize(new java.awt.Dimension(92, 23));
        btnSalida.setPreferredSize(new java.awt.Dimension(92, 23));
        btnSalida.addActionListener(this::btnSalidaActionPerformed);

        tablaMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Tipo", "Insumo", "Cantidad", "Empleado", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMovimientos.setPreferredSize(new java.awt.Dimension(962, 500));
        jScrollPane1.setViewportView(tablaMovimientos);

        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(92, 23));
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        lblInsumo.setText("Insumo:");

        cmbInsumos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbInsumos.setPreferredSize(new java.awt.Dimension(96, 22));
        cmbInsumos.addActionListener(this::cmbInsumosActionPerformed);

        lblCantidad.setText("Cantidad:");

        txtCantidad.addActionListener(this::txtCantidadActionPerformed);

        lblObservacion.setText("Observacion:");

        txtObservacion.setPreferredSize(new java.awt.Dimension(217, 22));
        txtObservacion.addActionListener(this::txtObservacionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblObservacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInsumo)
                    .addComponent(cmbInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservacion)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInsumosActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaActionPerformed
        try {
        
            if (cmbInsumos.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "No hay insumos disponibles");
                return;
            } 
            
            String nombreInsumo = cmbInsumos.getSelectedItem().toString();
        
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero");
                return;
            }
            
            String observacion = txtObservacion.getText();
        
            if (inventario.registrarEntrada(nombreInsumo, cantidad, observacion)) {
                JOptionPane.showMessageDialog(this, "Entrada registrada correctamente");
            
                cargarTabla();
                
                txtCantidad.setText("");
                txtObservacion.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar la entrada");
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida");
        }    
        
    }//GEN-LAST:event_btnEntradaActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        try {
            
            if (cmbInsumos.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "No hay insumos disponibles");
                return;
            } 
            
            String nombreInsumo = cmbInsumos.getSelectedItem().toString();
        
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero");
                return;
            }
            
            String observacion = txtObservacion.getText();
        
            if (inventario.registrarSalida(nombreInsumo, cantidad, observacion)) {
                
               JOptionPane.showMessageDialog(this, "Salida registrada correctamente");
        
               cargarTabla();
               
               txtCantidad.setText("");
               txtObservacion.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No hay stock suficiente");
            }
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida");
        }    
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnSalida;
    private javax.swing.JComboBox<String> cmbInsumos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblInsumo;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
