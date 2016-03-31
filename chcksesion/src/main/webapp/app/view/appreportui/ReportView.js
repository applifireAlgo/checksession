Ext.define('Chcksesion.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Chcksesion.view.appreportui.ReportViewController',
	            'Chcksesion.view.appreportui.datagrid.DataGridPanel',
	            'Chcksesion.view.appreportui.datagrid.DataGridView',
	            'Chcksesion.view.appreportui.querycriteria.QueryCriteriaView',
	            'Chcksesion.view.appreportui.chart.ChartView',
	            'Chcksesion.view.appreportui.datapoint.DataPointView',
	            'Chcksesion.view.googlemaps.map.MapPanel',
	            'Chcksesion.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
