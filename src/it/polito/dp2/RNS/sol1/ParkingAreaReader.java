package it.polito.dp2.RNS.sol1;

import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class ParkingAreaReader implements it.polito.dp2.RNS.ParkingAreaReader {
	
	private String id;
	private int capacity;
	private Set<String> services;
	private Set<PlaceReader> nextplaces;
	
	@Override
	public Set<String> getServices() {
		// TODO Auto-generated method stub
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
