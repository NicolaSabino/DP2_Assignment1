package it.polito.dp2.RNS.sol1;

import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class ParkingAreaReader_ implements it.polito.dp2.RNS.ParkingAreaReader {
	
	private String id;
	private int capacity;
	private Set<String> services;
	private Set<PlaceReader> nextplaces;
	
	public ParkingAreaReader_(String id, int capacity, Set<String> services, Set<PlaceReader> nextPlaces) {
		if(id != null) this.id = id;
		if(capacity != 0) this.capacity = capacity;
		if(services != null) this.services = services;
		if(nextPlaces != null) this.nextplaces = nextPlaces;
	}
	
	@Override
	public Set<String> getServices() {
		return this.services;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	@Override
	public Set<PlaceReader> getNextPlaces() {
		// TODO Auto-generated method stub
		return this.nextplaces;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
