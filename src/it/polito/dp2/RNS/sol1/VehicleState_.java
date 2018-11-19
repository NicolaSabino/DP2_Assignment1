package it.polito.dp2.RNS.sol1;

import java.io.Serializable;

public enum VehicleState_ implements Serializable, Comparable<VehicleState_> {
	PARKED,
    IN_TRANSIT;

    public String value() {
        return name();
    }

    public static VehicleState_ fromValue(String v) {
        return valueOf(v);
    }
}
