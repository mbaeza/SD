package vistas;
import clientermi.conexionRMI;
import clientermi.retardo;
import clientermi.retardoRegistrar;
import java.rmi.RemoteException;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Registrar extends javax.swing.JFrame {
    private static Registrar propiaVista;
    private conexionRMI conexion = new conexionRMI();
   

    public static Registrar getInstanciaVista(){
        if (propiaVista == null){
            propiaVista = new Registrar();
        }
        return propiaVista;
    }
    public Registrar() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelNombre = new javax.swing.JLabel();
        TextFieldNombre = new javax.swing.JTextField();
        LabelPass = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        LabelNombre1 = new javax.swing.JLabel();
        LabelPass1 = new javax.swing.JLabel();
        LabelNombre2 = new javax.swing.JLabel();
        LabelPass2 = new javax.swing.JLabel();
        LabelPass3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        LabelPass4 = new javax.swing.JLabel();
        LabelPass5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo Cliente RMI");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio de Sesión"));

        LabelNombre.setText("Primer Nombre:");

        TextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNombreActionPerformed(evt);
            }
        });

        LabelPass.setText("Segundo Nombre:");

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        LabelNombre1.setText("Apellido Paterno:");

        LabelPass1.setText("Contraseña:");

        LabelNombre2.setText("Apellido Materno:");

        LabelPass2.setText("Rut:");

        LabelPass3.setText("Correo electrónico:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Profesor", "Alumno" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        LabelPass4.setText("Fono:");

        LabelPass5.setText("Curso:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LabelPass1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPass2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(LabelPass4)
                                        .addGap(81, 81, 81)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LabelPass5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 31, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(LabelNombre)
                                                .addGap(31, 31, 31))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(LabelNombre1)
                                                    .addComponent(LabelPass)
                                                    .addComponent(LabelNombre2))
                                                .addGap(18, 18, 18)))
                                        .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LabelPass3)
                                        .addGap(183, 183, 183)))))
                        .addGap(127, 127, 127)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LabelPass2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPass1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNombre)
                    .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LabelNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelNombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelPass3))
                    .addComponent(LabelPass))
                .addGap(11, 11, 11)
                .addComponent(LabelPass4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPass5)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String Nombre1 = this.TextFieldNombre.getText();
        /*    String Rut = this.TextFieldRut.getText();
            String Nombre2 = this.TextFieldNombreSeg.getText();
            String Apellido1 = this.TextFieldApellidoPrim.getText();
            String Apellido2 = this.TextFieldApellidoSeg.getText();
            String Correo = this.TextFieldCorreo.getText();
            String Contraseña = this.TextFieldContrasena.getText();
            String Fono = this.TextFieldFono.getText();*/
        //    int tipo = this.jComboBox1.gets
           // String Curso = this.TextFieldFono1.getText();

            conexion.registrarCliente(Nombre1);
         //   if(tipo == 0){

                //conexion.RegistrarProfesor(Contraseña, Rut, Nombre1, Nombre2, Fono, Apellido1);

                //vistaSecundaria.getInstanciaVista().setVisible(true);

           // }else if (tipo == 1){
                /*   try {
                    conexion.RegistrarEstudiante(Contraseña, Rut, Nombre1, Nombre2, Fono, Apellido1, Curso, Apellido2);
                } catch (RemoteException ex) {
                    Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
                }*/
           // }
        } catch (RemoteException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        vistaPrincipal.getInstanciaVista().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNombreActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNombre1;
    private javax.swing.JLabel LabelNombre2;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelPass1;
    private javax.swing.JLabel LabelPass2;
    private javax.swing.JLabel LabelPass3;
    private javax.swing.JLabel LabelPass4;
    private javax.swing.JLabel LabelPass5;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
