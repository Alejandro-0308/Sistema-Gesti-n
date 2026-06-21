package vista;

/**
 *
 * @author inver
 */
public class DetalleFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DetalleFrame.class.getName());

    public DetalleFrame(String titulo, String contenido) {
        initComponents();
        
        setTitle(titulo);
        
        txtDetalle.setText(contenido);
        txtDetalle.setEditable(false);
        
        setLocationRelativeTo(null);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 530));
        setMinimumSize(new java.awt.Dimension(450, 530));
        setResizable(false);

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        txtDetalle.setMaximumSize(new java.awt.Dimension(430, 500));
        txtDetalle.setMinimumSize(new java.awt.Dimension(430, 500));
        txtDetalle.setPreferredSize(new java.awt.Dimension(430, 500));
        jScrollPane1.setViewportView(txtDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
