package vista;

import gestion.Inventario;
import modelo.insumos.Insumo;
import modelo.insumos.InsumoAdministrativo;
import modelo.insumos.InsumoLimpieza;
import modelo.insumos.InsumoMedico;
import java.text.SimpleDateFormat;
import enums.TiposAdministrativos;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.proveedores.Proveedor;

/**
 *
 * @author inver
 */
public class ModificarInsumoFrame extends javax.swing.JFrame {
    
    private Inventario inventario;
    private Insumo insumo;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModificarInsumoFrame.class.getName());   
    
    public ModificarInsumoFrame(Inventario inventario, Insumo insumo) {
        initComponents();
        
        this.inventario = inventario;
        this.insumo = insumo;
        
        cargarProveedores();
        cargarCategorias();
        cargarDatos();
        
        setLocationRelativeTo(null);
        
        
    }

    private void cargarDatos() {
        txtNombre.setText(insumo.getNombre());
        
        txtDescripcion.setText(insumo.getDescripcion());
        
        txtStockMinimo.setText(String.valueOf(insumo.getStockMinimo()));
        
        cmbProveedor.setSelectedItem(insumo.getProveedor().getEmpresa());
        
        if (insumo instanceof InsumoAdministrativo administrativo) {
            cmbCategoria.setSelectedItem(administrativo.getCategoria().name());
        }
        
        if (insumo instanceof InsumoMedico medico) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaVencimiento.setText(sdf.format(medico.getFechaVencimiento()));
            chkRequiereFrio.setSelected(medico.isRequiereFrio());
        }
        
        if (insumo instanceof InsumoLimpieza limpieza) {
            chkQuimico.setSelected(limpieza.isQuimico());
        }
    }
    
        private void cargarProveedores() {
            cmbProveedor.removeAllItems();
            for (Proveedor proveedor : inventario.listarProveedoresActivos()) {
                cmbProveedor.addItem(proveedor.getEmpresa());
            }
        }
        
        private void cargarCategorias() {
            cmbCategoria.removeAllItems();
            for (TiposAdministrativos tipo : TiposAdministrativos.values()) {
                cmbCategoria.addItem(tipo.name());
            }
        } 
    


    @SuppressWarnings("unchecked")
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModificarInsumo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblStockMinimo = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        lblProveedor = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chkRequiereFrio = new javax.swing.JCheckBox();
        chkQuimico = new javax.swing.JCheckBox();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFechaVencimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblModificarInsumo.setText("Modificar Insumo");

        lblNombre.setText("Nombre");

        lblDescripcion.setText("Descripcion");

        lblStockMinimo.setText("Stock Minimo");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.setMaximumSize(new java.awt.Dimension(100, 23));
        cmbProveedor.setMinimumSize(new java.awt.Dimension(100, 23));
        cmbProveedor.setPreferredSize(new java.awt.Dimension(100, 23));

        lblProveedor.setText("Proveedor");

        txtNombre.setMaximumSize(new java.awt.Dimension(100, 23));
        txtNombre.setMinimumSize(new java.awt.Dimension(100, 23));
        txtNombre.setPreferredSize(new java.awt.Dimension(100, 23));

        txtDescripcion.setMaximumSize(new java.awt.Dimension(100, 23));
        txtDescripcion.setMinimumSize(new java.awt.Dimension(100, 23));
        txtDescripcion.setPreferredSize(new java.awt.Dimension(100, 23));

        txtStockMinimo.setMaximumSize(new java.awt.Dimension(100, 23));
        txtStockMinimo.setMinimumSize(new java.awt.Dimension(100, 23));
        txtStockMinimo.setPreferredSize(new java.awt.Dimension(100, 23));

        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnGuardar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnGuardar.setPreferredSize(new java.awt.Dimension(100, 23));
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setMinimumSize(new java.awt.Dimension(100, 23));
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 23));

        chkRequiereFrio.setText("Requiere Frio");

        chkQuimico.setText("Quimico");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.setMaximumSize(new java.awt.Dimension(100, 23));
        cmbCategoria.setMinimumSize(new java.awt.Dimension(100, 23));
        cmbCategoria.setPreferredSize(new java.awt.Dimension(100, 23));

        lblCategoria.setText("Categoria");

        jLabel1.setText("Fecha de Vencimiento");

        txtFechaVencimiento.setMaximumSize(new java.awt.Dimension(100, 23));
        txtFechaVencimiento.setMinimumSize(new java.awt.Dimension(100, 23));
        txtFechaVencimiento.setPreferredSize(new java.awt.Dimension(100, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblDescripcion)
                            .addComponent(lblStockMinimo)
                            .addComponent(lblProveedor)
                            .addComponent(jLabel1)
                            .addComponent(lblCategoria)
                            .addComponent(chkRequiereFrio))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStockMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkQuimico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModificarInsumo))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModificarInsumo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockMinimo)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRequiereFrio)
                    .addComponent(chkQuimico))
                .addGap(27, 27, 27)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        insumo.setNombre(txtNombre.getText());
        insumo.setDescripcion(txtDescripcion.getText());
        
        try {
            insumo.setStockMinimo(Integer.parseInt(txtStockMinimo.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stock minimo invalido");
            return;
        }
        
        String nombreProveedor = cmbProveedor.getSelectedItem().toString();
        
        Proveedor proveedor = inventario.buscarProveedorPorNombre(nombreProveedor);
        
        if (proveedor != null) {
            insumo.setProveedor(proveedor);
        }
        
        if (insumo instanceof InsumoAdministrativo administrativo) {
            TiposAdministrativos categoria = TiposAdministrativos.valueOf(cmbCategoria.getSelectedItem().toString());
            administrativo.setCategoria(categoria);
        }
        
        
        if (insumo instanceof InsumoMedico medico) {
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVencimiento.getText());
                medico.setFechaVencimiento(fecha);
                medico.setRequiereFrio(chkRequiereFrio.isSelected());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Fecha Invalida");
                return;
            }
        }
        
        if (insumo instanceof InsumoLimpieza limpieza) {
            limpieza.setQuimico(chkQuimico.isSelected()); 
        }
        
        JOptionPane.showMessageDialog(this, "Insumo modificado correctamente");
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkQuimico;
    private javax.swing.JCheckBox chkRequiereFrio;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblModificarInsumo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblStockMinimo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStockMinimo;
    // End of variables declaration//GEN-END:variables
}

