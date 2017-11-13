import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {
private Map<String,Product> prodList = null;
    private Product prod = null;
    public Map<String,Product> getprodList() {
        return prodList;
    }

    boolean bPrice = false;
    boolean btype = false;
    boolean bName = false;
    boolean bImage = false;
    boolean bmanufacturer = false;
    boolean bcondition = false;
    boolean bdiscount = false;
    boolean baccessories = false;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("product")) {

            String id = attributes.getValue("id");

            prod = new Product();
			prod.setId(id);
            if (prodList == null)
                prodList = new HashMap<>();
            prodList.put(id, prod);
        } else if (qName.equalsIgnoreCase("type")) {
            btype = true;
			} else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        } else if (qName.equalsIgnoreCase("image")) {
            bImage = true;
        } else if (qName.equalsIgnoreCase("manufacturer")) {
            bmanufacturer = true;
        }
        else if (qName.equalsIgnoreCase("condition")) {
            bcondition = true;
        }
        else if (qName.equalsIgnoreCase("discount")) {
            bdiscount = true;
        }
        else if (qName.equalsIgnoreCase("accessory")) {
            baccessories = true;
        }
    }

    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("product")) {
        	int count=0;
        }
    }

   
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bImage) {
            prod.setImage(new String(ch, start, length));
            bImage = false;
        } else if (bName) {
            prod.setName(new String(ch, start, length));
            bName = false;
		} else if (btype) {
            prod.setType(new String(ch, start, length));
            btype = false;
        } else if (bPrice) {
            prod.setPrice(new String(ch, start, length));
            bPrice = false;
        } else if (bmanufacturer) {
            prod.setmanufacturer(new String(ch, start, length));
            bmanufacturer = false;
        }
        else if (bcondition) {
            prod.setcondition(new String(ch, start, length));
            bcondition = false;
        }
        else if (bdiscount) {
            prod.setdiscount(new String(ch, start, length));
            bdiscount = false;
        }
        else if (baccessories) {
            prod.setaccessories(new String(ch, start, length));
            baccessories = false;
        }
    }
}