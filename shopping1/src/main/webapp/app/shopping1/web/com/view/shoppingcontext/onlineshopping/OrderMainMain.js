Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.OrderMainMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "OrderMainMainController",
     "restURL": "/OrderMain",
     "defaults": {
          "split": true
     },
     "requires": ["Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.OrderMainModel", "Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.OrderMainMainController", "Shopping1.shopping1.shared.com.model.aaaboundedcontext.authentication.UserModel", "Shopping1.view.fw.component.Grids", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.OrderMainViewModel"],
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
               "displayName": "OrderMain",
               "name": "OrderMainTreeContainer",
               "itemId": "OrderMainTreeContainer",
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
                    "itemId": "OrderMainTree",
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
                         "name": "orderDate",
                         "itemId": "orderDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Date",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Date",
                         "fieldId": "74076967-CD01-4CDF-B054-BC6E4563D3C2",
                         "bindable": "orderDate"
                    }, {
                         "name": "grandTotal",
                         "itemId": "grandTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Grand Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grand Total",
                         "fieldId": "E124A059-82AD-4531-B26B-ED18BDED5F23",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "grandTotal"
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
                         "fieldId": "A0205B5A-0D43-48CE-97B7-39CEC5657200",
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
                    "displayName": "OrderMain",
                    "name": "OrderMain",
                    "itemId": "OrderMainForm",
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
                                   "name": "orderId",
                                   "itemId": "orderId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Order Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Order Id<font color='red'> *<\/font>",
                                   "fieldId": "04BF3468-3A4C-429A-93F4-433C1A6F6A92",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "orderId"
                              }, {
                                   "name": "orderDate",
                                   "itemId": "orderDate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Date",
                                   "fieldId": "74076967-CD01-4CDF-B054-BC6E4563D3C2",
                                   "bindable": "orderDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "grandTotal",
                                   "itemId": "grandTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Grand Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Grand Total",
                                   "fieldId": "E124A059-82AD-4531-B26B-ED18BDED5F23",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "grandTotal",
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
                                   "fieldId": "A0205B5A-0D43-48CE-97B7-39CEC5657200",
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
                                   "fieldId": "C5F90693-09C5-4375-A795-3A3303778188",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "OrderDetails",
                         "title": "OrderDetails",
                         "name": "OrderDetails",
                         "itemId": "OrderDetailsForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
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
                                        "name": "orderItemId",
                                        "itemId": "orderItemId",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "OrderItem Id",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "OrderItem Id<font color='red'> *<\/font>",
                                        "fieldId": "7092C215-940A-49DD-9C97-3A0CBC91391E",
                                        "hidden": true,
                                        "value": "",
                                        "bindable": "orderDetails.orderItemId"
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
                                        "fieldId": "9072297E-0F3F-4D05-BBEE-6DD42AA6C458",
                                        "restURL": "Item",
                                        "bindable": "orderDetails.itemId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "itemPrice",
                                        "itemId": "itemPrice",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Price",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Price",
                                        "fieldId": "EF2DB186-F9C3-4601-A173-8C3432F8390B",
                                        "minValue": "0",
                                        "maxValue": "10000000",
                                        "bindable": "orderDetails.itemPrice",
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
                                        "fieldId": "B0F1EDA3-6EB7-4509-B3EB-CDA18E6587AF",
                                        "minValue": "0",
                                        "maxValue": "1000000000",
                                        "bindable": "orderDetails.itemQuantity",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "subTotal",
                                        "itemId": "subTotal",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Sub Total",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "32BAC753-DBD2-403D-A1DB-0056B6AE144E",
                                        "minValue": "0",
                                        "maxValue": "10000000",
                                        "bindable": "orderDetails.subTotal",
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
                                        "fieldId": "ECFA4DDB-6963-4AB5-A7A9-B447A377CF7E",
                                        "bindable": "orderDetails.versionId",
                                        "hidden": true
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 187,
                              "text": "Add OrderDetails",
                              "handler": "addOrderDetails"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "OrderDetails",
                              "columnWidth": 1,
                              "itemId": "OrderDetailsGrid",
                              "fieldLabel": "List",
                              "bindLevel": "orderDetails",
                              "bindable": "orderDetails",
                              "listeners": {
                                   "select": "onOrderDetailsGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "OrderItem Id",
                                   "text": "OrderItem Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "orderItemId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Item Id",
                                   "text": "Item Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Price",
                                   "text": "Price",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemPrice",
                                   "flex": 1
                              }, {
                                   "header": "Quantity",
                                   "text": "Quantity",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemQuantity",
                                   "flex": 1
                              }, {
                                   "header": "Sub Total",
                                   "text": "Sub Total",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "subTotal",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
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
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "OrderMain",
                    "title": "Details Grid",
                    "name": "OrderMainGrid",
                    "itemId": "OrderMainGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Order Id",
                         "dataIndex": "orderId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Date",
                         "dataIndex": "orderDate",
                         "flex": 1
                    }, {
                         "header": "Grand Total",
                         "dataIndex": "grandTotal",
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
               "displayName": "OrderMain",
               "name": "OrderMain",
               "itemId": "OrderMainForm",
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
                              "name": "orderId",
                              "itemId": "orderId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Order Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Order Id<font color='red'> *<\/font>",
                              "fieldId": "04BF3468-3A4C-429A-93F4-433C1A6F6A92",
                              "hidden": true,
                              "value": "",
                              "bindable": "orderId"
                         }, {
                              "name": "orderDate",
                              "itemId": "orderDate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Date",
                              "fieldId": "74076967-CD01-4CDF-B054-BC6E4563D3C2",
                              "bindable": "orderDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "grandTotal",
                              "itemId": "grandTotal",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Grand Total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Grand Total",
                              "fieldId": "E124A059-82AD-4531-B26B-ED18BDED5F23",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "grandTotal",
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
                              "fieldId": "A0205B5A-0D43-48CE-97B7-39CEC5657200",
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
                              "fieldId": "C5F90693-09C5-4375-A795-3A3303778188",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "OrderDetails",
                    "title": "OrderDetails",
                    "name": "OrderDetails",
                    "itemId": "OrderDetailsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
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
                                   "name": "orderItemId",
                                   "itemId": "orderItemId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "OrderItem Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "OrderItem Id<font color='red'> *<\/font>",
                                   "fieldId": "7092C215-940A-49DD-9C97-3A0CBC91391E",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "orderDetails.orderItemId"
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
                                   "fieldId": "9072297E-0F3F-4D05-BBEE-6DD42AA6C458",
                                   "restURL": "Item",
                                   "bindable": "orderDetails.itemId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "itemPrice",
                                   "itemId": "itemPrice",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price",
                                   "fieldId": "EF2DB186-F9C3-4601-A173-8C3432F8390B",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "orderDetails.itemPrice",
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
                                   "fieldId": "B0F1EDA3-6EB7-4509-B3EB-CDA18E6587AF",
                                   "minValue": "0",
                                   "maxValue": "1000000000",
                                   "bindable": "orderDetails.itemQuantity",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "32BAC753-DBD2-403D-A1DB-0056B6AE144E",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "orderDetails.subTotal",
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
                                   "fieldId": "ECFA4DDB-6963-4AB5-A7A9-B447A377CF7E",
                                   "bindable": "orderDetails.versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 187,
                         "text": "Add OrderDetails",
                         "handler": "addOrderDetails"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "OrderDetails",
                         "columnWidth": 1,
                         "itemId": "OrderDetailsGrid",
                         "fieldLabel": "List",
                         "bindLevel": "orderDetails",
                         "bindable": "orderDetails",
                         "listeners": {
                              "select": "onOrderDetailsGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "OrderItem Id",
                              "text": "OrderItem Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "orderItemId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Item Id",
                              "text": "Item Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Price",
                              "text": "Price",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemPrice",
                              "flex": 1
                         }, {
                              "header": "Quantity",
                              "text": "Quantity",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemQuantity",
                              "flex": 1
                         }, {
                              "header": "Sub Total",
                              "text": "Sub Total",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "subTotal",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
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
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});