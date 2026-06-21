package vista;
import gestion.Inventario;
import javax.swing.JOptionPane;

/**
 *
 * @author inver
 */
public class LoginFrame extends javax.swing.JFrame {
    
    private Inventario inventario;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());
    
    public LoginFrame(Inventario inventario) {
        initComponents();
        this.inventario = inventario;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        legajo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        contrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnPrimerInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        legajo.setText("Legajo");

        titulo.setText("Sistema de Gestión de Inventario");

        txtLegajo.addActionListener(this::txtLegajoActionPerformed);

        contrasena.setText("Contraseña");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        btnPrimerInicio.setText("Primer Inicio");
        btnPrimerInicio.addActionListener(this::btnPrimerInicioActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(legajo)
                            .addComponent(contrasena))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLegajo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimerInicio, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(legajo)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrimerInicio)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLegajoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String textoLegajo = txtLegajo.getText();
        String contrasena = new String(txtContrasena.getPassword());
        if (textoLegajo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Complete todos los campos");
            return;
        } 
        int legajo;
        try {
            legajo = Integer.parseInt(textoLegajo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El legajo debe ser numérico");
            return;
        }
        if (inventario.login(legajo, contrasena)) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + inventario.getEmpleadoLogueado().getNombre() + " " + inventario.getEmpleadoLogueado().getApellido());
            PrincipalFrame principal = new PrincipalFrame(inventario);
            principal.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Legajo o contraseña incorrectos");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnPrimerInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimerInicioActionPerformed
        String clave = JOptionPane.showInputDialog(this,"Ingrese la contraseña que se le proporciono con su licencia:");
        if (clave != null && clave.equals("8833")) {
            JOptionPane.showMessageDialog(this,"Acceso concedido");
            CrearAdministradorFrame crearAdmin = new CrearAdministradorFrame(inventario);
            crearAdmin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,"Contraseña incorrecta");
        }
    }//GEN-LAST:event_btnPrimerInicioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnPrimerInicio;
    private javax.swing.JLabel contrasena;
    private javax.swing.JLabel legajo;
    private javax.swing.JLabel titulo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtLegajo;
    // End of variables declaration//GEN-END:variables
}
