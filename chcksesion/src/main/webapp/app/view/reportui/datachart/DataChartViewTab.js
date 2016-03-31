Ext.define('Chcksesion.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Chcksesion.view.reportui.datachart.DataChartTController',
	             'Chcksesion.view.reportui.datachart.datagrid.DataGridView',
	             'Chcksesion.view.reportui.datachart.chart.ChartTabView',
	             'Chcksesion.view.reportui.datachart.ChartPointView' ],
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