package it.polito.dp2.RNS.sol1;

import java.util.Set;

public class PlaceReader implements it.polito.dp2.RNS.PlaceReader{

	private String id;
	private int capacity;
	private Set<it.polito.dp2.RNS.PlaceReader> nextplaces;
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	@Override
	public Set<it.polito.dp2.RNS.PlaceReader> getNextPlaces() {
		// TODO Auto-generated method stub
		return this.nextplaces;
	}

	

	

}
