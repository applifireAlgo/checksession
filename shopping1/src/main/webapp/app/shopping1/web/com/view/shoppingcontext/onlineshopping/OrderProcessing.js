Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.OrderProcessing', {
     "xtype": "orderProcessing",
     "items": [{
          "xtype": "grids",
          "name": "cartItems",
          "title": "Cart Items",
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "Item",
               "dataIndex": "itemName",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Price",
               "dataIndex": "itemPrice",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Quantity",
               "dataIndex": "itemQuantity",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Sub Total",
               "dataIndex": "subTotal",
               "flex": 1
          }],
          "itemId": "mbjkaji",
          "store": {
               "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.FetchCartDetailsModel",
               "autoLoad": true,
               "autoSync": true,
               "proxy": {
                    "type": "ajax",
                    "url": "secure/FetchCartDetailsWS/fetchcartDetails",
                    "actionMethods": {
                         "read": "POST"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "tools": [{
               "type": "refresh",
               "tooltip": "Refresh Grid Data",
               "handler": "onGridRefreshClick"
          }]
     }, {
          "xtype": "numberfield",
          "fieldLabel": "amount",
          "name": "amount",
          "margin": 5,
          "bindable": "amount",
          "text": "amount",
          "fieldName": "amount",
          "displayName": "amount",
          "fieldType": "java.lang.Double",
          "widget": "numberfield",
          "isField": true,
          "itemId": "aggbedi"
     }, {
          "xtype": "textfield",
          "fieldLabel": "ccHolderName",
          "margin": 5,
          "bindable": "ccHolderName",
          "name": "ccHolderName",
          "text": "ccHolderName",
          "fieldName": "ccHolderName",
          "displayName": "ccHolderName",
          "fieldType": "java.lang.String",
          "widget": "textfield",
          "isField": true,
          "itemId": "piobfmi"
     }, {
          "xtype": "textfield",
          "fieldLabel": "creditCardNo",
          "margin": 5,
          "bindable": "creditCardNo",
          "name": "creditCardNo",
          "text": "creditCardNo",
          "fieldName": "creditCardNo",
          "displayName": "creditCardNo",
          "fieldType": "java.lang.String",
          "widget": "textfield",
          "isField": true,
          "itemId": "ppeefii"
     }, {
          "xtype": "textfield",
          "fieldLabel": "customerId",
          "margin": 5,
          "bindable": "customerId",
          "name": "customerId",
          "text": "customerId",
          "fieldName": "customerId",
          "displayName": "customerId",
          "fieldType": "java.lang.String",
          "widget": "textfield",
          "isField": true,
          "itemId": "blnapki"
     }, {
          "xtype": "textfield",
          "fieldLabel": "cvvNo",
          "margin": 5,
          "bindable": "cvvNo",
          "name": "cvvNo",
          "text": "cvvNo",
          "fieldName": "cvvNo",
          "displayName": "cvvNo",
          "fieldType": "java.lang.String",
          "widget": "textfield",
          "isField": true,
          "itemId": "abpoeoi"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "expiryMonth",
          "name": "expiryMonth",
          "margin": 5,
          "bindable": "expiryMonth",
          "text": "expiryMonth",
          "fieldName": "expiryMonth",
          "displayName": "expiryMonth",
          "fieldType": "java.lang.Integer",
          "widget": "numberfield",
          "isField": true,
          "itemId": "ahodfhi"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "expiryYear",
          "name": "expiryYear",
          "margin": 5,
          "bindable": "expiryYear",
          "text": "expiryYear",
          "fieldName": "expiryYear",
          "displayName": "expiryYear",
          "fieldType": "java.lang.Integer",
          "widget": "numberfield",
          "isField": true,
          "itemId": "oladidi"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "mlcjpii",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "tbfill",
               "itemId": "lbmckli"
          }, {
               "xtype": "button",
               "name": "makePayment",
               "pluginName": "geolocation",
               "isNativeWidget": true,
               "isNativeGeoBtn": true,
               "text": "Make Payment",
               "margin": 5,
               "height": 50,
               "width": 100,
               "style": {
                    "background": "#FF6600"
               },
               "itemId": "cgknjhi",
               "listeners": {
                    "click": "onMakePaymentClick"
               }
          }, {
               "xtype": "tbfill",
               "itemId": "bgohebi"
          }],
          "itemId": "gdefcbi",
          "dockedItems": []
     }],
     "requires": ["Shopping1.shopping1.shared.com.model.shoppingcontext.FetchCartDetailsModel", "Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.OrderProcessingController", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.OrderProcessingViewModel", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.OrderProcessingModel", "Shopping1.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "OrderProcessingViewModel",
     "controller": "OrderProcessingController"
});