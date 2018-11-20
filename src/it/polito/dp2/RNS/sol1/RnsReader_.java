package it.polito.dp2.RNS.sol1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import it.polito.dp2.RNS.*;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;

public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	private RoadNavigationSystem rns;
	private Set<IdentifiedEntityReader>_entities;
	private Set<ConnectionReader_> connections;
	private Set<GateReader_> gates;
	private Set<ParkingAreaReader_> parking;
	private Set<PlaceReader_> places;
	private Set<RoadSegmentReader_> road;
	private VehicleReader_ vehicle;
	private Set<VehicleReader_> vehicles;
	
	private Set<IdentifiedEntityReader_> entities;

	
	/**
	 * Constructor
	 * @param rns 
	 */
	public RnsReader_(RoadNavigationSystem rns) {
		this.rns = rns;
		storeIDEntities();
		storePlaces();
		storeVehicles();
	}


	


	private void storeVehicles() {
		//donor
		List<it.polito.dp2.RNS.sol1.jaxb.VehicleType> places = this.rns.getVehicle();
		//target
		this.vehicles = new HashSet<VehicleReader_>();
		//for each vehicle
		for(it.polito.dp2.RNS.sol1.jaxb.VehicleType vehicle: vehicles){
			String id = vehicle.getId();
			//TODO fix these places
			//String position = vehicle.getPosition();
			//String origin = vehicle.getOrigin();
			//String destination = vehicle.getDestination();
			XMLGregorianCalendar cal = vehicle.getEntryTime();
			String state = vehicle.getState().toString();
			String type = vehicle.getType().toString();
			
			//conversions
			it.polito.dp2.RNS.sol1.jaxb.VState s = it.polito.dp2.RNS.sol1.jaxb.VState.valueOf(state);
			it.polito.dp2.RNS.sol1.jaxb.VType t = it.polito.dp2.RNS.sol1.jaxb.VType.valueOf(type);
			VehicleReader_ tmp = new VehicleReader_(id,null, null, null, null,s, t); // TODO fix
			this.vehicles.add(tmp);
		}
		// all the entities (places and vehicles) are stored in `this.entities
		return;
	}





	private void storePlaces() {
		//donor
		List<it.polito.dp2.RNS.sol1.jaxb.PlaceType> places = this.rns.getPlace();
		//target
		this.places = new HashSet<PlaceReader_>();
		//for each place
		for(it.polito.dp2.RNS.sol1.jaxb.PlaceType place: places){
			String id = place.getId();
			int capacity = place.getCapacity();
			List<String> next = place.getNextPlace();
			PlaceReader_ tmp = new PlaceReader_(id,capacity,null); //TODO remove or fix `null`
			this.places.add(tmp);
		}
		// all the places are stored in `this.entities
		return;
		
	}




	/**
	 * Use in chain storePlaces() and storeVehicles()
	 */
	private void storeIDEntities() {
		// donors
		List<it.polito.dp2.RNS.sol1.jaxb.VehicleType> vehicles = this.rns.getVehicle();
		List<it.polito.dp2.RNS.sol1.jaxb.PlaceType> places = this.rns.getPlace();
		//target
		this.entities = new HashSet<IdentifiedEntityReader_>();
		
		//for each vehicle
		for(it.polito.dp2.RNS.sol1.jaxb.VehicleType vehicle: vehicles){
			IdentifiedEntityReader_ entity = new IdentifiedEntityReader_(vehicle.getId());
			entities.add(entity);
		}
		//for each place
		for(it.polito.dp2.RNS.sol1.jaxb.PlaceType place: places){
			IdentifiedEntityReader_ entity = new IdentifiedEntityReader_(place.getId());
			entities.add(entity);
		}
		// all the entities (places and vehicles) are stored in `this.entities
		return;
	}


	@Override
	public Set<it.polito.dp2.RNS.ConnectionReader> getConnections() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Set<it.polito.dp2.RNS.ParkingAreaReader> getParkingAreas(Set<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public it.polito.dp2.RNS.PlaceReader getPlace(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.PlaceReader> getPlaces(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.RoadSegmentReader> getRoadSegments(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public it.polito.dp2.RNS.VehicleReader getVehicle(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.GateReader> getGates(GateType arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<VehicleReader> getVehicles(Calendar arg0, Set<VehicleType> arg1, VehicleState arg2) {
		// TODO Auto-generated method stub
		return null;
	}



}
