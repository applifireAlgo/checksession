Ext.define('Shopping1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Shopping1.view.reportui.querycriteria.QueryCriteriaView',
			'Shopping1.view.reportui.datachart.DataChartViewTab',
			'Shopping1.view.reportui.datachart.DataChartViewPanel',
			'Shopping1.view.reportui.ReportViewController' ,
			'Shopping1.view.fw.MainDataPointPanel',
			'Shopping1.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
