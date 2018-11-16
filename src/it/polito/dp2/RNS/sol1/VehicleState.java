package it.polito.dp2.RNS.sol1;

import java.io.Serializable;

public enum VehicleState implements Serializable, Comparable<VehicleState> {
	PARKED,
    IN_TRANSIT;

    public String value() {
        return name();
    }

    public static VehicleState fromValue(String v) {
        return valueOf(v);
    }
}
