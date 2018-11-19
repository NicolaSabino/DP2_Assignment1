package it.polito.dp2.RNS.sol1;

import java.util.Calendar;

import it.polito.dp2.RNS.PlaceReader;
import it.polito.dp2.RNS.VehicleState;
import it.polito.dp2.RNS.VehicleType;

public class VehicleReader  implements it.polito.dp2.RNS.VehicleReader {

	private String id;
	private Calendar entryTime;
	private PlaceReader origin;
	private PlaceReader position;
	private PlaceReader destination;
	private VehicleState state;
	private VehicleType type;
	@Override
	public PlaceReader getDestination() {
		// TODO Auto-generated method stub
		return this.destination;
	}

	@Override
	public Calendar getEntryTime() {
		// TODO Auto-generated method stub
		return this.entryTime;
	}

	@Override
	public PlaceReader getOrigin() {
		// TODO Auto-generated method stub
		return this.origin;
	}

	@Override
	public PlaceReader getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public VehicleState getState() {
		// TODO Auto-generated method stub
		return this.state;
	}

	@Override
	public VehicleType getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
