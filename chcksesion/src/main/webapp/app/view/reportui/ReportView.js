Ext.define('Chcksesion.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Chcksesion.view.reportui.querycriteria.QueryCriteriaView',
			'Chcksesion.view.reportui.datachart.DataChartViewTab',
			'Chcksesion.view.reportui.datachart.DataChartViewPanel',
			'Chcksesion.view.reportui.ReportViewController' ,
			'Chcksesion.view.fw.MainDataPointPanel',
			'Chcksesion.view.googlemaps.map.MapPanel'
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
