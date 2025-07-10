package try3;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes;

    public GestorClientes() {
        clientes = new ArrayList<>();
    }

    public void registrarCliente(String nombre, String correo, String telefono) {
        Cliente nuevoCliente = new Cliente(nombre, correo, telefono);
        clientes.add(nuevoCliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
