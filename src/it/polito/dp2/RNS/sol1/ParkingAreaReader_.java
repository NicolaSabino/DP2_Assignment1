package it.polito.dp2.RNS.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class ParkingAreaReader_ implements it.polito.dp2.RNS.ParkingAreaReader {
	
	private String id;
	private int capacity;
	private Set<String> services;
	private Set<PlaceReader_> nextPlaces;
	
	/**
	 * Constructor
	 * @param id
	 * @param capacity
	 * @param services
	 * @param nextPlaces
	 */
	public ParkingAreaReader_(String id, int capacity, Set<String> services, Set<PlaceReader_> nextPlaces) {
		if(id != null) this.id = id;
		if(capacity != 0) this.capacity = capacity;
		if(services != null) this.services = services;
		if(nextPlaces != null) this.nextPlaces = nextPlaces;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public Set<String> getServices() {
		return this.services;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
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
