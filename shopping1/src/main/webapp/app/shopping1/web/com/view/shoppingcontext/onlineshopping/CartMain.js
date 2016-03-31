Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.CartMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CartMainController",
     "restURL": "/Cart",
     "defaults": {
          "split": true
     },
     "requires": ["Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CartModel", "Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.CartMainController", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel", "Shopping1.shopping1.shared.com.model.aaaboundedcontext.authentication.UserModel", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.CartViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Cart",
               "name": "CartTreeContainer",
               "itemId": "CartTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CartTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Item Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel"
                         },
                         "fieldLabel": "Item Id",
                         "fieldId": "D9217757-930D-4F6F-8CF3-C75F4A4B3F5E",
                         "restURL": "Item",
                         "bindable": "itemId"
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price",
                         "fieldId": "5806F5AE-B19C-48B2-81D6-4573DC3E404D",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "itemPrice"
                    }, {
                         "name": "itemQuantity",
                         "itemId": "itemQuantity",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Quantity",
                         "fieldId": "B38EBEB0-5612-4B48-9512-5FCD8E09112B",
                         "minValue": "0",
                         "maxValue": "1000000000",
                         "bindable": "itemQuantity"
                    }, {
                         "name": "subTotal",
                         "itemId": "subTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sub Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sub Total",
                         "fieldId": "C28BC556-E38C-4B6B-9CDE-B98176C76030",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "subTotal"
                    }, {
                         "name": "userId",
                         "itemId": "userId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.aaaboundedcontext.authentication.UserModel"
                         },
                         "fieldLabel": "User",
                         "fieldId": "F1E3F1CA-43AD-4033-8688-D12A4C1BA910",
                         "restURL": "User",
                         "bindable": "userId"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Cart",
                    "name": "Cart",
                    "itemId": "CartForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "cartId",
                                   "itemId": "cartId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Cart Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Cart Id<font color='red'> *<\/font>",
                                   "fieldId": "3237A1A5-899D-4F69-9B8F-80A6207CD3F1",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "cartId"
                              }, {
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Item Id",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Item Id<font color='red'> *<\/font>",
                                   "fieldId": "D9217757-930D-4F6F-8CF3-C75F4A4B3F5E",
                                   "restURL": "Item",
                                   "bindable": "itemId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "itemPrice",
                                   "itemId": "itemPrice",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price",
                                   "fieldId": "5806F5AE-B19C-48B2-81D6-4573DC3E404D",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "itemPrice",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "itemQuantity",
                                   "itemId": "itemQuantity",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B38EBEB0-5612-4B48-9512-5FCD8E09112B",
                                   "minValue": "0",
                                   "maxValue": "1000000000",
                                   "bindable": "itemQuantity",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total",
                                   "fieldId": "C28BC556-E38C-4B6B-9CDE-B98176C76030",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "subTotal",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "userId",
                                   "itemId": "userId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "User",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shopping1.shopping1.shared.com.model.aaaboundedcontext.authentication.UserModel"
                                   },
                                   "fieldLabel": "User",
                                   "fieldId": "F1E3F1CA-43AD-4033-8688-D12A4C1BA910",
                                   "restURL": "User",
                                   "bindable": "userId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "68D4ED32-20A7-4DFE-BCFF-D5C1A037D820",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Cart",
                    "title": "Details Grid",
                    "name": "CartGrid",
                    "itemId": "CartGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Cart Id",
                         "dataIndex": "cartId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Item Id",
                         "dataIndex": "itemId",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Quantity",
                         "dataIndex": "itemQuantity",
                         "flex": 1
                    }, {
                         "header": "Sub Total",
                         "dataIndex": "subTotal",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "userId",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Cart",
               "name": "Cart",
               "itemId": "CartForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "cartId",
                              "itemId": "cartId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Cart Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Cart Id<font color='red'> *<\/font>",
                              "fieldId": "3237A1A5-899D-4F69-9B8F-80A6207CD3F1",
                              "hidden": true,
                              "value": "",
                              "bindable": "cartId"
                         }, {
                              "name": "itemId",
                              "itemId": "itemId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Item Id",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Item Id<font color='red'> *<\/font>",
                              "fieldId": "D9217757-930D-4F6F-8CF3-C75F4A4B3F5E",
                              "restURL": "Item",
                              "bindable": "itemId",
                              "columnWidth": 0.5
                         }, {
                              "name": "itemPrice",
                              "itemId": "itemPrice",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Price",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Price",
                              "fieldId": "5806F5AE-B19C-48B2-81D6-4573DC3E404D",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "itemPrice",
                              "columnWidth": 0.5
                         }, {
                              "name": "itemQuantity",
                              "itemId": "itemQuantity",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Quantity",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Quantity<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B38EBEB0-5612-4B48-9512-5FCD8E09112B",
                              "minValue": "0",
                              "maxValue": "1000000000",
                              "bindable": "itemQuantity",
                              "columnWidth": 0.5
                         }, {
                              "name": "subTotal",
                              "itemId": "subTotal",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sub Total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sub Total",
                              "fieldId": "C28BC556-E38C-4B6B-9CDE-B98176C76030",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "subTotal",
                              "columnWidth": 0.5
                         }, {
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "User",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shopping1.shopping1.shared.com.model.aaaboundedcontext.authentication.UserModel"
                              },
                              "fieldLabel": "User",
                              "fieldId": "F1E3F1CA-43AD-4033-8688-D12A4C1BA910",
                              "restURL": "User",
                              "bindable": "userId",
                              "columnWidth": 0.5
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "68D4ED32-20A7-4DFE-BCFF-D5C1A037D820",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});