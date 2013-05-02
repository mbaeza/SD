package vistas;
import clientermi.conexionRMI;
import clientermi.retardo;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VistaRegister extends javax.swing.JFrame {

    private static VistaRegister propiaVista;
    private conexionRMI conexion = new conexionRMI();
    public String historial="";


    public VistaRegister() {
        try {
            initComponents();
            
            //ocultar hasta que se elija profesor o alumno
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);
            jTextField8.setVisible(false);
            jTextField9.setVisible(false);
            jComboBox2.setVisible(false);
            LabelNombre.setVisible(false);
            LabelNombre1.setVisible(false);
            LabelNombre2.setVisible(false);
            LabelPass.setVisible(false);
            LabelPass1.setVisible(false);
            LabelPass2.setVisible(false);
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            LabelPass4.setVisible(false);
            LabelPass5.setVisible(false);
            jButton1.setVisible(false);
            if(conexion.iniciarRegistry()){
                String cursos = conexion.getServidor().MostrarCursos();
                String[] curso = cursos.split(";");

                //agregar cursos al combobox
                for(int i = 1; i<curso.length ;i++){
                    jComboBox2.addItem(curso[i]);
                }
            }
           // this.LabelAviso.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(VistaRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ButtonCerrar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        LabelPass5 = new javax.swing.JLabel();
        LabelPass4 = new javax.swing.JLabel();
        LabelNombre2 = new javax.swing.JLabel();
        LabelNombre1 = new javax.swing.JLabel();
        LabelPass = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelPass1 = new javax.swing.JLabel();
        LabelPass2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo Cliente RMI");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensaje"));

        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonCerrar.setText("Volver");
        ButtonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrar(evt);
            }
        });
        ButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCerrarActionPerformed(evt);
            }
        });

        LabelPass5.setText("Curso:");

        LabelPass4.setText("Fono:");

        LabelNombre2.setText("Apellido Materno:");

        LabelNombre1.setText("Apellido Paterno:");

        LabelPass.setText("Segundo Nombre:");

        LabelNombre.setText("Primer Nombre:");

        LabelPass1.setText("Contraseña:");

        LabelPass2.setText("Rut:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Profesor", "Alumno" }));

        jLabel1.setText("Seleccione tipo de usuario:");

        jButton2.setText("Elegir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("@");

        jLabel3.setText("Correo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelPass)
                    .addComponent(LabelPass1)
                    .addComponent(LabelPass2)
                    .addComponent(jLabel1)
                    .addComponent(LabelPass5)
                    .addComponent(LabelPass4)
                    .addComponent(LabelNombre1)
                    .addComponent(LabelNombre)
                    .addComponent(LabelNombre2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField1)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4)
                                .addComponent(jTextField5)
                                .addComponent(jTextField6)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                    .addComponent(jButton2)
                                    .addGap(11, 11, 11)))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9))
                            .addComponent(jTextField7)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNombre2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPass4)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPass5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ButtonCerrar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if(conexion.iniciarRegistry()){

                if(jComboBox1.getSelectedIndex()==0){
                    //Menu de registrar al profesor
                    jTextField1.setVisible(true);
                    jTextField2.setVisible(true);
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField6.setVisible(true);
                    jTextField7.setVisible(true);
                    LabelNombre.setVisible(true);
                    LabelNombre1.setVisible(true);
                    LabelPass.setVisible(true);
                    LabelPass1.setVisible(true);
                    LabelPass2.setVisible(true);
                    LabelPass4.setVisible(true);
                    LabelPass5.setVisible(false);
                    jComboBox2.setVisible(false);
                    LabelNombre2.setVisible(true);
                    jLabel3.setVisible(false);
                    jLabel2.setVisible(false);
                    jTextField8.setVisible(false);
                    jTextField9.setVisible(false);
                     jButton1.setVisible(true);

                }else{
                    //Menu de registrar al alumno
                    jTextField1.setVisible(true);
                    jTextField2.setVisible(true);
                    jTextField3.setVisible(true);
                    jTextField4.setVisible(true);
                    jTextField5.setVisible(true);
                    jTextField6.setVisible(true);
                    jTextField7.setVisible(false);
                    LabelNombre.setVisible(true);
                    LabelNombre1.setVisible(true);
                    LabelPass.setVisible(true);
                     jButton1.setVisible(true);
                    LabelPass1.setVisible(true);
                    LabelPass2.setVisible(true);
                    LabelPass4.setVisible(false);
                    jComboBox2.setVisible(true);
                    LabelNombre2.setVisible(true);
                    LabelPass5.setVisible(true);
                    jLabel3.setVisible(true);
                    jLabel2.setVisible(true);
                    jTextField8.setVisible(true);
                    jTextField9.setVisible(true);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(VistaRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCerrarActionPerformed

    private void cerrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar
        this.setVisible(false);

    }//GEN-LAST:event_cerrar

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            int resultado;
            if(conexion.iniciarRegistry()){
                if(jComboBox1.getSelectedIndex()==0){
                    //obtener datos profesor
                    String RUT = this.jTextField2.getText();
                    String PASS = this.jTextField1.getText();
                    String NOMBRE1 = this.jTextField3.getText();
                    String NOMBRE2 = this.jTextField4.getText();
                    String APELLIDO1 = this.jTextField5.getText();
                    String APELLIDO2 = this.jTextField6.getText();
                    String FONO = this.jTextField7.getText();
                    resultado = conexion.RegistrarProfesor(PASS, RUT, NOMBRE1, NOMBRE2, FONO, APELLIDO1);

                    if(resultado == 0){
                        JOptionPane.showMessageDialog(this, "El profesor se encuentra registrado", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Se ha ingreso correctamente el profesor", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        //jComboBox1.setSelectedIndex(-1);
                        this.jTextField2.setText("");
                        this.jTextField1.setText("");
                        this.jTextField3.setText("");
                        this.jTextField4.setText("");
                        this.jTextField5.setText("");
                        this.jTextField6.setText("");
                        this.jTextField7.setText("");
                        this.jTextField8.setText("");
                        this.jTextField9.setText("");
                    }
                }else{
                    //obtener datos alumno
                    String RUT = this.jTextField2.getText();
                    String PASS = this.jTextField1.getText();
                    String NOMBRE1 = this.jTextField3.getText();
                    String NOMBRE2 = this.jTextField4.getText();
                    String APELLIDO1 = this.jTextField5.getText();
                    String APELLIDO2 = this.jTextField6.getText();
                    String CURSO = (String) this.jComboBox2.getSelectedItem();
                    String CORREO = this.jTextField8.getText()+"@"+this.jTextField9.getText();
                    resultado = conexion.RegistrarEstudiante(PASS, RUT,  NOMBRE1, NOMBRE2, CORREO, APELLIDO1, CURSO,  APELLIDO2);

                    if(resultado == 0){
                        JOptionPane.showMessageDialog(this, "El alumno se encuentra registrado", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Se ha ingreso correctamente el alumno", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                       
                        this.dispose();
                      //  jComboBox1.setSelectedIndex(-1);
                        this.jTextField2.setText("");
                        this.jTextField1.setText("");
                        this.jTextField3.setText("");
                        this.jTextField4.setText("");
                        this.jTextField5.setText("");
                        this.jTextField6.setText("");
                        this.jTextField7.setText("");
                        this.jTextField8.setText("");
                        this.jTextField9.setText("");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VistaRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked
    public static VistaRegister getInstanciaVista(){
        if (propiaVista == null){
            propiaVista = new VistaRegister();
        }
        return propiaVista;
    }

    
    public void ocultarLabel(){
      //  this.LabelAviso.setVisible(false);
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCerrar;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNombre1;
    private javax.swing.JLabel LabelNombre2;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelPass1;
    private javax.swing.JLabel LabelPass2;
    private javax.swing.JLabel LabelPass4;
    private javax.swing.JLabel LabelPass5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}
