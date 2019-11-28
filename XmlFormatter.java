import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

class XmlFormatter {

    public String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));

        
            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.

            return writer.writeToString(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String unformattedXml =              
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
				"<company>\n"+
				"<name>Raykor Technologies PVT. Ltd.</name>\n"+
				"<employees>\n"+
				"<employee id=\"1\">\n"+
				"<name>ABC PQR</name>\n"+
				"<address>\n"+
				"<line1>M G Road</line1>\n"+
				"<line2>Baner</line2>\n"+
				"<state>Maharashtra</state>\n"+
				"<city>Pune</city>\n"+
				"</address>\n"+
				"<phones>\n"+
				"<mobile>9876543210</mobile>\n"+
				"<landline>0209876543</landline>\n"+
				"</phones>\n"+
				"<education>\n"+
				"<degree>\n"+
				"<college>\n"+
				"<name>College of engineering</name>\n"+
				"<address>\n"+
				"<line1>M G Road</line1>\n"+
				"<line2>Baner</line2>\n"+
				"<state>Maharashtra</state>\n"+
				"<city>Pune</city>\n"+
				"</address>\n"+
				"</college>\n"+
				"</degree>\n"+
				"</education>\n"+
				"</employee>\n"+
				"</employees>\n"+
				"</company>";

        System.out.println(new XmlFormatter().format(unformattedXml));
    }
}