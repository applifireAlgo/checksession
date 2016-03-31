Ext.define('Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "itemId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "productid",
          "reference": "Product",
          "defaultValue": ""
     }, {
          "name": "categoryid",
          "reference": "Category",
          "defaultValue": ""
     }, {
          "name": "brandid",
          "reference": "Brand",
          "defaultValue": ""
     }, {
          "name": "itemName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemPrice",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "itemStock",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "itemIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});