package xcom.log;

import java.util.Date;

public class CalendarSheet {
	
	public static final int MAX_CALENDAR_DAYS = 1500;
	
	private CalendarDay[] calendar = new CalendarDay[MAX_CALENDAR_DAYS];
	
	CalendarSheet() {
		for (int i = 0; i < MAX_CALENDAR_DAYS; i++) {
			calendar[i] = new CalendarDay();
		}
	}
	
	public void addEventAtDay(Event event, int day) {
		calendar[day].addEvent(event);
	}
	
	public Event getEvent(int day, int index) {
		return calendar[day].getEventAtIndex(index);
	}
	
	private int convertDateToCalendarIndex(Date date) {
		// TODO
		return 0;
	}
	
}
