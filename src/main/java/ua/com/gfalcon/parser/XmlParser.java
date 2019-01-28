package ua.com.gfalcon.parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.io.Reader;



/**
 * @author Oleksii Khalikov
 */
public class XmlParser {

    private final XMLStreamReader reader;

    private DomainContainer domainContainer;

    private StringBuilder stringBuilder;


    public XmlParser(XMLStreamReader reader) {
        this.reader = reader;
        this.domainContainer = new DomainContainer();
        stringBuilder = new StringBuilder();
    }


    public static DomainContainer parse(InputStream inputStream) throws XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
        XmlParser parser = new XmlParser(reader);
        return parser.parse();
    }


    public static DomainContainer parse(Reader streamReader) throws XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(streamReader);
        XmlParser parser = new XmlParser(reader);
        return parser.parse();
    }


    private DomainContainer parse() throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                parseStartElement(reader.getLocalName());
            } else if (event == XMLStreamConstants.CHARACTERS) {
                parseText(reader.getText());
            } else if (event == XMLStreamConstants.END_ELEMENT) {
                parseEndElement(reader.getLocalName());
            }
        }
        return getParsedObject();
    }


    private void parseStartElement(String nodeName) {
        if (nodeName.equals("transaction")) {
            domainContainer.clear();
        }
        stringBuilder.setLength(0);
    }


    private void parseEndElement(String nodeName) {
        if (nodeName.equals("transaction")) {
            domainContainer.putTransaction();
        } else if (nodeName.equals("place")) {
            domainContainer.setPlaceName(stringBuilder.toString());
        } else if (nodeName.equals("amount")) {
            domainContainer.setAmount(stringBuilder.toString());
        } else if (nodeName.equals("currency")) {
            domainContainer.setCurrencyName(stringBuilder.toString());
        } else if (nodeName.equals("card")) {
            domainContainer.setCardNumber(stringBuilder.toString());
        } else if (nodeName.equals("firstName")) {
            domainContainer.setFirstName(stringBuilder.toString());
        } else if (nodeName.equals("lastName")) {
            domainContainer.setLastName(stringBuilder.toString());
        } else if (nodeName.equals("middleName")) {
            domainContainer.setMiddleName(stringBuilder.toString());
        } else if (nodeName.equals("inn")) {
            domainContainer.setInn(stringBuilder.toString());
        }

    }


    private void parseText(String text) {
        stringBuilder.append(text.trim());
    }


    private DomainContainer getParsedObject() {
        return this.domainContainer;
    }

}
