//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.06.12 at 08:28:31 PM CEST 
//


package com.retroduction.carma.xmlreport.om;

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
 *         &lt;element name="transitionGroup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceInstruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetInstruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baseSourceLineStart" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="baseSourceLineEnd" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="baseSourceColumnStart" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="baseSourceColumnEnd" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "transitionGroup",
    "transition",
    "sourceInstruction",
    "targetInstruction",
    "baseSourceLineStart",
    "baseSourceLineEnd",
    "baseSourceColumnStart",
    "baseSourceColumnEnd",
    "killerTests"
})
public class Mutant {

    protected boolean survived;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String transitionGroup;
    @XmlElement(required = true)
    protected String transition;
    @XmlElement(required = true)
    protected String sourceInstruction;
    @XmlElement(required = true)
    protected String targetInstruction;
    protected long baseSourceLineStart;
    protected long baseSourceLineEnd;
    protected long baseSourceColumnStart;
    protected long baseSourceColumnEnd;
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
     * Gets the value of the transitionGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransitionGroup() {
        return transitionGroup;
    }

    /**
     * Sets the value of the transitionGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransitionGroup(String value) {
        this.transitionGroup = value;
    }

    /**
     * Gets the value of the transition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransition() {
        return transition;
    }

    /**
     * Sets the value of the transition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransition(String value) {
        this.transition = value;
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
     * Gets the value of the baseSourceLineStart property.
     * 
     */
    public long getBaseSourceLineStart() {
        return baseSourceLineStart;
    }

    /**
     * Sets the value of the baseSourceLineStart property.
     * 
     */
    public void setBaseSourceLineStart(long value) {
        this.baseSourceLineStart = value;
    }

    /**
     * Gets the value of the baseSourceLineEnd property.
     * 
     */
    public long getBaseSourceLineEnd() {
        return baseSourceLineEnd;
    }

    /**
     * Sets the value of the baseSourceLineEnd property.
     * 
     */
    public void setBaseSourceLineEnd(long value) {
        this.baseSourceLineEnd = value;
    }

    /**
     * Gets the value of the baseSourceColumnStart property.
     * 
     */
    public long getBaseSourceColumnStart() {
        return baseSourceColumnStart;
    }

    /**
     * Sets the value of the baseSourceColumnStart property.
     * 
     */
    public void setBaseSourceColumnStart(long value) {
        this.baseSourceColumnStart = value;
    }

    /**
     * Gets the value of the baseSourceColumnEnd property.
     * 
     */
    public long getBaseSourceColumnEnd() {
        return baseSourceColumnEnd;
    }

    /**
     * Sets the value of the baseSourceColumnEnd property.
     * 
     */
    public void setBaseSourceColumnEnd(long value) {
        this.baseSourceColumnEnd = value;
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
