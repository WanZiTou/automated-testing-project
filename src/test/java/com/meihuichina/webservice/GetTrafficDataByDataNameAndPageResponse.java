
package com.meihuichina.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getTrafficDataByDataNameAndPageReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getTrafficDataByDataNameAndPageReturn"
})
@XmlRootElement(name = "getTrafficDataByDataNameAndPageResponse")
public class GetTrafficDataByDataNameAndPageResponse {

    @XmlElement(required = true)
    protected String getTrafficDataByDataNameAndPageReturn;

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetTrafficDataByDataNameAndPageReturn() {
        return getTrafficDataByDataNameAndPageReturn;
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetTrafficDataByDataNameAndPageReturn(String value) {
        this.getTrafficDataByDataNameAndPageReturn = value;
    }

}
