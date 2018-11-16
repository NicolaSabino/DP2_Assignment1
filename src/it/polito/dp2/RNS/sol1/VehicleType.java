package it.polito.dp2.RNS.sol1;

import java.io.Serializable;

public enum VehicleType implements Serializable, Comparable<VehicleType> {
	
	CAR,
    TRUCK,
    SHUTTLE,
    CARAVAN;

    public String value() {
        return name();
    }

    public static VehicleType fromValue(String v) {
        return valueOf(v);
    }
}
