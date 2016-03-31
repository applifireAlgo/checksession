package com.app.shared.shoppingcontext.onlineshopping;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionResponse {

    private String message;

    private Boolean status;

    private String transactionId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String _message) {
        this.message = _message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean _status) {
        this.status = _status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String _transactionId) {
        this.transactionId = _transactionId;
    }
}
