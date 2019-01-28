package ua.com.gfalcon.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



/**
 * @author Oleksii Khalikov
 */
public class XKLPraserFactory {

    public void parseDocument() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

//        DefaultHandler handler = new DefaultHandler();
//
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//
//        File file = new File("/src/test/resources/test.xml");
//
//        parser.parse(file, handler);

        XMLInputFactory factory = XMLInputFactory.newInstance();
        String path = "/src/test/resources/test.xml";
        File file = new File(path);
        InputStream stream = new FileInputStream(file);
        XMLStreamReader reader = factory.createXMLStreamReader(stream);

    }

}
