package try3;

public class Cliente extends Persona {
    private int  idCliente;
    public Cliente(String nombre, String correo, String telefono) {
        super(nombre, correo, telefono);
    }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    }

