
package com.meihuichina.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * 
 * <p>
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getImgUrlByAccountReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getImgUrlByAccountReturn"
})
@XmlRootElement(name = "getImgUrlByAccountResponse")
public class GetImgUrlByAccountResponse {

    @XmlElement(required = true)
    protected String getImgUrlByAccountReturn;

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetImgUrlByAccountReturn() {
        return getImgUrlByAccountReturn;
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetImgUrlByAccountReturn(String value) {
        this.getImgUrlByAccountReturn = value;
    }

}
