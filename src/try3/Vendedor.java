package try3;

public class Vendedor extends Persona {
    private int idVendedor;
    private String usuario;

    public Vendedor(int idVendedor, String nombre, String correo, String telefono, String usuario) {
        super(nombre, correo, telefono);
        this.idVendedor = idVendedor;
        this.usuario = usuario;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public String getUsuario() {
        return usuario;
    }
}
