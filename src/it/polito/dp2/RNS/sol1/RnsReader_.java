package it.polito.dp2.RNS.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;


public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	private it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem rns;
	private UtilityMap map;
	private List<PlaceReader_> places;
	
	//return lists
	private Set<it.polito.dp2.RNS.PlaceReader> res_places;
	private Set<it.polito.dp2.RNS.ConnectionReader> res_connections;
	private Set<it.polito.dp2.RNS.VehicleReader> res_vehicles;
	

	/**
	 * Constructor
	 * @param rns 
	 */
	public RnsReader_(it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem rns) {
		this.rns = rns;
		this.map = new UtilityMap(rns);
		this.places = this.map.places;
		res_places = preparePlaces();
	}

	private Set<PlaceReader> preparePlaces() {
		Set<it.polito.dp2.RNS.PlaceReader> result = HashSet<PlaceReader>();
		
		return null;
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

	@Override
	public it.polito.dp2.RNS.PlaceReader getPlace(String arg0) {
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
	public Set<it.polito.dp2.RNS.VehicleReader> getVehicles(Calendar arg0, Set<it.polito.dp2.RNS.VehicleType> arg1, it.polito.dp2.RNS.VehicleState arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
