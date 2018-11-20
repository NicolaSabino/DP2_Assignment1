package it.polito.dp2.RNS.sol1;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;

public class RnsReaderFactory_ extends it.polito.dp2.RNS.RnsReaderFactory {
	
	private File		inputFile;
	private JAXBContext context;
	private RnsReader_	result;
	private File		schema;
	
	public RnsReaderFactory_() {
		this.schema = new File("xsd/rnsInfo.xsd");
	}

	@Override
	public RnsReader newRnsReader() throws RnsReaderException {
		
		// Check if the `File` system property is correctly setted
		if(System.getProperty("it.polito.dp2.NFV.sol1.NfvInfo.file")==null)
			// generate a new instance of RnsReaderException
			throw new RnsReaderException("Empty system property (File)");
		
		// Save the system property
		String filename =System.getProperty("it.polito.dp2.NFV.sol1.NfvInfo.file");
		this.inputFile= new File(filename);
		
		try{
			
			// Create a JAXBContext capable of handling 
			// the root element `RoadNavigationSystem`
			this.context = JAXBContext.newInstance( RoadNavigationSystem.class );
			
			// Create the Unmarshaller
			Unmarshaller unmarshaller = this.context.createUnmarshaller();
			
			// Validation
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema;
			
			try {
				schema = sf.newSchema(this.schema);
				unmarshaller.setSchema(schema);
				 unmarshaller.setEventHandler(new CustomValidationEventHandler());
			} catch (SAXException e) {
				System.out.println("An error occurred while applying the schema");
				e.printStackTrace();
				System.exit(1);
			}
			
			// Unmarshall operation
			RoadNavigationSystem rns = (RoadNavigationSystem) unmarshaller.unmarshal(this.inputFile);
			
			//Create the reader
			this.result =  new RnsReader_(rns);
			return  this.result;
			
		} catch( JAXBException je ) {
			je.printStackTrace();
		} catch( ClassCastException cce ) {
			cce.printStackTrace();
		}
		
		
		return null;
	}

}

/**
 *	Custom Validation EventHandler for validation errors
 */
class CustomValidationEventHandler implements ValidationEventHandler {

    @Override
    // The library must never throw runtime exceptions
    public boolean handleEvent(ValidationEvent event) {
		// ignore warnings
        if (event.getSeverity() != ValidationEvent.WARNING) {
            ValidationEventLocator vel = event.getLocator();
            System.err.println("An error accurred while validating the file");
            System.err.println("Line:Col[" + vel.getLineNumber() +
                ":" + vel.getColumnNumber() +
                "]:" + event.getMessage());
        }
            return true;
    }
}
   
