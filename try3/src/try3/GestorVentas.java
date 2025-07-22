package try3;

import java.util.ArrayList;
import java.util.List;

public class GestorVentas {

    private List<Venta> ventas;

    public GestorVentas() {
        ventas = new ArrayList<>();
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
