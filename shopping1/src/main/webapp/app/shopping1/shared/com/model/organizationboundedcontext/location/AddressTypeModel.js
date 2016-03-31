Ext.define('Shopping1.shopping1.shared.com.model.organizationboundedcontext.location.AddressTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "addressTypeId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressTypeDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressTypeIcon",
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