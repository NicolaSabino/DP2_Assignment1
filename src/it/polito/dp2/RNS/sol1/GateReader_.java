package it.polito.dp2.RNS.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.GateType;
import it.polito.dp2.RNS.PlaceReader;

public class GateReader_ implements GateReader {
	
	// attributes
	private String id;
	private GateType type;
	private int capacity;
	private Set<PlaceReader_> nextPlaces;
	
	/**
	 * Constructor
	 * @param id
	 * @param type
	 * @param capacity
	 * @param nextPlaces
	 */
	public GateReader_(String id, String type, int capacity, Set<PlaceReader_> nextPlaces) {
		if(id != null) this.id = id;
		if(type != null) this.type = GateType.valueOf(type);
		if(capacity != 0) this.capacity = capacity;
		if(nextPlaces != null) this.nextPlaces = nextPlaces;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public int getCapacity() {
		return this.capacity;
	}
	
	@Override
	public GateType getType() {
		return this.type;
	}

	

	/**
	 * @Override
	 * return an object
	 * suitable respect the teacher's class
	 * `PlaceReader`
	 */
	public Set<PlaceReader> getNextPlaces() {
		// create an empty `return set`
		Set<PlaceReader> returnSet = new HashSet<PlaceReader>();
		// for each element in the attribute `this.nextPlaces`
		// add it in the `return set`
		for(PlaceReader_ tmp: this.nextPlaces){
			returnSet.add(tmp);
		}
		return returnSet;
	}

}
