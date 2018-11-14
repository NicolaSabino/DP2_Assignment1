package it.polito.dp2.RNS.sol1;

import java.io.File;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.polito.dp2.RNS.ConnectionReader;
import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.ParkingAreaReader;
import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.RnsReaderFactory;
import it.polito.dp2.RNS.RoadSegmentReader;
import it.polito.dp2.RNS.VehicleReader;
import it.polito.dp2.RNS.sol1.jaxb.GateType;
import it.polito.dp2.RNS.sol1.jaxb.ParkingAreaType;
import it.polito.dp2.RNS.sol1.jaxb.PlaceType;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;
import it.polito.dp2.RNS.sol1.jaxb.RoadSegmentType;
import it.polito.dp2.RNS.sol1.jaxb.VState;
import it.polito.dp2.RNS.sol1.jaxb.VType;
import it.polito.dp2.RNS.sol1.jaxb.VehicleType;

public class RnsInfoSerializer {
	private RnsReader 			monitor;
	private RnsReaderFactory	factory;
	private Marshaller			marshaller;
	private JAXBContext 		jc;
	private File				outputfile;
	private DateFormat			dateFormat;

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
		// An XMLGregorianCalendar has a specific W3C string representation,
		// we can format a Date with SimpleDateFormat.
		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
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
			
			RoadNavigationSystem system = new RoadNavigationSystem();
			this.manageConnections(system);
			this.manageGates(system);
			this.manageParkingAreas(system);
			this.manageRoadSegments(system);
			this.manageVehicles(system);
			
			
			// Create a JAXBContext capable of handling classes generated into
            // the `it.polito.dp2.RNS.sol1.jaxb` package
				this.jc = JAXBContext.newInstance( "it.polito.dp2.RNS.sol1.jaxb" );
			// create a Marshaler and configure it
            //this.marshaller = this.jc.createMarshaller();
            //this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // create an element for marshaling
            //RoadNavigationSystem output = new RoadNavigationSystem();
            //JAXBElement<RoadNavigationSystem> output = 
            //this.marshaller.marshal(output,this.outputfile);
            //this.marshaller.marshal(output, System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.err.println("An error occours while the marshal operation");
			e.printStackTrace();
		}
		this.outputfile = new File(filename);
		
	}

	private void manageVehicles(RoadNavigationSystem system) {
		// Get the list of Vehicles
		Set<VehicleReader> set = monitor.getVehicles(null, null, null);
		// For each Vehicle store related data
		List<VehicleType> list = system.getVehicle();
		for (VehicleReader vehicle: set) {
			// create a temporary container
			VehicleType	temp = new VehicleType();
			// fill it
			temp.setId(vehicle.getId());
			
			XMLGregorianCalendar entryTime = null;
			Calendar cal = vehicle.getEntryTime();
			entryTime = this.toXMLGregorianCalendar(cal);
			temp.setEntryTime(entryTime);
			
			String type = vehicle.getType().toString();
			temp.setType(VType.valueOf(type));
			
			String state = vehicle.getState().toString();
			temp.setState(VState.valueOf(state));
			
			temp.setPosition(vehicle.getPosition().getId());
			temp.setOrigin(vehicle.getOrigin().getId());
			temp.setDestination(vehicle.getDestination().getId());
			
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}

	private void manageRoadSegments(RoadNavigationSystem system) {
		// Get the list of Road Segments
		Set<RoadSegmentReader> set = monitor.getRoadSegments(null);
		// For each road segment store related data
		List<PlaceType> list = system.getPlace();
		for (RoadSegmentReader roadSegment: set) {
			// create a temporary container
			PlaceType temp = new PlaceType();
			// fill it
			temp.setId(roadSegment.getId());
			temp.setCapacity(roadSegment.getCapacity());
			RoadSegmentType rs = new RoadSegmentType();
			rs.setName(roadSegment.getName());
			rs.setRoad(roadSegment.getRoadName());
			temp.setRoadSegment(rs);
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}

	private void manageParkingAreas(RoadNavigationSystem system) {
		// Get the list of parking areas
		Set<ParkingAreaReader> set = monitor.getParkingAreas(null);
		// For each parking area store related data
		List<PlaceType> list = system.getPlace();
		for (ParkingAreaReader parkingArea: set) {
			// create a temporary container
			PlaceType temp = new PlaceType();
			// fill it
			temp.setId(parkingArea.getId());
			temp.setCapacity(parkingArea.getCapacity());
			ParkingAreaType pa = new ParkingAreaType();
			Set<String> services = parkingArea.getServices();
			pa.getService().addAll(services);
			temp.setParkingArea(pa);
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}

	private void manageConnections(RoadNavigationSystem system) {
		return;
	}

	private void manageGates(RoadNavigationSystem system) {
		// Get the list of Gates
		Set<GateReader> set = monitor.getGates(null);
		// For each Gate store related data
		List<PlaceType> list = system.getPlace();
		for (GateReader gate: set) {
			// create a temporary container
			PlaceType	temp = new PlaceType();
			// fill it
			temp.setId(gate.getId());
			temp.setCapacity(gate.getCapacity());
			temp.setGate(GateType.valueOf(gate.getType().name()));
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}
	
	private XMLGregorianCalendar toXMLGregorianCalendar(Calendar cal){
		DatatypeFactory dtf;
		try {
			dtf = DatatypeFactory.newInstance();
			XMLGregorianCalendar xgc = dtf.newXMLGregorianCalendar(); 
			xgc.setYear(cal.get(Calendar.YEAR));
			xgc.setDay(cal.get(Calendar.DAY_OF_MONTH));
			xgc.setMonth(cal.get(Calendar.MONTH)+ 1);
			xgc.setHour(cal.get(Calendar.HOUR_OF_DAY));
			xgc.setMinute(cal.get(Calendar.MINUTE));
			xgc.setSecond(cal.get(Calendar.SECOND));
			xgc.setMillisecond(cal.get(Calendar.MILLISECOND));
			// Calendar ZONE_OFFSET and DST_OFFSET fields are in milliseconds.
			int offsetInMinutes = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000);
			xgc.setTimezone(offsetInMinutes); 
			return xgc;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	
}
