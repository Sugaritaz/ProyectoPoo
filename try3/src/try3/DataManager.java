package try3;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataManager {

    // Cargar productos desde XML
    public static Map<Integer, Producto> loadProductosFromXML(String filePath) {
        Map<Integer, Producto> productos = new HashMap<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) return productos;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("producto");

            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                int id = Integer.parseInt(element.getElementsByTagName("idProducto").item(0).getTextContent());
                String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                String categoria = element.getElementsByTagName("categoria").item(0).getTextContent();
                double precio = Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent());
                int stock = Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent());
                String marca = element.getElementsByTagName("marca").item(0).getTextContent();
                productos.put(id, new Producto(id, nombre, categoria, precio, stock, marca));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Guardar productos actualizados en XML
    public static void saveProductosToXML(Map<Integer, Producto> productos, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear documento XML
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("productos");
            doc.appendChild(rootElement);

            for (Producto producto : productos.values()) {
                Element prodElement = doc.createElement("producto");

                Element id = doc.createElement("idProducto");
                id.setTextContent(String.valueOf(producto.getIdProducto()));
                prodElement.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(producto.getNombre());
                prodElement.appendChild(nombre);

                Element categoria = doc.createElement("categoria");
                categoria.setTextContent(producto.getCategoria());
                prodElement.appendChild(categoria);

                Element precio = doc.createElement("precio");
                precio.setTextContent(String.valueOf(producto.getPrecio()));
                prodElement.appendChild(precio);

                Element stock = doc.createElement("stock");
                stock.setTextContent(String.valueOf(producto.getStock()));
                prodElement.appendChild(stock);

                Element marca = doc.createElement("marca");
                marca.setTextContent(producto.getMarca());
                prodElement.appendChild(marca);

                rootElement.appendChild(prodElement);
            }

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // formato legible
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
