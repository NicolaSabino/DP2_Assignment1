package it.polito.dp2.RNS.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import it.polito.dp2.RNS.*;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;

public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	private RoadNavigationSystem rns;
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
		storeVehiclesAndPlaces();
	}


	


	private void storeVehiclesAndPlaces() {
		List <it.polito.dp2.RNS.sol1.jaxb.VehicleType> vehicles = this.rns.getVehicle();
		
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
