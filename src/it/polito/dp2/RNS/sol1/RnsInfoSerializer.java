package it.polito.dp2.RNS.sol1;

import java.util.Set;
import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.RnsReaderFactory;

public class RnsInfoSerializer {
	private RnsReader 			monitor;
	private RnsReaderFactory	factory;
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
		this.factory = RnsReaderFactory.newInstance();
		this.monitor = factory.newRnsReader();
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
		// Get the list of Gates
				Set<GateReader> set = monitor.getGates(null);
				
				/* Print the header of the table */
				printHeader('#',"#Information about GATES");
				printHeader("#Number of Gates: "+set.size());
				printHeader("#List of Gates:");
				printHeader("Id"+"\tCapacity"+"\tType",'-');
				
				// For each Gate print related data
				for (GateReader gate: set) {
					printHeader(gate.getId()+"\t"+gate.getCapacity()+"\t"+gate.getType().name());
				}
	}
	
	private void printHeader(String header) {
		System.out.println(header);
	}

	private void printHeader(String header, char c) {		
		System.out.println(header);
		printLine(c);	
	}
	
	private void printHeader(char c, String header) {		
		printLine(c);	
		System.out.println(header);
	}
	
	private void printLine(char c) {
		System.out.println(makeLine(c));
	}
	
	private StringBuffer makeLine(char c) {
		StringBuffer line = new StringBuffer(132);
		
		for (int i = 0; i < 132; ++i) {
			line.append(c);
		}
		return line;
	}

	
}
