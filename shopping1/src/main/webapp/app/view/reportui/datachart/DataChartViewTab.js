Ext.define('Shopping1.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Shopping1.view.reportui.datachart.DataChartTController',
	             'Shopping1.view.reportui.datachart.datagrid.DataGridView',
	             'Shopping1.view.reportui.datachart.chart.ChartTabView',
	             'Shopping1.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});