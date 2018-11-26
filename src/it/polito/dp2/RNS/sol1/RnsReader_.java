package it.polito.dp2.RNS.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	
	private UtilityMap utility;
	

	/**
	 * Constructor
	 * @param rns 
	 */
	public RnsReader_(it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem rns) {
		//this.rns = rns;
		this.utility = new UtilityMap(rns);
	}

	@Override
	public Set<it.polito.dp2.RNS.ConnectionReader> getConnections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.GateReader> getGates(it.polito.dp2.RNS.GateType arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.ParkingAreaReader> getParkingAreas(Set<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	// DONE -- CHECK
	@Override
	public it.polito.dp2.RNS.PlaceReader getPlace(String arg0) {
		PlaceReader_ p = this.utility.p_map.get(arg0);
		return p;
	}

	@Override
	public Set<it.polito.dp2.RNS.PlaceReader> getPlaces(String arg0) {
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.RoadSegmentReader> getRoadSegments(String arg0) {
		return null;
	}

	@Override
	public it.polito.dp2.RNS.VehicleReader getVehicle(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<it.polito.dp2.RNS.VehicleReader> getVehicles(Calendar arg0, Set<it.polito.dp2.RNS.VehicleType> arg1, it.polito.dp2.RNS.VehicleState arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
