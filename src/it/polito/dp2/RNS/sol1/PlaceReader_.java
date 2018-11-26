package it.polito.dp2.RNS.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class PlaceReader_ implements PlaceReader{

	private IdentifiedEntityReader_ id;
	private int capacity;
	private Set<PlaceReader_> nextPlaces;
	
	/**
	 * Second Constructor
	 * @param id
	 * @param capacity
	 */
	public PlaceReader_(IdentifiedEntityReader_ id, int capacity) {
		if(id != null) this.id = id;
		if(capacity != 0) this.capacity = capacity;
	}
	
	@Override
	public String getId() {
		return this.id.getId();
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
	
	/**
	 * Set `nextPlaces`
	 * @param set
	 */
	public void setNextPlaces(Set<PlaceReader_> set){
		this.nextPlaces = set;
	}
	
}
