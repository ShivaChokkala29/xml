package xmlp;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class DomparserDTD {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(true);
      factory.setNamespaceAware(true);
      factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                           "http://www.w3.org/2001/XMLSchema");
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("foods.xml"));
      System.out.println(document);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
