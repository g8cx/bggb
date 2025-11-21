import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class DomPrint {

    private static void printIndentation(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print(" | ");
        }
    }

    private static void print(Node node, int level) {
        
        printIndentation(level); 
        System.out.println(" * * ");
        
        printIndentation(level);
        System.out.println(">> " + node.getNodeName().toString() + " <<");

        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null && attributes.getLength() > 0) {
            
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                
                String attrName = attribute.getNodeName();
                String attrValue = attribute.getNodeValue();
                
                printIndentation(level + 1);
                System.out.println(" - " + attrName + " = " + attrValue);
            }
            printIndentation(level);
            System.out.println("Атрибуты закончены");
        }

        String value = node.getNodeValue();
        if (value != null) {
            value = value.trim();
            if (!value.isEmpty()) {
                printIndentation(level);
                System.out.println("Значение: " + value);
            }
        }
        
        NodeList children = node.getChildNodes();
        if (children != null) {
            
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                
                print(child, level + 1); 
            }
        }
        
    }

    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Usage: java DomPrint имя_XML_файла");
            System.exit(0);
        }

        File docFile = new File(args[0]);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document doc = builder.parse(docFile);
            
            Node rootElement = doc.getDocumentElement();
            
            print(rootElement, 0); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
} 