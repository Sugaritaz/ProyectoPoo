package try3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataManagerClientes {

    public static List<Cliente> loadClientesFromXML(String filePath) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) return clientes;

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("cliente");

            for (int i = 0; i < nList.getLength(); i++) {
                Element el = (Element) nList.item(i);
                String nombre = el.getElementsByTagName("nombre").item(0).getTextContent();
                String email = el.getElementsByTagName("correo").item(0).getTextContent();
                String telefono = el.getElementsByTagName("telefono").item(0).getTextContent();
                clientes.add(new Cliente(nombre, email, telefono));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void saveClientesToXML(List<Cliente> clientes, String filePath) {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("clientes");
            doc.appendChild(root);

            for (Cliente cliente : clientes) {
                Element c = doc.createElement("cliente");

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(cliente.getNombre());
                c.appendChild(nombre);

                Element correo = doc.createElement("correo");
                correo.setTextContent(cliente.getCorreo());
                c.appendChild(correo);

                Element telefono = doc.createElement("telefono");
                telefono.setTextContent(cliente.getTelefono());
                c.appendChild(telefono);

                root.appendChild(c);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
