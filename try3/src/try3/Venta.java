
package try3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ULTRABOOK
 */
public class Venta { 
    private int idVenta;
    private Date fecha;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemVenta> items;

    public Venta(int idVenta, Date fecha, Cliente cliente, Vendedor vendedor, ArrayList<ItemVenta> items) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.items = items;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<ItemVenta> getItems() {
        return items;
    }

public void setItems(List<ItemVenta> items) {
    this.items = new ArrayList<>(items); // si necesitas copiar
}

  



}
    

