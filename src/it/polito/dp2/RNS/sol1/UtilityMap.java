package it.polito.dp2.RNS.sol1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.dp2.RNS.sol1.jaxb.PlaceType;
import it.polito.dp2.RNS.sol1.jaxb.RoadNavigationSystem;

public class UtilityMap {
	

	  public Map<PlaceReader_, String> placeToString;
	  public Map<String, PlaceReader_> stringToPlace;
	  public List<PlaceReader_>	places;
	  
	  /**
	   * Constructor
	   * @param rns
	   */
	  public UtilityMap(RoadNavigationSystem rns) {
		  
		this.placeToString = new HashMap<>();
		this.stringToPlace = new HashMap<>();
		this.places = new ArrayList<>();
		
		for(PlaceType p :rns.getPlace()){
			String id = p.getId();
			int capacity = p.getCapacity();
			PlaceReader_ place = new PlaceReader_(id,capacity);
			this.placeToString.put(place, id);
			this.stringToPlace.put(id, place);
			this.places.add(place);
		}
		
		//creating read-only List
        this.placeToString = Collections.unmodifiableMap(this.placeToString);
        this.stringToPlace = Collections.unmodifiableMap(this.stringToPlace);
        

	}

}
