package vista.paneles;

import gestion.Inventario;
import javax.swing.JOptionPane;

/**
 *
 * @author inver
 */
public class PanelReportes extends javax.swing.JPanel {
    
    private Inventario inventario;

    public PanelReportes(Inventario inventario) {
        initComponents();
        
        this.inventario = inventario;
        
        cargarCombo();
        
        txtReporte.setLineWrap(true);
        txtReporte.setWrapStyleWord(true);
        txtReporte.setEditable(false);
        
        btnImprimir.setEnabled(false);
        
    }

    private void cargarCombo() {
        cmbReporte.removeAllItems();
        
        cmbReporte.addItem("Empleados");
        cmbReporte.addItem("Proveedores");
        cmbReporte.addItem("Insumos");
        cmbReporte.addItem("Movimientos");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtReporte = new javax.swing.JTextArea();
        cmbReporte = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        txtReporte.setColumns(20);
        txtReporte.setLineWrap(true);
        txtReporte.setRows(5);
        txtReporte.setWrapStyleWord(true);
        txtReporte.setMaximumSize(new java.awt.Dimension(950, 450));
        txtReporte.setMinimumSize(new java.awt.Dimension(950, 450));
        txtReporte.setPreferredSize(new java.awt.Dimension(950, 450));
        txtReporte.setCaretPosition(0);
        jScrollPane1.setViewportView(txtReporte);

        cmbReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Reporte a generar:");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(this::btnGenerarActionPerformed);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(this::btnImprimirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnGenerar)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        
        String opcion = cmbReporte.getSelectedItem().toString();
        
        switch(opcion) {
            case "Empleados":
                txtReporte.setText(inventario.generarReporteEmpleados());
                break;
                
            case "Proveedores":
                txtReporte.setText(inventario.generarReporteProveedores());
                break;
                
            case "Insumos":
                txtReporte.setText(inventario.generarReporteInsumos());
                break;
                
            case "Movimientos":
                txtReporte.setText(inventario.generarReporteMovimientos());
                break;
        }
        
        btnImprimir.setEnabled(!txtReporte.getText().isBlank());
        
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            boolean completado = txtReporte.print();
            
            if (txtReporte.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "No hay reportes para imprimir");
                return;
            }
            
            if (completado) {
                JOptionPane.showMessageDialog(this, "Reporte enviado a impresion");
            } else {
                JOptionPane.showMessageDialog(this, "Impresion cancelada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al imprimir: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReporte;
    // End of variables declaration//GEN-END:variables
}
