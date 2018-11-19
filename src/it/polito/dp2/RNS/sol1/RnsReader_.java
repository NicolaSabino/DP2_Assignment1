package it.polito.dp2.RNS.sol1;

import java.util.Calendar;
import java.util.Set;

import it.polito.dp2.RNS.ConnectionReader;
import it.polito.dp2.RNS.GateReader;
import it.polito.dp2.RNS.GateType;
import it.polito.dp2.RNS.ParkingAreaReader;
import it.polito.dp2.RNS.PlaceReader;
import it.polito.dp2.RNS.RoadSegmentReader;
import it.polito.dp2.RNS.VehicleReader;
import it.polito.dp2.RNS.VehicleState;
import it.polito.dp2.RNS.VehicleType;

public class RnsReader_ implements it.polito.dp2.RNS.RnsReader {
	
	private Set<ConnectionReader> connectionsReader;
	private Set<GateReader> gatesReader;
	private Set<ParkingAreaReader> parkingAreasReader;
	private PlaceReader placeReader;
	private Set<PlaceReader> placesReader;
	private Set<RoadSegmentReader> roadSegmentsReader;
	private VehicleReader vehicleReader;
	private Set<VehicleReader> vehicleReaders;
		

	@Override
	public Set<ConnectionReader> getConnections() {
		// TODO Auto-generated method stub
		return this.connectionsReader;
	}

	@Override
	public Set<GateReader> getGates(GateType arg0) {
		// TODO Auto-generated method stub
		return this.gatesReader;
	}

	@Override
	public Set<ParkingAreaReader> getParkingAreas(Set<String> arg0) {
		// TODO Auto-generated method stub
		return this.parkingAreasReader;
	}

	@Override
	public PlaceReader getPlace(String arg0) {
		// TODO Auto-generated method stub
		return this.placeReader;
	}

	@Override
	public Set<PlaceReader> getPlaces(String arg0) {
		// TODO Auto-generated method stub
		return this.placesReader;
	}

	@Override
	public Set<RoadSegmentReader> getRoadSegments(String arg0) {
		// TODO Auto-generated method stub
		return this.roadSegmentsReader;
	}

	@Override
	public VehicleReader getVehicle(String arg0) {
		// TODO Auto-generated method stub
		return this.vehicleReader;
	}

	@Override
	public Set<VehicleReader> getVehicles(Calendar arg0, Set<VehicleType> arg1, VehicleState arg2) {
		// TODO Auto-generated method stub
		return this.vehicleReaders;
	}

}
