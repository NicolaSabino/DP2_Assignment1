//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.19 at 12:49:27 PM CET 
//


package it.polito.dp2.RNS.sol1.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for vehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleType">
 *   &lt;complexContent>
 *     &lt;extension base="{}identifiedEntityType">
 *       &lt;attribute name="entryTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="type" use="required" type="{}vType" />
 *       &lt;attribute name="state" use="required" type="{}vState" />
 *       &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="origin" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destination" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleType")
public class VehicleType
    extends IdentifiedEntityType
{

    @XmlAttribute(name = "entryTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryTime;
    @XmlAttribute(name = "type", required = true)
    protected VType type;
    @XmlAttribute(name = "state", required = true)
    protected VState state;
    @XmlAttribute(name = "position", required = true)
    protected String position;
    @XmlAttribute(name = "origin", required = true)
    protected String origin;
    @XmlAttribute(name = "destination", required = true)
    protected String destination;

    /**
     * Gets the value of the entryTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntryTime() {
        return entryTime;
    }

    /**
     * Sets the value of the entryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntryTime(XMLGregorianCalendar value) {
        this.entryTime = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link VType }
     *     
     */
    public VType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link VType }
     *     
     */
    public void setType(VType value) {
        this.type = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link VState }
     *     
     */
    public VState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link VState }
     *     
     */
    public void setState(VState value) {
        this.state = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

}
