package com.app.shared.shoppingcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class FetchCartDetails implements DTOMapperInterface {

    private String itemName;

    private Double itemPrice;

    private Integer itemQuantity;

    private Double subTotal;

    public FetchCartDetails(Object[] aryObject) {
        if (aryObject != null) {
            itemName = (java.lang.String) aryObject[0];
            itemPrice = (java.lang.Double) aryObject[1];
            itemQuantity = (java.lang.Integer) aryObject[2];
            subTotal = (java.lang.Double) aryObject[3];
        } else {
            itemName = null;
            itemPrice = null;
            itemQuantity = null;
            subTotal = null;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }
}
