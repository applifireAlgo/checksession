package com.app.shared.shoppingcontext.onlineshopping;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemTemplate {

    @Min(0)
    @Max(65535)
    private String itemId;

    @Min(0)
    @Max(65535)
    private String itemName;

    @Min(0)
    @Max(65535)
    private String itemIcon;

    @Min(0)
    @Max(65535)
    private String productName;

    @Min(0)
    @Max(65535)
    private String categoryName;

    @Min(0)
    @Max(65535)
    private String brandName;

    @Min(0)
    @Max(65535)
    private String itemPrice;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemQuantity;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String _itemName) {
        this.itemName = _itemName;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String _itemIcon) {
        this.itemIcon = _itemIcon;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String _productName) {
        this.productName = _productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String _categoryName) {
        this.categoryName = _categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String _brandName) {
        this.brandName = _brandName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String _itemPrice) {
        this.itemPrice = _itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer _itemQuantity) {
        this.itemQuantity = _itemQuantity;
    }
}
