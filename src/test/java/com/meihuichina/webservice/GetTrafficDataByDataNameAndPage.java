
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
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ts" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "account",
    "ts",
    "sig",
    "dataName",
    "currentPage"
})
@XmlRootElement(name = "getTrafficDataByDataNameAndPage")
public class GetTrafficDataByDataNameAndPage {

    @XmlElement(required = true)
    protected String account;
    protected long ts;
    @XmlElement(required = true)
    protected String sig;
    @XmlElement(required = true)
    protected String dataName;
    protected int currentPage;

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     *
     */
    public long getTs() {
        return ts;
    }

    /**
     *
     * 
     */
    public void setTs(long value) {
        this.ts = value;
    }

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSig() {
        return sig;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSig(String value) {
        this.sig = value;
    }

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataName(String value) {
        this.dataName = value;
    }

    /**
     * 
     * 
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 
     * 
     */
    public void setCurrentPage(int value) {
        this.currentPage = value;
    }

}
