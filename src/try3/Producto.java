package try3;

public class Producto {
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private String marca;

    public Producto(int idProducto, String nombre, String categoria, double precio, int stock, String marca) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
