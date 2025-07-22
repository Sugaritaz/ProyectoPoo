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

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos.values()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}

