Ext.define('Chcksesion.chcksesion.web.com.view.organizationboundedcontext.location.CityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CityMainController",
     "restURL": "/City",
     "defaults": {
          "split": true
     },
     "requires": ["Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.CityModel", "Chcksesion.chcksesion.web.com.controller.organizationboundedcontext.location.CityMainController", "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.CountryModel", "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.StateModel", "Chcksesion.chcksesion.shared.com.viewmodel.organizationboundedcontext.location.CityViewModel"],
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
               "displayName": "City",
               "name": "CityTreeContainer",
               "itemId": "CityTreeContainer",
               "restURL": "/City",
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
                    "itemId": "CityTree",
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
                    "items": []
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
                    "displayName": "City",
                    "title": "City",
                    "name": "City",
                    "itemId": "CityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cityId",
                         "itemId": "cityId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Id<font color='red'> *<\/font>",
                         "fieldId": "2F23089B-714E-4D47-B579-A09A59ABE8C0",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "cityId"
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
                              "model": "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "fieldId": "0AF66EAA-6A44-4F06-9A69-E8A0A950E22C",
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
                              "model": "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "fieldId": "42668356-32F0-494D-B7EB-8CCD026E65C9",
                         "restURL": "State",
                         "bindable": "stateId",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityName",
                         "itemId": "cityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "97E62BD9-0599-4854-B8CB-207F64A5B1F4",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "cityName",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCodeChar2",
                         "itemId": "cityCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "69667638-C513-47ED-AA85-33B9FD284E7D",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "cityCodeChar2",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCode",
                         "itemId": "cityCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Code1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "70DF1F0D-6240-41DC-BC74-DC979D40ED79",
                         "minValue": "0",
                         "maxValue": "3",
                         "bindable": "cityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityDescription",
                         "itemId": "cityDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "City Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Description",
                         "fieldId": "F6870977-6F1F-45EF-BB21-CA7C2EC1E6D7",
                         "bindable": "cityDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityFlag",
                         "itemId": "cityFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "2BC378DC-E39F-4720-BB61-46A96D3194E2",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "cityFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLatitude",
                         "itemId": "cityLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Latitude",
                         "fieldId": "86C522A5-1348-4515-948B-543F34D16EBF",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLongitude",
                         "itemId": "cityLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Longitude",
                         "fieldId": "1664FFC5-323F-473B-AB50-BEAAF6EF963A",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLongitude",
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
                         "fieldId": "9D4C40EE-E6F9-4298-BEB9-EB509DCEC1F1",
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
                         "customId": 446,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 446,
                              "customId": 706
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 446,
                              "customId": 707,
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
                              "parentId": 446,
                              "customId": 708,
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
                    "displayName": "City",
                    "title": "Details Grid",
                    "name": "CityGrid",
                    "itemId": "CityGrid",
                    "restURL": "/City",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "City Id",
                         "dataIndex": "cityId",
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
                         "header": "City Name",
                         "dataIndex": "cityName",
                         "flex": 1
                    }, {
                         "header": "City Code",
                         "dataIndex": "cityCodeChar2",
                         "flex": 1
                    }, {
                         "header": "City Code1",
                         "dataIndex": "cityCode",
                         "flex": 1
                    }, {
                         "header": "City Description",
                         "dataIndex": "cityDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "cityFlag",
                         "flex": 1
                    }, {
                         "header": "City Latitude",
                         "dataIndex": "cityLatitude",
                         "flex": 1
                    }, {
                         "header": "City Longitude",
                         "dataIndex": "cityLongitude",
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
               "displayName": "City",
               "title": "City",
               "name": "City",
               "itemId": "CityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "cityId",
                    "itemId": "cityId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Id<font color='red'> *<\/font>",
                    "fieldId": "2F23089B-714E-4D47-B579-A09A59ABE8C0",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "cityId"
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
                         "model": "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "fieldId": "0AF66EAA-6A44-4F06-9A69-E8A0A950E22C",
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
                         "model": "Chcksesion.chcksesion.shared.com.model.organizationboundedcontext.location.StateModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "fieldId": "42668356-32F0-494D-B7EB-8CCD026E65C9",
                    "restURL": "State",
                    "bindable": "stateId",
                    "columnWidth": 0.5
               }, {
                    "name": "cityName",
                    "itemId": "cityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "97E62BD9-0599-4854-B8CB-207F64A5B1F4",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "cityName",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCodeChar2",
                    "itemId": "cityCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "69667638-C513-47ED-AA85-33B9FD284E7D",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "cityCodeChar2",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCode",
                    "itemId": "cityCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Code1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "70DF1F0D-6240-41DC-BC74-DC979D40ED79",
                    "minValue": "0",
                    "maxValue": "3",
                    "bindable": "cityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "cityDescription",
                    "itemId": "cityDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "City Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Description",
                    "fieldId": "F6870977-6F1F-45EF-BB21-CA7C2EC1E6D7",
                    "bindable": "cityDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "cityFlag",
                    "itemId": "cityFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "2BC378DC-E39F-4720-BB61-46A96D3194E2",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "cityFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLatitude",
                    "itemId": "cityLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Latitude",
                    "fieldId": "86C522A5-1348-4515-948B-543F34D16EBF",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLongitude",
                    "itemId": "cityLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Longitude",
                    "fieldId": "1664FFC5-323F-473B-AB50-BEAAF6EF963A",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLongitude",
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
                    "fieldId": "9D4C40EE-E6F9-4298-BEB9-EB509DCEC1F1",
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
                    "customId": 446,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 446,
                         "customId": 706
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 446,
                         "customId": 707,
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
                         "parentId": 446,
                         "customId": 708,
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