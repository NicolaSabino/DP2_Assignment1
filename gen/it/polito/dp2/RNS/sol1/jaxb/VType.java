//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.12 at 03:53:56 PM CET 
//


package it.polito.dp2.RNS.sol1.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="vType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAR"/>
 *     &lt;enumeration value="TRUCK"/>
 *     &lt;enumeration value="SHUTTLE"/>
 *     &lt;enumeration value="CARAVAN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "vType")
@XmlEnum
public enum VType {

    CAR,
    TRUCK,
    SHUTTLE,
    CARAVAN;

    public String value() {
        return name();
    }

    public static VType fromValue(String v) {
        return valueOf(v);
    }

}