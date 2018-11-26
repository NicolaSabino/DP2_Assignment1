package it.polito.dp2.RNS.sol1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	
	private UtilityMap utility;
	

	/**
	 * Constructor
	 * @param rns 
	 */
	public RnsReader_(it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem rns) {
		this.utility = new UtilityMap(rns);
	}

	@Override
	public Set<it.polito.dp2.RNS.ConnectionReader> getConnections() {
		Set<it.polito.dp2.RNS.ConnectionReader> result_set = new HashSet<>(this.utility.c_list);
		return result_set;
	}

	@Override
	public Set<it.polito.dp2.RNS.GateReader> getGates(it.polito.dp2.RNS.GateType arg0) {
		
		Set<it.polito.dp2.RNS.GateReader> result_set = new HashSet<>();
		if(arg0 != null){	// select all the gates from a given type specified in arg0
			String type = arg0.toString();
			List<GateReader_> gates = new ArrayList<GateReader_>(this.utility.g_map.values()); // get the whole list of gates casting the map into a list
			for(GateReader_ gr:gates){ 															// for each gate in the list
				if(gr.getType().toString().compareTo(type) == 0){ 								// if the type is the selected one by arg0
					result_set.add(gr); 														// add the gate reader to the return_set
				}
			}
		}else{	// otherwise select all the gates
			result_set.addAll(this.utility.g_map.values());
		}
		return result_set;
	}

	@Override
	public Set<it.polito.dp2.RNS.ParkingAreaReader> getParkingAreas(Set<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public it.polito.dp2.RNS.PlaceReader getPlace(String arg0) {
		PlaceReader_ p = this.utility.p_map.get(arg0);
		return p;
	}

	@Override
	public Set<it.polito.dp2.RNS.PlaceReader> getPlaces(String arg0) {
		Set<it.polito.dp2.RNS.PlaceReader> result_set = new HashSet<>();
		if(arg0 != null){ // we have to select only places with a given prefix
			Map<String,PlaceReader_> map = this.utility.getByPrefix(arg0);	// return a pruned map of places
			result_set.addAll(map.values());								// add the pruned map in the result set
		}else{	// otherwise add all the places stored in p_map in result set
			result_set.addAll(this.utility.p_map.values());
		}
		return result_set;
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
