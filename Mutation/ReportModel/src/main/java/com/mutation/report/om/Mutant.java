//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.02 at 11:45:18 PM CEST 
//


package com.mutation.report.om;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Mutant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mutant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="survived" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceInstruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetInstruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baseSourceLine" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="killerTests" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mutant", propOrder = {
    "survived",
    "name",
    "operatorName",
    "sourceInstruction",
    "targetInstruction",
    "baseSourceLine",
    "killerTests"
})
public class Mutant {

    protected boolean survived;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String operatorName;
    @XmlElement(required = true)
    protected String sourceInstruction;
    @XmlElement(required = true)
    protected String targetInstruction;
    protected long baseSourceLine;
    protected List<String> killerTests;

    /**
     * Gets the value of the survived property.
     * 
     */
    public boolean isSurvived() {
        return survived;
    }

    /**
     * Sets the value of the survived property.
     * 
     */
    public void setSurvived(boolean value) {
        this.survived = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the sourceInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceInstruction() {
        return sourceInstruction;
    }

    /**
     * Sets the value of the sourceInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceInstruction(String value) {
        this.sourceInstruction = value;
    }

    /**
     * Gets the value of the targetInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetInstruction() {
        return targetInstruction;
    }

    /**
     * Sets the value of the targetInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetInstruction(String value) {
        this.targetInstruction = value;
    }

    /**
     * Gets the value of the baseSourceLine property.
     * 
     */
    public long getBaseSourceLine() {
        return baseSourceLine;
    }

    /**
     * Sets the value of the baseSourceLine property.
     * 
     */
    public void setBaseSourceLine(long value) {
        this.baseSourceLine = value;
    }

    /**
     * Gets the value of the killerTests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the killerTests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKillerTests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKillerTests() {
        if (killerTests == null) {
            killerTests = new ArrayList<String>();
        }
        return this.killerTests;
    }

}
