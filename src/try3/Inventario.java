package try3;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Integer, Producto> productos = new HashMap<>();

    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(Map<Integer, Producto> productos) {
        this.productos = productos;
    }
    private GestorClientes gestorClientes = new GestorClientes();

public GestorClientes getGestorClientes() {
    return gestorClientes;
}

public void setGestorClientes(GestorClientes gestorClientes) {
    this.gestorClientes = gestorClientes;
}
public Producto buscarProducto(String nombre) {
    for (Producto p : productos.values()) {
        if (p.getNombre().equalsIgnoreCase(nombre)) {
            return p;
        }
    }
    return null;
}

}
