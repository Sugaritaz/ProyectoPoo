package try3;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import try3.FormVerProductos;

public class FormularioPrincipal extends javax.swing.JFrame {
    FormVerVentas ventanaVerVentas;
    GestorVentas gestorVentas = new GestorVentas();
    private Inventario inventario;
    FormRealizarVenta ventanaVenta;
    FormRegistrarCliente ventanaCliente;
    FormRegistrarProducto ventanaProducto;
    FormVerProductos ventanaVerProductos;
    FormVerClientes ventanaVerClientes;

    public FormularioPrincipal() {
        
        inventario = new Inventario();
        inventario.setProductos(DataManager.loadProductosFromXML("productos.xml"));
 GestorClientes gestor = new GestorClientes();
 ventanaVerClientes = new FormVerClientes(gestor);

        // Creación de las ventanas con el inventario
       ventanaVenta = new FormRealizarVenta(inventario, gestor);
        ventanaCliente = new FormRegistrarCliente(gestor, ventanaVenta);
        ventanaProducto = new FormRegistrarProducto(inventario);
        ventanaVerProductos = new FormVerProductos(inventario);
        ventanaVerVentas = new FormVerVentas(gestorVentas);

        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void closeVentanas() {
        ventanaVenta.setVisible(false);
        ventanaCliente.setVisible(false);
        ventanaProducto.setVisible(false);
        ventanaVerProductos.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnRealizarVenta = new javax.swing.JButton();
        btnVerProducto = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegistrarProducto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btnVerCliente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jdpPrincipal = new javax.swing.JDesktopPane();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRealizarVenta.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 30));

        btnVerProducto.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnVerProducto.setText("Ver Producto");
        btnVerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 30));

        btnRegistrarCliente.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 30));

        btnRegistrarProducto.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnRegistrarProducto.setText("Registrar Producto");
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 30));

        btnSalir.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 130, 30));

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 370, 378));

        btnVerCliente.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnVerCliente.setText("Ver Cliente");
        btnVerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 30));

        jButton2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        jButton2.setText("Ver Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, 30));

        jdpPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdpPrincipal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
       closeVentanas();
    ventanaVenta.actualizarComboProductos();

    if (ventanaVenta.getParent() == null) {
        jdpPrincipal.add(ventanaVenta, new AbsoluteConstraints(0, 0, ventanaVenta.getWidth(), ventanaVenta.getHeight()));
    }

    ventanaVenta.setVisible(true);
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
      closeVentanas();
        if (ventanaCliente.getParent() == null) {
            jdpPrincipal.add(ventanaCliente, new AbsoluteConstraints(0, 0, ventanaCliente.getWidth(), ventanaCliente.getHeight()));
        }
        ventanaCliente.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
      closeVentanas();
        if (ventanaProducto.getParent() == null) {
            jdpPrincipal.add(ventanaProducto, new AbsoluteConstraints(0, 0, ventanaProducto.getWidth(), ventanaProducto.getHeight()));
        }
        ventanaProducto.setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void btnVerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductoActionPerformed
          closeVentanas();
    ventanaVerProductos = new FormVerProductos(inventario);

    jdpPrincipal.add(ventanaVerProductos, new AbsoluteConstraints(0, 0, ventanaVerProductos.getWidth(), ventanaVerProductos.getHeight()));
    ventanaVerProductos.setVisible(true);

    }//GEN-LAST:event_btnVerProductoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClienteActionPerformed
 closeVentanas();

    // Por si quieres ver siempre la versión actualizada:
    ventanaVerClientes = new FormVerClientes(ventanaCliente.gestorClientes); 

    jdpPrincipal.add(ventanaVerClientes, new AbsoluteConstraints(
        0, 0,
        ventanaVerClientes.getWidth(),
        ventanaVerClientes.getHeight()
    ));
    ventanaVerClientes.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeVentanas();
    ventanaVerVentas.actualizarTabla(); // actualiza datos si ya existía

    if (ventanaVerVentas.getParent() == null) {
        jdpPrincipal.add(ventanaVerVentas, new AbsoluteConstraints(
            0, 0,
            ventanaVerVentas.getWidth(),
            ventanaVerVentas.getHeight()
        ));
    }

    ventanaVerVentas.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
                                   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarProducto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerCliente;
    private javax.swing.JButton btnVerProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane jdpPrincipal;
    // End of variables declaration//GEN-END:variables
}
