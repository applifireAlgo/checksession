Ext.define('Shopping1.view.databrowsercalendar.DBCalendar', {
	extend : 'Shopping1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Shopping1.view.databrowsercalendar.DBCalendarController',
	             'Shopping1.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
