package it.polito.dp2.RNS.sol1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.RnsReaderFactory;
import it.polito.dp2.RNS.lab1.RnsInfo;
import it.polito.dp2.RNS.sol1.jaxb.*;
import it.polito.dp2.RNS.sol1.jaxb.System;

public class RnsInfoSerializer {
	
	private RnsReaderFactory factory;

	
	public RnsInfoSerializer() {
		// The implementation of the interfaces to be used as data source
		// must be selected using the  `abstract factory` pattern:
		// we must create the data source by instantiating 
		// `it.polito.dp2.RNS.RnsReaderFactory` by means of its static method
		// nreInstance();
		this.factory = RnsReaderFactory.newInstance();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RnsInfoSerializer serializer;
		String filename;
		
		if (args.length == 0){
            //no arguments
            return;
        }
		
		serializer = new RnsInfoSerializer();
		serializer.outputFile(args[0]);
	}

	public void outputFile(String filename) {
		
	}
}
