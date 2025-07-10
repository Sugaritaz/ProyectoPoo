
package try3;
import java.util.ArrayList;
import java.util.Date;
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
  


    public Vendedor getVendedor() { return vendedor; }
    public int getIdVenta() { return idVenta; }
    public Cliente getCliente() { return cliente; }
    public ArrayList<ItemVenta> getItems() { return items; }
}
    

