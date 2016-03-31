Ext.define('Shopping1.shopping1.web.com.view.organizationboundedcontext.location.TalukaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TalukaMainController",
     "restURL": "/Taluka",
     "defaults": {
          "split": true
     },
     "requires": ["Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.TalukaModel", "Shopping1.shopping1.web.com.controller.organizationboundedcontext.location.TalukaMainController", "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.CountryModel", "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.StateModel", "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.RegionModel", "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.DistrictModel", "Shopping1.shopping1.shared.com.viewmodel.organizationboundedcontext.location.TalukaViewModel"],
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
               "displayName": "Taluka",
               "name": "TalukaTreeContainer",
               "itemId": "TalukaTreeContainer",
               "restURL": "/Taluka",
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
                    "itemId": "TalukaTree",
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
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "fieldLabel": "Country",
                         "fieldId": "D808E553-A499-403F-87B3-30DA83599646",
                         "restURL": "Country",
                         "bindable": "countryId"
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "fieldLabel": "State",
                         "fieldId": "BA602A13-5C81-4D07-965A-C5F1E9CC93BA",
                         "restURL": "State",
                         "bindable": "stateId"
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.RegionModel"
                         },
                         "fieldLabel": "Region",
                         "fieldId": "49EAE683-96A7-4350-A2ED-6ABB3958BE9B",
                         "restURL": "Region",
                         "bindable": "regionId"
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.DistrictModel"
                         },
                         "fieldLabel": "District",
                         "fieldId": "A6B163D7-327D-4545-A09B-C7B8D588C7B1",
                         "restURL": "District",
                         "bindable": "districtId"
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name",
                         "fieldId": "12FA9869-D9D9-405E-8429-8AE7C979F08B",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "talukaName"
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code",
                         "fieldId": "0BADAD72-78AD-43E8-B061-88877E551810",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "talukaCode"
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
                    "displayName": "Taluka",
                    "title": "Taluka",
                    "name": "Taluka",
                    "itemId": "TalukaForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "talukaId",
                         "itemId": "talukaId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                         "fieldId": "2D3C13A5-DE7C-4CC4-952D-02DCE9EC21F9",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "talukaId"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "fieldId": "D808E553-A499-403F-87B3-30DA83599646",
                         "restURL": "Country",
                         "bindable": "countryId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "fieldId": "BA602A13-5C81-4D07-965A-C5F1E9CC93BA",
                         "restURL": "State",
                         "bindable": "stateId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.RegionModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "fieldId": "49EAE683-96A7-4350-A2ED-6ABB3958BE9B",
                         "restURL": "Region",
                         "bindable": "regionId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.DistrictModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "fieldId": "A6B163D7-327D-4545-A09B-C7B8D588C7B1",
                         "restURL": "District",
                         "bindable": "districtId",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "12FA9869-D9D9-405E-8429-8AE7C979F08B",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "talukaName",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0BADAD72-78AD-43E8-B061-88877E551810",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "talukaCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaDescription",
                         "itemId": "talukaDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "taluka Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Description",
                         "fieldId": "9F5B3E1D-402D-42F9-AF98-3850899F4BE1",
                         "bindable": "talukaDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaFlag",
                         "itemId": "talukaFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "0A46FF4F-26FD-4731-834E-892AD6A9416B",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "talukaFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLatitude",
                         "itemId": "talukaLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "talukaaLatitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaaLatitude",
                         "fieldId": "010D1151-EEB2-4BB0-95EB-0F2896505457",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLongitude",
                         "itemId": "talukaLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Citry Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Citry Longitude",
                         "fieldId": "0E146419-9C11-4C1D-A0F3-09E57B53DE67",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLongitude",
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
                         "fieldId": "88B50C1D-EA1D-4A83-A130-F4674B133BA1",
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
                         "customId": 284,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 284,
                              "customId": 584
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 284,
                              "customId": 585,
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
                              "parentId": 284,
                              "customId": 586,
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
                    "displayName": "Taluka",
                    "title": "Details Grid",
                    "name": "TalukaGrid",
                    "itemId": "TalukaGrid",
                    "restURL": "/Taluka",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "taluka Id",
                         "dataIndex": "talukaId",
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
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "taluka Name",
                         "dataIndex": "talukaName",
                         "flex": 1
                    }, {
                         "header": "taluka Code",
                         "dataIndex": "talukaCode",
                         "flex": 1
                    }, {
                         "header": "taluka Description",
                         "dataIndex": "talukaDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "talukaFlag",
                         "flex": 1
                    }, {
                         "header": "talukaaLatitude",
                         "dataIndex": "talukaLatitude",
                         "flex": 1
                    }, {
                         "header": "Citry Longitude",
                         "dataIndex": "talukaLongitude",
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
               "displayName": "Taluka",
               "title": "Taluka",
               "name": "Taluka",
               "itemId": "TalukaForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "talukaId",
                    "itemId": "talukaId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                    "fieldId": "2D3C13A5-DE7C-4CC4-952D-02DCE9EC21F9",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "talukaId"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "fieldId": "D808E553-A499-403F-87B3-30DA83599646",
                    "restURL": "Country",
                    "bindable": "countryId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.StateModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "fieldId": "BA602A13-5C81-4D07-965A-C5F1E9CC93BA",
                    "restURL": "State",
                    "bindable": "stateId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.RegionModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "fieldId": "49EAE683-96A7-4350-A2ED-6ABB3958BE9B",
                    "restURL": "Region",
                    "bindable": "regionId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.DistrictModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "fieldId": "A6B163D7-327D-4545-A09B-C7B8D588C7B1",
                    "restURL": "District",
                    "bindable": "districtId",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaName",
                    "itemId": "talukaName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "12FA9869-D9D9-405E-8429-8AE7C979F08B",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "talukaName",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaCode",
                    "itemId": "talukaCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0BADAD72-78AD-43E8-B061-88877E551810",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "talukaCode",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaDescription",
                    "itemId": "talukaDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "taluka Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Description",
                    "fieldId": "9F5B3E1D-402D-42F9-AF98-3850899F4BE1",
                    "bindable": "talukaDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaFlag",
                    "itemId": "talukaFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "0A46FF4F-26FD-4731-834E-892AD6A9416B",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "talukaFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLatitude",
                    "itemId": "talukaLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "talukaaLatitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaaLatitude",
                    "fieldId": "010D1151-EEB2-4BB0-95EB-0F2896505457",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLongitude",
                    "itemId": "talukaLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Citry Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Citry Longitude",
                    "fieldId": "0E146419-9C11-4C1D-A0F3-09E57B53DE67",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLongitude",
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
                    "fieldId": "88B50C1D-EA1D-4A83-A130-F4674B133BA1",
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
                    "customId": 284,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 284,
                         "customId": 584
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 284,
                         "customId": 585,
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
                         "parentId": 284,
                         "customId": 586,
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