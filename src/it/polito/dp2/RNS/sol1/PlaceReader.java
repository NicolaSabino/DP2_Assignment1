package it.polito.dp2.RNS.sol1;

import java.util.Set;

public class PlaceReader implements it.polito.dp2.RNS.PlaceReader{

	private String id;
	private int capacity;
	private Set<PlaceReader> nextPlaces;
	
	public PlaceReader(String id, int capacity, PlaceReader nextPlaces) {
		if(id != null) this.id = id;
		if(capacity != 0) this.capacity = capacity;
		//TODO ask if(nextPlaces != null) this.nextPlaces = nextPlaces;
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
	public Set<it.polito.dp2.RNS.PlaceReader> getNextPlaces() {
		return null;
	}

	

	

}
