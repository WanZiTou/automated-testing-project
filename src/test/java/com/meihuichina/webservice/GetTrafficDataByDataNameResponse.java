
package com.meihuichina.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getTrafficDataByDataNameReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getTrafficDataByDataNameReturn"
})
@XmlRootElement(name = "getTrafficDataByDataNameResponse")
public class GetTrafficDataByDataNameResponse {

    @XmlElement(required = true)
    protected String getTrafficDataByDataNameReturn;

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetTrafficDataByDataNameReturn() {
        return getTrafficDataByDataNameReturn;
    }

    /**
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetTrafficDataByDataNameReturn(String value) {
        this.getTrafficDataByDataNameReturn = value;
    }

}
