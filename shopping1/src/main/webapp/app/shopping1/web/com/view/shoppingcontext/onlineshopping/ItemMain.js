Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemModel", "Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.ItemMainController", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ProductModel", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CategoryModel", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.BrandModel", "Shopping1.view.fw.component.FileUploadComponent", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.ItemViewModel"],
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
               "displayName": "Item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
               "restURL": "/Item",
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
                    "itemId": "ItemTree",
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
                         "fieldId": "21AB5A68-6433-4C0E-BE0F-886E2040EF06",
                         "restURL": "Product",
                         "bindable": "productId"
                    }, {
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CategoryModel"
                         },
                         "fieldLabel": "Category",
                         "fieldId": "82C8081F-2067-45B5-B9DD-6EC63958953F",
                         "restURL": "Category",
                         "bindable": "categoryId"
                    }, {
                         "name": "brandId",
                         "itemId": "brandId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.BrandModel"
                         },
                         "fieldLabel": "Brand",
                         "fieldId": "EEFCE171-3F00-4A1C-B028-B70576C8A546",
                         "restURL": "Brand",
                         "bindable": "brandId"
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item",
                         "fieldId": "FA0A1D96-BA2C-4CEA-B50C-5F1CCEAD395A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "itemName"
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price",
                         "fieldId": "18D63B5A-53FB-4481-9D1D-7183A3AF1942",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "itemPrice"
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock",
                         "fieldId": "AF645072-06B1-487C-ADC0-CAA5F6C38F78",
                         "minValue": "0",
                         "maxValue": "1000000000",
                         "bindable": "itemStock"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "F33519CD-90C5-4F1B-9650-43B4F0AF5005",
                         "bindable": "itemIcon"
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
                    "displayName": "Item",
                    "title": "Item",
                    "name": "Item",
                    "itemId": "ItemForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item Id<font color='red'> *<\/font>",
                         "fieldId": "7D3F068D-5840-4B00-8F6D-1709DE29EAFD",
                         "hidden": true,
                         "value": "",
                         "bindable": "itemId"
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
                         "fieldId": "21AB5A68-6433-4C0E-BE0F-886E2040EF06",
                         "restURL": "Product",
                         "bindable": "productId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onProductIdChange"
                         }
                    }, {
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CategoryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "fieldId": "82C8081F-2067-45B5-B9DD-6EC63958953F",
                         "restURL": "Category",
                         "bindable": "categoryId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCategoryIdChange"
                         }
                    }, {
                         "name": "brandId",
                         "itemId": "brandId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.BrandModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "fieldId": "EEFCE171-3F00-4A1C-B028-B70576C8A546",
                         "restURL": "Brand",
                         "bindable": "brandId",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FA0A1D96-BA2C-4CEA-B50C-5F1CCEAD395A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "itemName",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "18D63B5A-53FB-4481-9D1D-7183A3AF1942",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "itemPrice",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AF645072-06B1-487C-ADC0-CAA5F6C38F78",
                         "minValue": "0",
                         "maxValue": "1000000000",
                         "bindable": "itemStock",
                         "columnWidth": 0.5
                    }, {
                         "items": [{
                              "name": "filePathHidden",
                              "xtype": "hidden",
                              "itemId": "filePathHidden"
                         }, {
                              "name": "itemIcon",
                              "itemId": "itemIcon",
                              "xtype": "fileupload",
                              "customWidgetType": "vdFileUpload",
                              "displayName": "Icon",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Icon<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F33519CD-90C5-4F1B-9650-43B4F0AF5005",
                              "bindable": "itemIcon",
                              "columnWidth": 0.5
                         }]
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "6E0CF14D-E5CB-44F0-AC77-99C5FFD9584A",
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
                         "customId": 439,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 439,
                              "customId": 561
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 439,
                              "customId": 562,
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
                              "parentId": 439,
                              "customId": 563,
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
                    "displayName": "Item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "restURL": "/Item",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Item Id",
                         "dataIndex": "itemId",
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
                         "dataIndex": "categoryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brandId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Item",
                         "dataIndex": "itemName",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Stock",
                         "dataIndex": "itemStock",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "itemIcon",
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
               "displayName": "Item",
               "title": "Item",
               "name": "Item",
               "itemId": "ItemForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "itemId",
                    "itemId": "itemId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item Id<font color='red'> *<\/font>",
                    "fieldId": "7D3F068D-5840-4B00-8F6D-1709DE29EAFD",
                    "hidden": true,
                    "value": "",
                    "bindable": "itemId"
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
                    "fieldId": "21AB5A68-6433-4C0E-BE0F-886E2040EF06",
                    "restURL": "Product",
                    "bindable": "productId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onProductIdChange"
                    }
               }, {
                    "name": "categoryId",
                    "itemId": "categoryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.CategoryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Category<font color='red'> *<\/font>",
                    "fieldId": "82C8081F-2067-45B5-B9DD-6EC63958953F",
                    "restURL": "Category",
                    "bindable": "categoryId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCategoryIdChange"
                    }
               }, {
                    "name": "brandId",
                    "itemId": "brandId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Brand",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.BrandModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Brand<font color='red'> *<\/font>",
                    "fieldId": "EEFCE171-3F00-4A1C-B028-B70576C8A546",
                    "restURL": "Brand",
                    "bindable": "brandId",
                    "columnWidth": 0.5
               }, {
                    "name": "itemName",
                    "itemId": "itemName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FA0A1D96-BA2C-4CEA-B50C-5F1CCEAD395A",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "itemName",
                    "columnWidth": 0.5
               }, {
                    "name": "itemPrice",
                    "itemId": "itemPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Price<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "18D63B5A-53FB-4481-9D1D-7183A3AF1942",
                    "minValue": "0",
                    "maxValue": "10000000",
                    "bindable": "itemPrice",
                    "columnWidth": 0.5
               }, {
                    "name": "itemStock",
                    "itemId": "itemStock",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Stock",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Stock<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AF645072-06B1-487C-ADC0-CAA5F6C38F78",
                    "minValue": "0",
                    "maxValue": "1000000000",
                    "bindable": "itemStock",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F33519CD-90C5-4F1B-9650-43B4F0AF5005",
                         "bindable": "itemIcon",
                         "columnWidth": 0.5
                    }]
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "6E0CF14D-E5CB-44F0-AC77-99C5FFD9584A",
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
                    "customId": 439,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 439,
                         "customId": 561
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 439,
                         "customId": 562,
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
                         "parentId": 439,
                         "customId": 563,
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