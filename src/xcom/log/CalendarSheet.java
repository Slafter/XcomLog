package xcom.log;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarSheet {
	
	public static final int MAX_CALENDAR_DAYS = 1500;
	private static final Calendar startDate = new GregorianCalendar(2015, 3, 1);
	private static final long millisecondsPerDay = 86400000;
	
	private CalendarDay[] calendar = new CalendarDay[MAX_CALENDAR_DAYS];
	
	CalendarSheet() {
		for (int i = 0; i < MAX_CALENDAR_DAYS; i++) {
			calendar[i] = new CalendarDay();
		}
	}
	
	public void addEvent(Event event, int index) {
		calendar[index].addEvent(event);
	}
	
	public void addEvent(Event event, Calendar date) {
		int index;
	
		index = convertCalendarToArrayIndex(date);
		addEvent(event, (int)index);
	}
	
	public Event getEvent(int day, int index) {
		return calendar[day].getEventAtIndex(index);
	}
	
	public Event getEvent(Calendar day, int index) {
		return getEvent(convertCalendarToArrayIndex(day), index);
	}
	
	private int convertCalendarToArrayIndex(Calendar calendar) {
		long index = 0;
		long milliseconds;
		
		milliseconds = calendar.getTimeInMillis() - startDate.getTimeInMillis();
		index = milliseconds / millisecondsPerDay;
		
		return (int)index;
	}
}
