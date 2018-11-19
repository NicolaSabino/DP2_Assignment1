package it.polito.dp2.RNS.sol1;

import java.util.Set;
import it.polito.dp2.RNS.GateType;
import it.polito.dp2.RNS.PlaceReader;

public class GateReader_ implements it.polito.dp2.RNS.GateReader {
	
	// attributes
	private String id;
	private GateType type;
	private int capacity;
	private Set<PlaceReader> nextPlaces;
	
	public GateReader_(String id, String type, int capacity, Set<PlaceReader> nextPlaces) {
		if(id != null) this.id = id;
		if(type != null) this.type = GateType.valueOf(type);
		if(capacity != 0) this.capacity = capacity;
		if(nextPlaces != null) this.nextPlaces = nextPlaces;
	}
	
	@Override
	public GateType getType() {
		return this.type;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public Set<PlaceReader> getNextPlaces() {
		return this.nextPlaces;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
