Ext.define('Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.ItemTemplateController', {
     extend: 'Shopping1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.ItemTemplateController',
     onAddToCartClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#gedmkhi'), this.view.down('#diohjai')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.itemId = this.view.down('#gedmkhi').getValue();
          jsonData.itemQuantity = this.view.down('#diohjai').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Cart/',
               async: false,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {} else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     }
});