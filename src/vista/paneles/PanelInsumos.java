package vista.paneles;

import gestion.Inventario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.insumos.Insumo;
import vista.CrearInsumoFrame;
import vista.DetalleFrame;
import vista.ModificarInsumoFrame;

/**
 *
 * @author inver
 */
public class PanelInsumos extends javax.swing.JPanel {

    private Inventario inventario;
    
    public PanelInsumos(Inventario inventario) {
        initComponents();
        this.inventario = inventario;
        
        cargarTabla();
        
        configurarDobleClick();
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaInsumos.getModel();
        
        modelo.setRowCount(0);
        
        if (rdBajoMinimo.isSelected()) {
            for (Insumo insumo : inventario.listarInsumosBajoMinimo()) {
                agregarFila(modelo, insumo);
            }
        } else if (rdInactivos.isSelected()) {
            for (Insumo insumo : inventario.listarInsumosInactivos()) {
                agregarFila(modelo, insumo);
            }
        } else {
            for (Insumo insumo : inventario.listarInsumosActivos()) {
                agregarFila(modelo, insumo);
            }
        }
        
    }
    
    private void agregarFila(DefaultTableModel modelo, Insumo insumo) {
        String estado;
        
        if (insumo.necesitaReposicion()) {
            estado = "REPOSICION";
        } else {
            estado = "OK";
        }
        
        modelo.addRow(new Object[]{insumo.getCodigo(), insumo.getNombre(), insumo.getDescripcion(), insumo.getTipo(), insumo.getStockActual(), insumo.getStockMinimo(), estado, insumo.getProveedor().getEmpresa()});
    }
    
    private void configurarDobleClick() {
        tablaInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int fila = tablaInsumos.getSelectedRow();
                    
                    if (fila == -1) {
                        return;
                    }
                    
                    int codigo = Integer.parseInt(tablaInsumos.getValueAt(fila, 0).toString());
                    
                    Insumo insumo = inventario.buscarInsumoPorCodigo(codigo);
                    
                    new DetalleFrame("Detalle de Insumo", insumo.getReporte()).setVisible(true);
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        btnNuevoInsumo = new javax.swing.JButton();
        btnModificarInsumo = new javax.swing.JButton();
        btnDesactivarInsumo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnActivarInsumo = new javax.swing.JButton();
        rdActivos = new javax.swing.JRadioButton();
        rdBajoMinimo = new javax.swing.JRadioButton();
        rdInactivos = new javax.swing.JRadioButton();

        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Tipo", "Stock", "Minimo", "Estado", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInsumos.setPreferredSize(new java.awt.Dimension(960, 500));
        jScrollPane1.setViewportView(tablaInsumos);

        btnNuevoInsumo.setText("Nuevo Insumo");
        btnNuevoInsumo.setPreferredSize(new java.awt.Dimension(116, 23));
        btnNuevoInsumo.addActionListener(this::btnNuevoInsumoActionPerformed);

        btnModificarInsumo.setText("Modificar Insumo");
        btnModificarInsumo.addActionListener(this::btnModificarInsumoActionPerformed);

        btnDesactivarInsumo.setText("Desactivar Insumo");
        btnDesactivarInsumo.addActionListener(this::btnDesactivarInsumoActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(125, 23));
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnActivarInsumo.setText("Activar Insumo");
        btnActivarInsumo.setPreferredSize(new java.awt.Dimension(122, 23));
        btnActivarInsumo.addActionListener(this::btnActivarInsumoActionPerformed);

        buttonGroup1.add(rdActivos);
        rdActivos.setSelected(true);
        rdActivos.setText("Activos");
        rdActivos.addActionListener(this::rdActivosActionPerformed);

        buttonGroup1.add(rdBajoMinimo);
        rdBajoMinimo.setText("Bajo Stock");
        rdBajoMinimo.addActionListener(this::rdBajoMinimoActionPerformed);

        buttonGroup1.add(rdInactivos);
        rdInactivos.setText("Inactivos");
        rdInactivos.addActionListener(this::rdInactivosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarInsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivarInsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActivarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdActivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdBajoMinimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdInactivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificarInsumo)
                        .addComponent(btnDesactivarInsumo)
                        .addComponent(btnActivarInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdActivos)
                        .addComponent(rdBajoMinimo)
                        .addComponent(rdInactivos))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoInsumoActionPerformed
        CrearInsumoFrame frame = new CrearInsumoFrame(inventario);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        
        frame.setVisible(true);
    }//GEN-LAST:event_btnNuevoInsumoActionPerformed

    private void btnDesactivarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarInsumoActionPerformed
        int fila = tablaInsumos.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un insumo");
            return;
        }
        
        int codigo = Integer.parseInt(tablaInsumos.getValueAt(fila, 0).toString());
        
        Insumo insumo = inventario.buscarInsumoPorCodigo(codigo);
        
        if (insumo == null) {
            JOptionPane.showMessageDialog(this, "Insumo no encontrado");
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea desactivar el insumo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            insumo.setActivo(false);
            cargarTabla();           
        }      
    }//GEN-LAST:event_btnDesactivarInsumoActionPerformed

    private void btnModificarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInsumoActionPerformed
        
        int fila = tablaInsumos.getSelectedRow();
        
        if (fila == -1) {JOptionPane.showMessageDialog(this, "Seleccione un insumo");
        return;
        }
        
        int codigo = Integer.parseInt(tablaInsumos.getValueAt(fila, 0).toString());
        
        Insumo insumo = inventario.buscarInsumoPorCodigo(codigo);
        
        if (insumo == null) {
            JOptionPane.showMessageDialog(this, "Insumo no encontrado");
            return;
        }
        
        if (!insumo.isActivo()) {
            JOptionPane.showMessageDialog(this, "No se puede modificar un empleado inactivo");
            return;
        }
        
        ModificarInsumoFrame frame = new ModificarInsumoFrame(inventario, insumo);
        
        frame.setVisible(true);
        
    }//GEN-LAST:event_btnModificarInsumoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActivarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarInsumoActionPerformed
        int fila = tablaInsumos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un insumo");
            return;
        }

        int codigo = Integer.parseInt(tablaInsumos.getValueAt(fila, 0).toString());

        if (inventario.reactivarInsumo(codigo)) {
            JOptionPane.showMessageDialog(this, "Insumo reactivado correctamente");
            cargarTabla();
        }
    }//GEN-LAST:event_btnActivarInsumoActionPerformed

    private void rdActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdActivosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_rdActivosActionPerformed

    private void rdBajoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBajoMinimoActionPerformed
        cargarTabla();
    }//GEN-LAST:event_rdBajoMinimoActionPerformed

    private void rdInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdInactivosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_rdInactivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarInsumo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDesactivarInsumo;
    private javax.swing.JButton btnModificarInsumo;
    private javax.swing.JButton btnNuevoInsumo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdActivos;
    private javax.swing.JRadioButton rdBajoMinimo;
    private javax.swing.JRadioButton rdInactivos;
    private javax.swing.JTable tablaInsumos;
    // End of variables declaration//GEN-END:variables
}
