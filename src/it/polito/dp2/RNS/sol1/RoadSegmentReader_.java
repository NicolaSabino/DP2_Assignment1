package it.polito.dp2.RNS.sol1;

import java.util.Set;

import it.polito.dp2.RNS.PlaceReader;

public class RoadSegmentReader_ implements it.polito.dp2.RNS.RoadSegmentReader {

	private String id;
	private int capacity;
	private String name;
	private String roadName;
	private Set<PlaceReader> nextPlaces;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getRoadName() {
		// TODO Auto-generated method stub
		return this.roadName;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	@Override
	public Set<PlaceReader> getNextPlaces() {
		// TODO Auto-generated method stub
		return this.nextPlaces;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
