package it.polito.dp2.RNS.sol1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import it.polito.dp2.RNS.sol1.jaxb.ConnectionType;
import it.polito.dp2.RNS.sol1.jaxb.GateType;
import it.polito.dp2.RNS.sol1.jaxb.ParkingAreaType;
import it.polito.dp2.RNS.sol1.jaxb.PlaceType;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;
import it.polito.dp2.RNS.sol1.jaxb.RoadSegmentType;
import it.polito.dp2.RNS.sol1.jaxb.VehicleType;

public class UtilityMap {
	

	  public Map<String,IdentifiedEntityReader_> i_map;
	  public NavigableMap<String,PlaceReader_>	p_map;
	  public Map<String,RoadSegmentReader_> rs_map;
	  public Map<String,ParkingAreaReader_> pa_map;
	  public Map<String,GateReader_> g_map;
	  public Map<String,VehicleReader_> v_map;
	  public List<ConnectionReader_> c_list;
	  
	  /**
	   * Constructor
	   * @param rns
	   */
	  public UtilityMap(RoadNavigationSystem rns) {
		  
		// If we work with `TreeMap` we can use benefits of underlying tree data structure,
		// and search with prefix with a O(log(N)) complexity.
		// If we work with `HashMap` we can easily retrieve objects with the key 
		// with a O(1) complexity
		// Both `TreeMap` and `HashMap` have the same `Map` interface.
		  
		this.p_map = new TreeMap<>();
		this.rs_map = new HashMap<>();
		this.pa_map = new HashMap<>();
		this.i_map = new HashMap<>();
		this.v_map = new HashMap<>();
		this.g_map = new HashMap<>();
		this.c_list = new ArrayList<>();
		
		
		
		// PLACES
		for(PlaceType p :rns.getPlace()){	// for each place in the system
			IdentifiedEntityReader_ entity = new IdentifiedEntityReader_(p.getId());	// create a new entity
			PlaceReader_ place = new PlaceReader_(entity,p.getCapacity());				// create a new PlaceReader
			if(p.getRoadSegment() != null){ 									// if the place is a ROAD SEGMENT
				RoadSegmentType rst = p.getRoadSegment();							
				RoadSegmentReader_ rs = new RoadSegmentReader_(place, rst.getName(), rst.getRoad());	// create a RoadSegmentReader
				this.rs_map.put(p.getId(),rs);															// store the RoadSegmentReader
			}
			if(p.getParkingArea() != null){										// if the place is a PARKING AREA
				ParkingAreaType pat = p.getParkingArea();
				Set<String> services = new HashSet<>(pat.getService());									// convert a list into a set
				ParkingAreaReader_ pa = new ParkingAreaReader_(place, services);						// create the ParkingAreaReader
				this.pa_map.put(p.getId(), pa);															// store the ParkingAreaReader
			}
			if(p.getGate() != null){											// if the place is a GATE
				GateType gt = p.getGate();																
				GateType_ gtt = GateType_.valueOf(gt.toString());										// conversion
				GateReader_ g = new GateReader_(place, gtt);											// create the GateReader
				this.g_map.put(p.getId(),g);															// store the GateReader
			}
			
			
			this.p_map.put(p.getId(),place);	// store the PlaceReader
			this.i_map.put(p.getId(),entity);	// store the IdentifiedEntityReader
		}
		
		
		// CONNECTIONS
		for(ConnectionType c: rns.getConnection()){ // for each connection in the system
			PlaceReader_ from = this.p_map.get(c.getFrom());							// get the `from` in the p_map
			PlaceReader_ to = this.p_map.get(c.getTo());								// get the `to` in the p_map
			ConnectionReader_ connection = new ConnectionReader_(from, to);				// create a new ConnectionReader
			this.c_list.add(connection);												// store the connection reader
		}
		
		// NEXT PLACES
		// we can also calculate next places from the set of connections
		
		/*
		 * 	for(PlaceType p:rns.getPlace()){ // for each place in the system
		 *		// search all connections where from == p.id
		 *		for(ConnectionReader_ cr:this.c_list){
		 *			PlaceReader_ pr = this.p_map.get(p.getId());
		 *			if(cr.getFrom().getId().compareTo(p.getId()) == 0){
		 *				PlaceReader_ to = this.p_map.get(cr.getTo().getId());
		 *				pr.addNextPlace(to);
		 *			}
		 *		}
		 * 	}
		 */
		
		for(PlaceType p : rns.getPlace()){ // for each place
			PlaceReader_ pp = this.p_map.get(p.getId()); //get the corresponding object in the map
			for(String identifier: p.getNextPlace()){	// for each next place
				PlaceReader_ nexthop = this.p_map.get(identifier); // find the corresponding object place in the map 
				pp.addNextPlace(nexthop); // make the connection
			}
		}
		
		//  VEHICLES
		for(VehicleType v: rns.getVehicle()){	// for each vehicle in the system
			IdentifiedEntityReader_ entity = new IdentifiedEntityReader_(v.getId());	// create a new entity
			PlaceReader_ position = this.p_map.get(v.getPosition());					// get the position in p_map
			PlaceReader_ origin = this.p_map.get(v.getOrigin());						// get the origin in p_map
			PlaceReader_ destination = this.p_map.get(v.getDestination());				// get the destination in p_map
			Calendar entryTime = CalendarConverter.toCalendar(v.getEntryTime());		// convert the entryTime
			VehicleState_ state = VehicleState_.valueOf(v.getState().toString());		// convert the state
			VehicleType_ type = VehicleType_.valueOf(v.getType().toString());			// convert the type
			VehicleReader_ vehicle = new VehicleReader_(entity, entryTime, origin, position, destination, state, type);	// create a vehicle reader
			this.v_map.put(v.getId(), vehicle);	// store the VehicleReader
			this.i_map.put(v.getId(), entity);	// store the entity
			
		}
		
		
		
		
		
		
		//creating read-only collections
        this.p_map = Collections.unmodifiableNavigableMap(this.p_map);
        this.rs_map = Collections.unmodifiableMap(this.rs_map);
        this.pa_map = Collections.unmodifiableMap(this.pa_map);
        this.g_map = Collections.unmodifiableMap(this.g_map);
        this.v_map = Collections.unmodifiableMap(this.v_map);
        this.c_list = Collections.unmodifiableList(this.c_list);

	}
	  
	/**
	 * This method is able to get a portion of map using a prefix
	 * with a O(log(N)) complexity
	 * @param prefix
	 * @return Pruned map
	 */
	public SortedMap<String, PlaceReader_> getByPrefix( String prefix ) {
	        return this.p_map.subMap( prefix, prefix + Character.MAX_VALUE );
	}
	
	/**
	 * This method check if a  generic set is contained into another one
	 * @param setA - Set
	 * @param setB - SubSet
	 * @return true if so, false otherwise
	 */
	public <T> boolean isSubset(Set<T> setA, Set<T> setB) {
	    return setB.containsAll(setA);
	  }

}
