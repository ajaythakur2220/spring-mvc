package com.voca.seve.tset.reception;

import com.ctc.wstx.stax.WstxInputFactory;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.XMLStreamReader2;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajay.thakur on 27/05/2016.
 */
public class TsetReceptionHandler {

    private final XMLInputFactory2 factory = (XMLInputFactory2) WstxInputFactory.newInstance();

    public void handleFileParsing(File file) {

        final Map<String, String> fields = new HashMap<>();
        try {

            InputStream fileInputStream = new FileInputStream(file);
            XMLStreamReader2 reader = (XMLStreamReader2) factory.createXMLStreamReader(fileInputStream);

            String currentPath = "";


//            XMLInputFactory factory = XMLInputFactory.newInstance();
//            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));
            while (reader.hasNext()) {
                int event = reader.next();

//                System.out.println(" +++ Local Name : " + reader.getLocalName());
//                System.out.println(" +++ Text : " + reader.getText());
                switch(event){
                    case XMLStreamConstants.START_ELEMENT:
                        currentPath = currentPath + reader.getLocalName() + '/';
                        System.out.println(" +++ Local Name Start : " + currentPath);

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.println(" +++ Text : " + currentPath + " " + reader.getText().trim());
                        break;
                    case  XMLStreamConstants.END_ELEMENT:
                        System.out.println(" +++ Local Name End: " + reader.getLocalName());
                        currentPath = currentPath.substring(0, currentPath.length() - (reader.getLocalName() + '/').length());
//                        if("DocHdr".equalsIgnoreCase(reader.getLocalName())){
//                            currentPath = null;
//                        }
                        break;
                    default :
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Exception Exception Exception Exception Exception Exception ");
            e.printStackTrace();

        }
    }

    /**
     * add required values to the fields hashmap
     * @param currentPath
     * @param nodeValue
     * @param fields
     */
    private void populateFieldsMap(final String currentPath, final String nodeValue, final Map<String, String> fields) {
//        String key = mapper.mapFrom(currentPath);
//        if(StringUtils.isNotBlank(key)) {
//            fields.put(key, nodeValue);
//        }
    }
}
