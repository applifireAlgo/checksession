Ext.define('Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.OrderProcessingController', {
     extend: 'Shopping1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.OrderProcessingController',
     onMakePaymentClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#aggbedi'), this.view.down('#piobfmi'), this.view.down('#ppeefii'), this.view.down('#blnapki'), this.view.down('#abpoeoi'), this.view.down('#ahodfhi'), this.view.down('#oladidi')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.amount = this.view.down('#aggbedi').getValue();
          jsonData.ccHolderName = this.view.down('#piobfmi').getValue();
          jsonData.creditCardNo = this.view.down('#ppeefii').getValue();
          jsonData.customerId = this.view.down('#blnapki').getValue();
          jsonData.cvvNo = this.view.down('#abpoeoi').getValue();
          jsonData.expiryMonth = this.view.down('#ahodfhi').getValue();
          jsonData.expiryYear = this.view.down('#oladidi').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/OrderProcessingServiceWS/processOrder',
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