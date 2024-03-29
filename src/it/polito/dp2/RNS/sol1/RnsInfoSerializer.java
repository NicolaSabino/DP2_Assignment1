package it.polito.dp2.RNS.sol1;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import it.polito.dp2.RNS.ConnectionReader;
import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.ParkingAreaReader;
import it.polito.dp2.RNS.PlaceReader;
import it.polito.dp2.RNS.RnsReader;
import it.polito.dp2.RNS.RnsReaderException;
import it.polito.dp2.RNS.RnsReaderFactory;
import it.polito.dp2.RNS.RoadSegmentReader;
import it.polito.dp2.RNS.VehicleReader;
import it.polito.dp2.RNS.sol1.jaxb.ConnectionType;
import it.polito.dp2.RNS.sol1.jaxb.GateType;
import it.polito.dp2.RNS.sol1.jaxb.ParkingAreaType;
import it.polito.dp2.RNS.sol1.jaxb.PlaceType;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;
import it.polito.dp2.RNS.sol1.jaxb.RoadSegmentType;
import it.polito.dp2.RNS.sol1.jaxb.VState;
import it.polito.dp2.RNS.sol1.jaxb.VType;
import it.polito.dp2.RNS.sol1.jaxb.VehicleType;

public class RnsInfoSerializer {
	private RnsReader 			monitor;	// used to access to the interface
	private RnsReaderFactory	factory;	// factory used to instantiate the interface
	private Marshaller			marshaller;
	private JAXBContext 		context;

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
		this.context	= null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// check if there is the file name
		if (args.length == 0){
            //if there are no arguments print an error
			// we identify this error with ERRORCODE #1
			System.err.println("No filename");
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
			
			// Create an element for marshaling.
			// Since the root element in the XSD Schema file
			// has an anonymous complex type, we can use directly
			// `RoadNavigationSystem` instead of JAXBElement<RoadNavigationSystem>
			RoadNavigationSystem system = new RoadNavigationSystem();
			this.manageConnections(system);
			this.manageGates(system);
			this.manageParkingAreas(system);
			this.manageRoadSegments(system);
			this.manageVehicles(system);
			
			
			// Create a JAXBContext capable of handling classes generated into
            // the `it.polito.dp2.RNS.sol1.jaxb` package
			this.context = JAXBContext.newInstance( "it.polito.dp2.RNS.sol1.jaxb" );
			
			// create a Marshaler and configure it
            this.marshaller = this.context.createMarshaller();
            // By default JAXB will not format the XML document.
            // This is done to save space, and not introduce any whitespace 
            // that may accidentally be interpreted as being significant.  
            this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // JAXB defaults the encoding to UTF-8. 
            // You can specify an alternate encoding by setting the Marshaller.JAXB_Encoding 
            // property on the Marshaller.
            this.marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // We can specify the location of the XML schema corresponding to this document 
            // by setting the Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION property on the Marshaller.
            this.marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "xsd/rnsInfo.xsd");
            
            // marshaling operation
            this.marshaller.marshal(system, new File(filename));
            this.marshaller.marshal(system, System.out);

		} catch (JAXBException e) {
			// ERRORCODE #3
			System.err.println("An error occours while the marshal operation");
			e.printStackTrace();
			System.exit(3);
		}
		
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
			entryTime = CalendarConverter.toXMLGregorianCalendar(cal);
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
			for(PlaceReader p : roadSegment.getNextPlaces()){
				temp.getNextPlace().add(p.getId());
			}
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
			for(PlaceReader p : parkingArea.getNextPlaces()){
				temp.getNextPlace().add(p.getId());
			}
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}

	private void manageConnections(RoadNavigationSystem system) {
		// Get the list of connections
		Set<ConnectionReader> set = monitor.getConnections();
		// For each connection store related data
		List<ConnectionType> list = system.getConnection();
		for (ConnectionReader connection: set) {
			// create a temporary container
			ConnectionType temp = new ConnectionType();
			// fill it
			temp.setFrom(connection.getFrom().getId());
			temp.setTo(connection.getTo().getId());
			// add the temporary container into the list
			list.add(temp);
		}
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
			for(PlaceReader p : gate.getNextPlaces()){
				temp.getNextPlace().add(p.getId());
			}
			// add the temporary container into the list
			list.add(temp);
		}
		return;
	}
	
	
	

	
}
