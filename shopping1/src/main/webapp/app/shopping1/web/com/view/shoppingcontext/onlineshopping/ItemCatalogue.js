Ext.define('Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.ItemCatalogue', {
     "xtype": "itemCatalogue",
     "name": "itemcatalogue",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "items",
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "A8A17935-8603-4C0D-BE29-8B3FE71383F5",
               "uiClass": "Shopping1.shopping1.web.com.view.shoppingcontext.onlineshopping.ItemTemplate",
               "uiType": 2,
               "url": "secure/FetchItemDetailsServiceWS/fetchItemDetails",
               "requestMethodType": "POST"
          },
          "title": "Items",
          "padding": 0,
          "margin": 5,
          "itemId": "gpijmgi",
          "dockedItems": []
     }],
     "border": true,
     "autoScroll": true,
     "title": "Item Catalogue",
     "margin": 5,
     "itemId": "fioboci",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Shopping1.shopping1.web.com.controller.shoppingcontext.onlineshopping.ItemCatalogueController", "Shopping1.shopping1.shared.com.viewmodel.shoppingcontext.onlineshopping.ItemCatalogueViewModel", "Shopping1.shopping1.shared.com.model.shoppingcontext.onlineshopping.ItemCatalogueModel", "Shopping1.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatalogueViewModel",
     "controller": "ItemCatalogueController"
});