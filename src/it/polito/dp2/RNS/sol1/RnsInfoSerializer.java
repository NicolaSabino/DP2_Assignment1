package it.polito.dp2.RNS.sol1;

import java.io.File;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import it.polito.dp2.RNS.ConnectionReader;
import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.RnsReaderFactory;

public class RnsInfoSerializer {
	private RnsReader 			monitor;
	private RnsReaderFactory	factory;
	private Marshaller			marshaller;
	private JAXBContext 		jc;
	private File				outputfile;
	//private DateFormat			dateFormat;

	/**
	 * Constructor
	 * @throws RnsReaderException 
	 */
	public RnsInfoSerializer() throws RnsReaderException {
		// The implementation of the interfaces to be used as data source
		// must be selected using the  `abstract factory` pattern:
		// we must create the data source by instantiating 
		// `it.polito.dp2.RNS.RnsReaderFactory` by means of its static method
		// `newInstance()`
		this.factory	= RnsReaderFactory.newInstance();
		this.monitor	= factory.newRnsReader();
		this.marshaller = null;
		this.jc			= null;
		this.outputfile	= null;
		//this.dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// check if there is the file name
		if (args.length == 0){
            //if there are no arguments exit the program
			// we identify this error with ERRORCODE #1
			System.out.println("No filename");
            System.exit(1);
        }
		System.err.println("The output file is:" + args[0]);
		RnsInfoSerializer serializer;
		
		try {
			serializer = new RnsInfoSerializer();
			serializer.createFile(args[0]);
		} catch (RnsReaderException e) {
			// An error occurs while the instantiation of the class
			// we identify this error with ERRORCODE #2
			System.err.println("Could not instantiate data generator.");
			e.printStackTrace();
			System.exit(2);
		}
		
		
	}
	
	private void createFile(String filename){
		try {
			// Create a JAXBContext capable of handling classes generated into
            // the `it.polito.dp2.RNS.sol1.jaxb` package
			this.jc = JAXBContext.newInstance( "it.polito.dp2.RNS.sol1.jaxb" );
			// create a Marshaler
            this.marshaller = this.jc.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.outputfile = new File(filename);
		
	}
	

	
}
