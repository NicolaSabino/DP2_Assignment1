package it.polito.dp2.RNS.sol1;

import java.util.HashSet;
import java.util.Set;

public class PlaceReader_ implements it.polito.dp2.RNS.PlaceReader{

	private String id;
	private int capacity;
	private Set<it.polito.dp2.RNS.sol1.PlaceReader_> nextPlaces;
	
	public PlaceReader_(String id, int capacity, Set<it.polito.dp2.RNS.sol1.PlaceReader_> nextPlaces) {
		if(id != null) this.id = id;
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

	// TODO 
	// ask info to the assistant
	@Override
	public Set<it.polito.dp2.RNS.sol1.PlaceReader_> getNextPlaces() {
		return this.nextPlaces;
	}

	

	

}
