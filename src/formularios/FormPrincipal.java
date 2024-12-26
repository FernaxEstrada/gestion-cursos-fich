package formularios;

public class FormPrincipal extends javax.swing.JFrame {

    public static FormUsuario FormUsuario = new FormUsuario();
    public static FormCategoria FormCategoria = new FormCategoria();
    public static FormPersona FormPersona = new FormPersona();
    public static FormCapacitadorEspecialidad FormCapacitadorEspecialidad = new FormCapacitadorEspecialidad();
    public static FormEspecialidad FormEspecialidad = new FormEspecialidad();
    public static FormUbicacion FormUbicacion = new FormUbicacion();
    public static FormCarrera FormCarrera = new FormCarrera();
    public static FormDia FormDia = new FormDia();
    public static FormCurso FormCurso = new FormCurso();
    public static FormCursoDia FormCursoDia = new FormCursoDia();
    public static FormCursoCapacitador FormCursoCapacitador = new FormCursoCapacitador();
    public static FormCursoCarrera FormCursoCarrera = new FormCursoCarrera();
    public static FormInscripcion FormInscripcion = new FormInscripcion();
    
    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitutlo = new javax.swing.JLabel();
        jButtonDia = new javax.swing.JButton();
        jButtonPersona = new javax.swing.JButton();
        jButtonCategoria = new javax.swing.JButton();
        lblCIUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jButtonCapaEspe = new javax.swing.JButton();
        jButtonEspecialidad = new javax.swing.JButton();
        jButtonUbicacion = new javax.swing.JButton();
        jButtonCarrera = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonCursoCarrera = new javax.swing.JButton();
        jButtonCursoDia = new javax.swing.JButton();
        jButtonCursoCapa = new javax.swing.JButton();
        jButtonInscripcion = new javax.swing.JButton();
        jButtonCurso = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitutlo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitutlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitutlo.setText("SISTEMA DE GESTION DE CURSOS FICH");

        jButtonDia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonDia.setText("Gestionar Dia");
        jButtonDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiaActionPerformed(evt);
            }
        });

        jButtonPersona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonPersona.setText("Gestionar Persona");
        jButtonPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonaActionPerformed(evt);
            }
        });

        jButtonCategoria.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCategoria.setText("Gestionar Categoria");
        jButtonCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriaActionPerformed(evt);
            }
        });

        lblCIUsuario.setText("83534");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");

        lblNombreUsuario.setText("Gerardo Perez");

        jButtonCapaEspe.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCapaEspe.setText("Gestionar CapacitadorEspecialidad");
        jButtonCapaEspe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapaEspeActionPerformed(evt);
            }
        });

        jButtonEspecialidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonEspecialidad.setText("Gestionar Especialidad");
        jButtonEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecialidadActionPerformed(evt);
            }
        });

        jButtonUbicacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonUbicacion.setText("Gestionar Ubicacion");
        jButtonUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUbicacionActionPerformed(evt);
            }
        });

        jButtonCarrera.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCarrera.setText("Gestionar Carrera");
        jButtonCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarreraActionPerformed(evt);
            }
        });

        jButtonUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonUsuario.setText("Gestionar Usuario");
        jButtonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarioActionPerformed(evt);
            }
        });

        jButtonCursoCarrera.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCursoCarrera.setText("Gestionar CursoCarrera");
        jButtonCursoCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCursoCarreraActionPerformed(evt);
            }
        });

        jButtonCursoDia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCursoDia.setText("Gestionar CursoDia");
        jButtonCursoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCursoDiaActionPerformed(evt);
            }
        });

        jButtonCursoCapa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCursoCapa.setText("Gestionar CursoCapacitador");
        jButtonCursoCapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCursoCapaActionPerformed(evt);
            }
        });

        jButtonInscripcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonInscripcion.setText("Gestionar Inscripcion");
        jButtonInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscripcionActionPerformed(evt);
            }
        });

        jButtonCurso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonCurso.setText("Gestionar Curso");
        jButtonCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCursoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCapaEspe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCursoDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCIUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCursoCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCursoCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jButtonCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                            .addComponent(jButtonInscripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCapaEspe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCursoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCursoCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCursoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(lblCIUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreUsuario)
                            .addComponent(jLabel4))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaActionPerformed
        FormCategoria.setVisible(true);
    }//GEN-LAST:event_jButtonCategoriaActionPerformed

    private void jButtonPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonaActionPerformed
        FormPersona.setVisible(true);
    }//GEN-LAST:event_jButtonPersonaActionPerformed

    private void jButtonCapaEspeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapaEspeActionPerformed
        FormCapacitadorEspecialidad.setVisible(true);
    }//GEN-LAST:event_jButtonCapaEspeActionPerformed

    private void jButtonEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecialidadActionPerformed
        FormEspecialidad.setVisible(true);
    }//GEN-LAST:event_jButtonEspecialidadActionPerformed

    private void jButtonUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUbicacionActionPerformed
        FormUbicacion.setVisible(true);
    }//GEN-LAST:event_jButtonUbicacionActionPerformed

    private void jButtonCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarreraActionPerformed
        FormCarrera.setVisible(true);
    }//GEN-LAST:event_jButtonCarreraActionPerformed

    private void jButtonDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiaActionPerformed
        FormDia.setVisible(true);
    }//GEN-LAST:event_jButtonDiaActionPerformed

    private void jButtonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarioActionPerformed
        // TODO add your handling code here:
        FormUsuario.setVisible(true);
    }//GEN-LAST:event_jButtonUsuarioActionPerformed

    private void jButtonCursoCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCursoCarreraActionPerformed
        FormCursoCarrera.setVisible(true);
    }//GEN-LAST:event_jButtonCursoCarreraActionPerformed

    private void jButtonCursoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCursoDiaActionPerformed
        FormCursoDia.setVisible(true);
    }//GEN-LAST:event_jButtonCursoDiaActionPerformed

    private void jButtonCursoCapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCursoCapaActionPerformed
        FormCursoCapacitador.setVisible(true);
    }//GEN-LAST:event_jButtonCursoCapaActionPerformed

    private void jButtonInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscripcionActionPerformed
        FormInscripcion.setVisible(true);
    }//GEN-LAST:event_jButtonInscripcionActionPerformed

    private void jButtonCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCursoActionPerformed
        FormCurso.setVisible(true);
    }//GEN-LAST:event_jButtonCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCapaEspe;
    private javax.swing.JButton jButtonCarrera;
    private javax.swing.JButton jButtonCategoria;
    private javax.swing.JButton jButtonCurso;
    private javax.swing.JButton jButtonCursoCapa;
    private javax.swing.JButton jButtonCursoCarrera;
    private javax.swing.JButton jButtonCursoDia;
    private javax.swing.JButton jButtonDia;
    private javax.swing.JButton jButtonEspecialidad;
    private javax.swing.JButton jButtonInscripcion;
    private javax.swing.JButton jButtonPersona;
    private javax.swing.JButton jButtonUbicacion;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitutlo;
    public static javax.swing.JLabel lblCIUsuario;
    public static javax.swing.JLabel lblNombreUsuario;
    // End of variables declaration//GEN-END:variables
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormPrincipal().setVisible(true);
//            }
//        });
//    }
}
