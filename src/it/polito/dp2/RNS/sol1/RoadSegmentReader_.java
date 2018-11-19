package it.polito.dp2.RNS.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class RoadSegmentReader_ implements it.polito.dp2.RNS.RoadSegmentReader {

	private String id;
	private int capacity;
	private String name;
	private String roadName;
	private Set<PlaceReader_> nextPlaces;
	
	
	/**
	 * Constructor
	 * @param id
	 * @param capacity
	 * @param name
	 * @param roadName
	 * @param nextPlaces
	 */
	public RoadSegmentReader_(String id, int capacity, String name, String roadName,Set<PlaceReader_> nextPlaces) {
		if(id != null) this.id = id;
		if(capacity != 0) this.capacity = capacity;
		if(name != null) this.name = name;
		if(roadName != null) this.roadName = roadName;
		if(nextPlaces != null) this.nextPlaces = nextPlaces;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getRoadName() {
		return this.roadName;
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
