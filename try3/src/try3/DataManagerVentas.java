package try3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataManagerVentas {

    public static void saveVentasToXML(List<Venta> ventas, String filePath) {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("ventas");
            doc.appendChild(root);

            for (Venta venta : ventas) {
                Element v = doc.createElement("venta");

                Element cliente = doc.createElement("cliente");
                cliente.setTextContent(venta.getCliente().getNombre());
                v.appendChild(cliente);

                Element vendedor = doc.createElement("vendedor");
                vendedor.setTextContent(venta.getVendedor().getNombre());
                v.appendChild(vendedor);

                Element items = doc.createElement("items");
                for (ItemVenta item : venta.getItems()) {
                    Element itemElement = doc.createElement("item");

                    Element nombreProducto = doc.createElement("producto");
                    nombreProducto.setTextContent(item.getProducto().getNombre());
                    itemElement.appendChild(nombreProducto);

                    Element cantidad = doc.createElement("cantidad");
                    cantidad.setTextContent(String.valueOf(item.getCantidad()));
                    itemElement.appendChild(cantidad);

                    Element subtotal = doc.createElement("subtotal");
                    subtotal.setTextContent(String.valueOf(item.getSubtotal()));
                    itemElement.appendChild(subtotal);

                    items.appendChild(itemElement);
                }

                v.appendChild(items);
                root.appendChild(v);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static List<Venta> loadVentasFromXML(String filePath, Inventario inventario, GestorClientes gestorClientes) {
    List<Venta> ventas = new ArrayList<>();

    try {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) return ventas;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList ventaNodes = doc.getElementsByTagName("venta");

        for (int i = 0; i < ventaNodes.getLength(); i++) {
            Node ventaNode = ventaNodes.item(i);
            if (ventaNode.getNodeType() == Node.ELEMENT_NODE) {
                Element ventaElement = (Element) ventaNode;

                String clienteNombre = ventaElement.getElementsByTagName("cliente").item(0).getTextContent();
                String vendedorNombre = ventaElement.getElementsByTagName("vendedor").item(0).getTextContent();
                Vendedor vendedor = new Vendedor(vendedorNombre);

                Cliente cliente = gestorClientes.buscarCliente(clienteNombre);
                if (cliente == null) {
                    cliente = new Cliente(clienteNombre, "", "");
                    gestorClientes.registrarCliente(clienteNombre, "", "");
                }

                NodeList itemNodes = ventaElement.getElementsByTagName("item");
                List<ItemVenta> items = new ArrayList<>();

                for (int j = 0; j < itemNodes.getLength(); j++) {
                    Element itemElement = (Element) itemNodes.item(j);

                    String productoNombre = itemElement.getElementsByTagName("producto").item(0).getTextContent();
                    int cantidad = Integer.parseInt(itemElement.getElementsByTagName("cantidad").item(0).getTextContent());

                    Producto producto = inventario.buscarProducto(productoNombre);
                    if (producto != null) {
                        items.add(new ItemVenta(producto, cantidad));
                    }
                }

                Venta venta = new Venta(0, new java.util.Date(), cliente, vendedor, new ArrayList<>(items));
                ventas.add(venta);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return ventas;
}

    }


