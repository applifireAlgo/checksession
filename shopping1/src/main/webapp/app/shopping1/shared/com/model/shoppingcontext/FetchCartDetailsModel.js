Ext.define('Shopping1.shopping1.shared.com.model.shoppingcontext.FetchCartDetailsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "itemName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemPrice",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "itemQuantity",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "subTotal",
          "type": "auto",
          "defaultValue": ""
     }]
});