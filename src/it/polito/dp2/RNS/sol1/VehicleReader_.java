package it.polito.dp2.RNS.sol1;

import java.util.Calendar;

import it.polito.dp2.RNS.PlaceReader;
import it.polito.dp2.RNS.VehicleState;
import it.polito.dp2.RNS.VehicleType;

public class VehicleReader_  implements it.polito.dp2.RNS.VehicleReader {

	private String id;
	private Calendar entryTime;
	private PlaceReader origin;
	private PlaceReader position;
	private PlaceReader destination;
	private VehicleState state;
	private VehicleType type;
	@Override
	public PlaceReader getDestination() {
		return this.destination;
	}

	@Override
	public Calendar getEntryTime() {
		return this.entryTime;
	}

	@Override
	public PlaceReader getOrigin() {
		return this.origin;
	}

	@Override
	public PlaceReader getPosition() {
		return this.position;
	}

	@Override
	public VehicleState getState() {
		return this.state;
	}

	@Override
	public VehicleType getType() {
		return this.type;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
