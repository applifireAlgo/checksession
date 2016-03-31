Ext.define('Shopping1.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Shopping1.view.appreportui.ReportViewController',
	            'Shopping1.view.appreportui.datagrid.DataGridPanel',
	            'Shopping1.view.appreportui.datagrid.DataGridView',
	            'Shopping1.view.appreportui.querycriteria.QueryCriteriaView',
	            'Shopping1.view.appreportui.chart.ChartView',
	            'Shopping1.view.appreportui.datapoint.DataPointView',
	            'Shopping1.view.googlemaps.map.MapPanel',
	            'Shopping1.view.appreportui.chartpoint.ChartPointView'
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
