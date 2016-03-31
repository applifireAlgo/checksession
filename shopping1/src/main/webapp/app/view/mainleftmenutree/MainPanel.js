Ext.define('Shopping1.view.mainleftmenutree.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithLeftMenu',
	requires : [ 'Shopping1.view.resource.ResourcePanel',
	             'Shopping1.view.mainleftmenutree.TopPanel.TopPanel',
	             'Shopping1.view.resource.DockedResourcePanel',
	             'Shopping1.view.fw.mainViewPanel.MainPanelController'
	           ],
	controller:'mainViewPanelController',
	layout : 'border',
	items : [{
		    	region: 'west',
		        xtype: 'resourcePanel',
				placeholder : {
					xtype : 'dockedResourcePanel'
				},		
				placeholderCollapseHideMode : Ext.Element.DISPLAY, 
				collapsible : true,
				hideCollapseTool : true,
				titleCollapse : true
				
			}, {
		        region: 'center',
		        xtype: 'tabpanel',
		        itemId : 'appMainTabPanel',
				id : 'appMainTabPanel',
		        dockedItems : [{
					xtype : 'menuTopPanel'
				}],
				listeners:{
					afterrender:'aftrAppMainTabPanelRender'
				}
			}],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
