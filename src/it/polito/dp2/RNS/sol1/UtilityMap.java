package it.polito.dp2.RNS.sol1;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;


import it.polito.dp2.RNS.sol1.jaxb.GateType;
import it.polito.dp2.RNS.sol1.jaxb.ParkingAreaType;
import it.polito.dp2.RNS.sol1.jaxb.PlaceType;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;
import it.polito.dp2.RNS.sol1.jaxb.RoadSegmentType;
import it.polito.dp2.RNS.sol1.jaxb.VehicleType;

public class UtilityMap {
	

	  public Map<String,IdentifiedEntityReader_> i_map;
	  public Map<String,PlaceReader_>	p_map;
	  public Map<String,RoadSegmentReader_> rs_map;
	  public Map<String,ParkingAreaReader_> pa_map;
	  public Map<String,GateReader_> g_map;
	  public Map<String,VehicleReader_> v_map;
	  //public List<PlaceReader_> p_list;
	  
	  /**
	   * Constructor
	   * @param rns
	   */
	  public UtilityMap(RoadNavigationSystem rns) {
		  
		this.p_map = new HashMap<>();
		this.rs_map = new HashMap<>();
		this.pa_map = new HashMap<>();
		this.i_map = new HashMap<>();
		this.v_map = new HashMap<>();
		
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
			//this.p_list.add(place);				// store the PlaceReader in a list (for generate next places)
			this.i_map.put(p.getId(), entity);		// store the IdentifiedEntityReader
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
		
		
		// NEXT PLACES
		for(PlaceType p:rns.getPlace()){					// for each place
			PlaceReader_ tmp = this.p_map.get(p.getId());	// get the corresponding reader
			List<String> strings = p.getNextPlace();		// get the list of further places
			Set<PlaceReader_> nextHops = new HashSet<>();	// create an empty HashSet
			for(String tmp2:strings){						// for each next place in the list
				PlaceReader_ nextHop = this.p_map.get(tmp2);	// get the corresponding next hop-reader
				nextHops.add(nextHop); 						// add this hop in the hash set
			}
			tmp.setNextPlaces(nextHops); //update the `next place` Set for this element
		}
		
		
		
		//creating read-only collections
        //this.placeToString = Collections.unmodifiableMap(this.placeToString);
        this.p_map = Collections.unmodifiableMap(this.p_map);
        //this.p_list = Collections.unmodifiableList(this.p_list);

	}

}
