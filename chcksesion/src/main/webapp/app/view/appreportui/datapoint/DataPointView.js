Ext.define('Chcksesion.view.appreportui.datapoint.DataPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Chcksesion.view.appreportui.datapoint.DataPointViewController',
	          'Chcksesion.view.fw.DataPointPanel'],
	controller : 'datapointController',
	xtype:'dataPointView',
	itemId:'dataPointViewId',
	items : [ {
		xtype : "tabbar",
		rotation : "top",
		itemId : 'maindatapointpanel',
		tabRotation : 0,
		adjustTabPositions : function() {
		}
	} ],
	listeners : {
		scope:'controller',
		resize:'onResizeDataPointView'
	}
});
