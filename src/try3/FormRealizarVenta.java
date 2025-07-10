package try3;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FormRealizarVenta extends javax.swing.JInternalFrame {

    private Inventario inventario;
    private GestorClientes gestorClientes;
    private GestorVentas gestorVentas;

    public FormRealizarVenta(Inventario inventario, GestorClientes gestorClientes, GestorVentas gestorVentas) {
        this.inventario = inventario;
        this.gestorClientes = gestorClientes;
        this.gestorVentas = gestorVentas;

        initComponents();
        cargarProductos();
        cargarClientes();

        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        btnVentaRealizada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });
    }

    public void actualizarComboClientes() {
        jcbCliente.removeAllItems();
        for (Cliente c : gestorClientes.getClientes()) {
            jcbCliente.addItem(c.getNombre());
        }
    }

    public void actualizarComboProductos() {
        jcbProducto.removeAllItems();
        for (Producto p : inventario.getProductos().values()) {
            jcbProducto.addItem(p.getNombre());
        }
    }

    private void cargarProductos() {
        jcbProducto.removeAllItems();
        for (Producto p : inventario.getProductos().values()) {
            jcbProducto.addItem(p.getNombre());
        }
    }

    private void cargarClientes() {
        jcbCliente.removeAllItems();
        for (Cliente c : gestorClientes.getClientes()) {
            jcbCliente.addItem(c.getNombre());
        }
    }

    private void realizarVenta() {
        String productoNombre = (String) jcbProducto.getSelectedItem();
        String clienteNombre = (String) jcbCliente.getSelectedItem();
        String cantidadTexto = txtCantidad.getText().trim();
        String vendedorNombre = txtVendedor.getText().trim();

        if (productoNombre == null || clienteNombre == null || cantidadTexto.isEmpty() || vendedorNombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            Producto producto = inventario.buscarProducto(productoNombre);

            if (producto == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
                return;
            }

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0.");
                return;
            }

            if (producto.getStock() < cantidad) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente. Disponible: " + producto.getStock());
            } else {
                producto.setStock(producto.getStock() - cantidad);

               Cliente cliente = gestorClientes.buscarCliente(clienteNombre);
Vendedor vendedor = new Vendedor(vendedorNombre);

ItemVenta item = new ItemVenta(producto, cantidad);
ArrayList<ItemVenta> listaItems = new ArrayList<>();
listaItems.add(item);

Venta nuevaVenta = new Venta(0, new Date(), cliente, vendedor, listaItems);
gestorVentas.registrarVenta(nuevaVenta);

                JOptionPane.showMessageDialog(this, "Venta realizada a " + clienteNombre + ".\nNuevo stock: " + producto.getStock());
                txtCantidad.setText("");
                txtVendedor.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jcbProducto = new javax.swing.JComboBox<>();
        jcbCliente = new javax.swing.JComboBox<>();
        btnVentaRealizada = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(197, 224, 250));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Producto");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 59, -1, -1));

        jLabel2.setText("Cantidad:");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 120, -1, -1));

        jLabel3.setText("Vendedor:");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 172, -1, -1));

        jLabel4.setText("Cliente:");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));
        panel.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 90, -1));
        panel.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 90, -1));

        jcbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel.add(jcbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 56, 90, -1));

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel.add(jcbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 230, 90, -1));

        btnVentaRealizada.setText("Realizar Venta");
        btnVentaRealizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaRealizadaActionPerformed(evt);
            }
        });
        panel.add(btnVentaRealizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentaRealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaRealizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentaRealizadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVentaRealizada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbProducto;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
