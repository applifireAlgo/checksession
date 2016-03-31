package com.app.shared.shoppingcontext.onlineshopping;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentDetails {

    private Double amount;

    private String ccHolderName;

    private String creditCardNo;

    private String customerId;

    private String cvvNo;

    private Integer expiryMonth;

    private Integer expiryYear;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double _amount) {
        this.amount = _amount;
    }

    public String getCcHolderName() {
        return ccHolderName;
    }

    public void setCcHolderName(String _ccHolderName) {
        this.ccHolderName = _ccHolderName;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String _creditCardNo) {
        this.creditCardNo = _creditCardNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String _customerId) {
        this.customerId = _customerId;
    }

    public String getCvvNo() {
        return cvvNo;
    }

    public void setCvvNo(String _cvvNo) {
        this.cvvNo = _cvvNo;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer _expiryMonth) {
        this.expiryMonth = _expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer _expiryYear) {
        this.expiryYear = _expiryYear;
    }
}
