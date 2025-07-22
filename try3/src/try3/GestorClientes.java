package try3;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes;

    public GestorClientes() {
        clientes = new ArrayList<>();
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void registrarCliente(String nombre, String correo, String telefono) {
        // Evita registrar duplicados por nombre
        if (buscarCliente(nombre) == null) {
            Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
            clientes.add(nuevoCliente);
        } else {
            System.out.println("Cliente ya registrado: " + nombre);
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
