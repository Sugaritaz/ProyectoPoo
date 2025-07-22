package try3;

public class Vendedor extends Persona {
    private int idVendedor;
    private String usuario;

    public Vendedor(String nombre) {
    super(nombre, "", "");
    this.idVendedor = 0;
    this.usuario = "";
}
    public int getIdVendedor() {
        return idVendedor;
    }

    public String getUsuario() {
        return usuario;
    }
}
