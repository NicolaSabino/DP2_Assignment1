package it.polito.dp2.RNS.sol1;

import java.io.Serializable;

public enum GateType implements Serializable, Comparable<GateType> {
	IN,
    OUT,
    INOUT;

    public String value() {
        return name();
    }

    public static GateType fromValue(String v) {
        return valueOf(v);
    }
}
