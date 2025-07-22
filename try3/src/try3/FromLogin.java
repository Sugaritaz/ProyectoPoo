/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package try3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

/**
 *
 * @author stephano quevedo
 */
public class FromLogin extends JFrame {
    
     private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;
    private HashMap<String, String> usuarios;
    
    public FromLogin() {
    
    setTitle("Inicio de Sesión");
        setSize(380, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));

        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setBounds(130, 10, 200, 30);
        lblTitulo.setForeground(new Color(33, 37, 41));
        add(lblTitulo);

        // Etiqueta usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsuario.setBounds(40, 60, 80, 25);
        add(lblUsuario);

        // Campo usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 60, 200, 30);
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setBorder((Border) new RoundedBorder(8));
        add(txtUsuario);

        // Etiqueta contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPassword.setBounds(40, 100, 80, 25);
        add(lblPassword);

        // Campo contraseña
        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 100, 200, 30);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder((Border) new RoundedBorder(8));
        add(txtPassword);

        // Botón ingresar
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(0, 123, 255));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBounds(120, 150, 200, 35);
        btnIngresar.setBorder((Border) new RoundedBorder(10));
        btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect
        btnIngresar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnIngresar.setBackground(new Color(0, 105, 217));
            }

            public void mouseExited(MouseEvent e) {
                btnIngresar.setBackground(new Color(0, 123, 255));
            }
        });

        add(btnIngresar);

        // Usuarios permitidos
        usuarios = new HashMap<>();
        usuarios.put("admin", "1234");
        usuarios.put("Stephano Morningstar", "2775");

        btnIngresar.addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(password)) {
            FormularioPrincipal principal = new FormularioPrincipal();
            principal.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase para bordes redondeados
    private class RoundedBorder extends AbstractBorder {
        private final int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(new Color(200, 200, 200));
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = radius;
            return insets;
        }
    }  
    
    
}
