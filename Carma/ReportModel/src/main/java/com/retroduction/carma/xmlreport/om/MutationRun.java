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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processingInfo" type="{}ProcessingInfo"/>
 *         &lt;element name="mutationRatio" type="{}MutationRatio"/>
 *         &lt;element name="classUnderTest" type="{}ClassUnderTest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="brokenTests" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processingInfo",
    "mutationRatio",
    "classUnderTest",
    "brokenTests"
})
@XmlRootElement(name = "mutationRun")
public class MutationRun {

    @XmlElement(required = true)
    protected ProcessingInfo processingInfo;
    @XmlElement(required = true)
    protected MutationRatio mutationRatio;
    protected List<ClassUnderTest> classUnderTest;
    protected List<String> brokenTests;

    /**
     * Gets the value of the processingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingInfo }
     *     
     */
    public ProcessingInfo getProcessingInfo() {
        return processingInfo;
    }

    /**
     * Sets the value of the processingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingInfo }
     *     
     */
    public void setProcessingInfo(ProcessingInfo value) {
        this.processingInfo = value;
    }

    /**
     * Gets the value of the mutationRatio property.
     * 
     * @return
     *     possible object is
     *     {@link MutationRatio }
     *     
     */
    public MutationRatio getMutationRatio() {
        return mutationRatio;
    }

    /**
     * Sets the value of the mutationRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link MutationRatio }
     *     
     */
    public void setMutationRatio(MutationRatio value) {
        this.mutationRatio = value;
    }

    /**
     * Gets the value of the classUnderTest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classUnderTest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassUnderTest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassUnderTest }
     * 
     * 
     */
    public List<ClassUnderTest> getClassUnderTest() {
        if (classUnderTest == null) {
            classUnderTest = new ArrayList<ClassUnderTest>();
        }
        return this.classUnderTest;
    }

    /**
     * Gets the value of the brokenTests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brokenTests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrokenTests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBrokenTests() {
        if (brokenTests == null) {
            brokenTests = new ArrayList<String>();
        }
        return this.brokenTests;
    }

}
