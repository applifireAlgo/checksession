Ext.define('Chcksesion.chcksesion.shared.com.model.aaaboundedcontext.authentication.QuestionModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "questionId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelid",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "question",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "questionDetails",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "questionIcon",
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