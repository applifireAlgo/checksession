Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.CategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CategoryMainController",
     "restURL": "/Category",
     "defaults": {
          "split": true
     },
     "requires": ["Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CategoryModel", "Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.CategoryMainController", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ProductModel", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.CategoryViewModel"],
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
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Category",
               "name": "CategoryTreeContainer",
               "itemId": "CategoryTreeContainer",
               "restURL": "/Category",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CategoryTree",
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
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ProductModel"
                         },
                         "fieldLabel": "Product",
                         "fieldId": "F948848B-ADB6-4839-AF2F-250D2591992E",
                         "restURL": "Product",
                         "bindable": "productId"
                    }, {
                         "name": "categoryName",
                         "itemId": "categoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category",
                         "fieldId": "2C4C8ABC-A5AA-480B-BC16-6F8A35E9982A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "categoryName"
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
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Category",
                    "title": "Category",
                    "name": "Category",
                    "itemId": "CategoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category Id<font color='red'> *<\/font>",
                         "fieldId": "707F44B5-75BC-4EB3-9468-F206E32544A5",
                         "hidden": true,
                         "value": "",
                         "bindable": "categoryId"
                    }, {
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ProductModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "fieldId": "F948848B-ADB6-4839-AF2F-250D2591992E",
                         "restURL": "Product",
                         "bindable": "productId",
                         "columnWidth": 0.5
                    }, {
                         "name": "categoryName",
                         "itemId": "categoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2C4C8ABC-A5AA-480B-BC16-6F8A35E9982A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "categoryName",
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
                         "fieldId": "9FFFC51F-B68D-4E77-83E4-593367E71232",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 741,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 741,
                              "customId": 931
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 741,
                              "customId": 932,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 741,
                              "customId": 933,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Category",
                    "title": "Details Grid",
                    "name": "CategoryGrid",
                    "itemId": "CategoryGrid",
                    "restURL": "/Category",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Category Id",
                         "dataIndex": "categoryId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Product",
                         "dataIndex": "productId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "categoryName",
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
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Category",
               "title": "Category",
               "name": "Category",
               "itemId": "CategoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "categoryId",
                    "itemId": "categoryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Category Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category Id<font color='red'> *<\/font>",
                    "fieldId": "707F44B5-75BC-4EB3-9468-F206E32544A5",
                    "hidden": true,
                    "value": "",
                    "bindable": "categoryId"
               }, {
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ProductModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "fieldId": "F948848B-ADB6-4839-AF2F-250D2591992E",
                    "restURL": "Product",
                    "bindable": "productId",
                    "columnWidth": 0.5
               }, {
                    "name": "categoryName",
                    "itemId": "categoryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2C4C8ABC-A5AA-480B-BC16-6F8A35E9982A",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "categoryName",
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
                    "fieldId": "9FFFC51F-B68D-4E77-83E4-593367E71232",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 741,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 741,
                         "customId": 931
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 741,
                         "customId": 932,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 741,
                         "customId": 933,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});