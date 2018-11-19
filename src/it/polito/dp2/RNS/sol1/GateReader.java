package it.polito.dp2.RNS.sol1;

import java.util.Set;

import it.polito.dp2.RNS.GateType;
import it.polito.dp2.RNS.PlaceReader;

public class GateReader implements it.polito.dp2.RNS.GateReader {
	
	// attributes
	private String id;
	private GateType type;
	private int capacity;
	private Set<PlaceReader> places;
	
	@Override
	public GateType getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	@Override
	public Set<PlaceReader> getNextPlaces() {
		// TODO Auto-generated method stub
		return this.places;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
