package xmlp;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.*;

public class DomparserSchema {

  public static void main(String[] args) {
    try {
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

           factory.setValidating(true);
      factory.setNamespaceAware(true);

          SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      Schema schema = schemaFactory.newSchema(new File("foods.xsd"));

      factory.setSchema(schema);

      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new File("foods.xml"));
      System.out.println(doc.getDocumentElement().getNodeName());

    } catch (SAXParseException e) {
      System.out.println("Validation error: " + e.getMessage());
    } catch (SAXException e) {
      System.out.println("SAX error: " + e.getMessage());
    } catch (Exception e) {
      // Catch any other general errors and print the message
      System.out.println("Error: " + e.getMessage());
    }
  }
}
