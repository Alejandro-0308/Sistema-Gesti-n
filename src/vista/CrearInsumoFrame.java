package vista;

import gestion.Inventario;
import modelo.insumos.Insumo;
import modelo.insumos.InsumoAdministrativo;
import modelo.insumos.InsumoLimpieza;
import modelo.insumos.InsumoMedico;
import modelo.proveedores.Proveedor;
import enums.TiposAdministrativos;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.movimientos.Movimiento;
import enums.TipoMovimiento;


/**
 *
 * @author inver
 */
public class CrearInsumoFrame extends javax.swing.JFrame {

    private Inventario inventario;
    
        
    public CrearInsumoFrame(Inventario inventario) {
        
        initComponents();
        
        this.inventario = inventario;
                
        cargarProveedores();
        cargarTipos();
        cargarCategorias();
        
        setLocationRelativeTo(null);
    }
    
    private void actualizarCampos() {
        if (cmbTipo.getSelectedItem() == null) {
            return;
        }
        
        String tipo = cmbTipo.getSelectedItem().toString();
        
        boolean administrativo = tipo.equals("Administrativo");
        boolean medico = tipo.equals("Médico");
        boolean limpieza = tipo.equals("Limpieza");
        
        lblCategoria.setEnabled(administrativo);
        cmbCategoria.setEnabled(administrativo);
        
        lblFechaVencimiento.setEnabled(medico);
        txtFechaVencimiento.setEnabled(medico);
        chkRequiereFrio.setEnabled(medico);
        
        chkQuimico.setEnabled(limpieza);
        
        revalidate();
        repaint();
    }
    
    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarCampos();
        txtFechaVencimiento.setText("");
        chkRequiereFrio.setSelected(false);
        chkQuimico.setSelected(false);
    }
    
    private void cargarTipos() {
        cmbTipo.removeAllItems();
        
        cmbTipo.addItem("Administrativo");
        cmbTipo.addItem("Médico");
        cmbTipo.addItem("Limpieza");
        
        cmbTipo.addActionListener(this::cmbTipoActionPerformed);
        actualizarCampos();
        
    }
    
    private void cargarProveedores() {

        cmbProveedor.removeAllItems();

        for (Proveedor proveedor : inventario.listarProveedoresActivos()) {
            cmbProveedor.addItem(proveedor.getEmpresa());
        }
        
        if (cmbProveedor.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debe crear al menos un proveedor antes de crear insumos");
            btnCrear.setEnabled(false);
        } else {
            btnCrear.setEnabled(true);
        }  
    }
    
    private void cargarCategorias() {
        cmbCategoria.removeAllItems();
        for (TiposAdministrativos tipo: TiposAdministrativos.values()) {
            cmbCategoria.addItem(tipo.name());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblStockMinimo = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        cmbProveedor = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        lblCrearInsumo = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtFechaVencimiento = new javax.swing.JTextField();
        lblFechaVencimiento = new javax.swing.JLabel();
        chkRequiereFrio = new javax.swing.JCheckBox();
        chkQuimico = new javax.swing.JCheckBox();
        lblStockInicial = new javax.swing.JLabel();
        txtStockInicial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNombre.setText("Nombre");

        lblDescripcion.setText("Descripción");

        lblStockMinimo.setText("Stock Mínimo");

        lblProveedor.setText("Proveedor");

        lblTipo.setText("Tipo");

        txtNombre.setPreferredSize(new java.awt.Dimension(116, 22));

        txtDescripcion.setPreferredSize(new java.awt.Dimension(116, 22));

        txtStockMinimo.setPreferredSize(new java.awt.Dimension(116, 22));
        txtStockMinimo.addActionListener(this::txtStockMinimoActionPerformed);

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.setPreferredSize(new java.awt.Dimension(116, 22));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipo.setPreferredSize(new java.awt.Dimension(116, 22));

        lblCrearInsumo.setText("Crear Insumo");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(92, 23));
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblCategoria.setText("Categoria");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.setPreferredSize(new java.awt.Dimension(116, 22));

        txtFechaVencimiento.setPreferredSize(new java.awt.Dimension(116, 22));

        lblFechaVencimiento.setText("Fecha de vencimiento");

        chkRequiereFrio.setText("Requiere Frio");
        chkRequiereFrio.addActionListener(this::chkRequiereFrioActionPerformed);

        chkQuimico.setText("Quimico");

        lblStockInicial.setText("Stock Inicial");

        txtStockInicial.setPreferredSize(new java.awt.Dimension(116, 22));
        txtStockInicial.addActionListener(this::txtStockInicialActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(chkQuimico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chkRequiereFrio))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(lblNombre)
                                .addComponent(lblStockMinimo)
                                .addComponent(lblProveedor)
                                .addComponent(lblTipo)
                                .addComponent(lblCategoria)
                                .addComponent(lblFechaVencimiento)
                                .addComponent(lblDescripcion)
                                .addComponent(lblStockInicial))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStockInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStockMinimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnCrear)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblCrearInsumo)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblCrearInsumo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockInicial)
                    .addComponent(txtStockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRequiereFrio)
                    .addComponent(chkQuimico))
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinimoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = txtNombre.getText();
        String descripcion = txtDescripcion.getText();
        int stockMinimo;

        try {
            stockMinimo = Integer.parseInt(txtStockMinimo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stock mínimo inválido");
            return;
        }

        Object proveedorSeleccionado = cmbProveedor.getSelectedItem();
        
        if (proveedorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe crear o seleccionar un proveedor");
            return;
        }
        
        int stockInicial = 0;
        
        if (!txtStockInicial.getText().isBlank()) {
            try {
                stockInicial = Integer.parseInt(txtStockInicial.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Stock inicial invalido");
                return;
            }
        }
        
        if (stockInicial < 0) {
            JOptionPane.showMessageDialog(this, "El stock inicial no puede ser negativo");
            return;
        }
        
        
        String nombreProveedor = proveedorSeleccionado.toString();

        Proveedor proveedor = inventario.buscarProveedorPorNombre(nombreProveedor);
        
        if (proveedor == null) {
            JOptionPane.showMessageDialog(this, "Proveedor invalido");
            return;
        }
        
        String tipo = cmbTipo.getSelectedItem().toString();

        Insumo insumo = null;

        if (tipo.equals("Administrativo")) {

            TiposAdministrativos categoria = TiposAdministrativos.valueOf(cmbCategoria.getSelectedItem().toString());

            insumo = new InsumoAdministrativo(inventario.generarCodigoInsumo(), nombre, descripcion, stockInicial, stockMinimo, proveedor, categoria);
        } else if (tipo.equals("Limpieza")) {
            insumo = new InsumoLimpieza(inventario.generarCodigoInsumo(),nombre, descripcion, stockInicial, stockMinimo, proveedor, chkQuimico.isSelected());
        } else if (tipo.equals("Médico")) {
            try {
                if (tipo.equals("Médico") && txtFechaVencimiento.getText().isBlank()) {
                    JOptionPane.showMessageDialog(this, "Ingrese una fecha de vencimiento");
                    return;
                }
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVencimiento.getText());

                insumo = new InsumoMedico(inventario.generarCodigoInsumo(), nombre, descripcion, stockInicial, stockMinimo, proveedor, fecha, chkRequiereFrio.isSelected());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Fecha Invalida. Formato: DD/MM/AAAA");
                return;
            }
        }
        if(nombre.isBlank() || descripcion.isBlank()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        inventario.agregarInsumo(insumo);
        
        if (stockInicial > 0) {
            
            Movimiento movimiento = new Movimiento(inventario.generarIdMovimiento(), new Date(), TipoMovimiento.ENTRADA, stockInicial, "Creacion de insumo - Stock inicial", insumo, inventario.getEmpleadoLogueado());
            inventario.agregarMovimiento(movimiento);
        }

        JOptionPane.showMessageDialog(this, "Insumo Creado Correctamente");
        dispose();

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkRequiereFrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRequiereFrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRequiereFrioActionPerformed

    private void txtStockInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockInicialActionPerformed
        
    }//GEN-LAST:event_txtStockInicialActionPerformed
                                                                              

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JCheckBox chkQuimico;
    private javax.swing.JCheckBox chkRequiereFrio;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCrearInsumo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblStockInicial;
    private javax.swing.JLabel lblStockMinimo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStockInicial;
    private javax.swing.JTextField txtStockMinimo;
    // End of variables declaration//GEN-END:variables

}