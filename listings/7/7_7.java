import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SaxPrint extends DefaultHandler { 
    
    private StringBuffer buf = new StringBuffer();

    public void startDocument() throws SAXException {
        System.out.println("Начало документа");
    }

    public void endDocument() throws SAXException {
        System.out.println("Конец документа");
    }

    public void startElement(String uri, String lName, String qName, Attributes attribs) throws SAXException {
        System.out.print("\nНачало <" + qName + ">");

        if (attribs.getLength() > 0) {
            for (int i = 0; i < attribs.getLength(); i++) {
                System.out.print(", " + attribs.getQName(i) + " = " + attribs.getValue(i));
            }
        }
        System.out.println();
    }

    public void endElement(String uri, String lName, String qName) throws SAXException {
        System.out.println("Конец </" + qName + ">");
    }

    public void characters(char[] data, int start, int length) throws SAXException {
        buf.append(new String(data, start, length));
    }
    
    private void coll() {
        if (buf.toString().trim().length() > 0) {
            System.out.println("Text: " + buf.toString().trim());
        }
        buf.setLength(0);
    }
    
    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Usage: java SaxPrint имя_файла.xml");
            System.exit(0);
        }

        try {
            File docFile = new File(args[0]);
            
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            parser.parse(docFile, new SaxPrint());
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    } 
    
} 