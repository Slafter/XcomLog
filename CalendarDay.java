package xcom.log;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class CalendarDay {

	public static final int MAX_EVENTS_PER_DAY = 20; 
	
	private Event[] events = new Event[MAX_EVENTS_PER_DAY];
	
	CalendarDay () {
		for (int i = 0; i < MAX_EVENTS_PER_DAY; i++) {
			events[i] = null;
		}
	}
	
	public void addEvent (Event newEvent) {
		events[getNextEmptyIndex()] = newEvent;
	}
	
	public Event getEventAtIndex (int index) {
		if  (events[index] != null)
			return events[index];
		else
			return null;
	}

	private int getNextEmptyIndex() {
		int i = 0;
		
		while (events[i] != null && i < MAX_EVENTS_PER_DAY) {
				i++;
		}
		
		return i;
	}
	
	public static void main(String args[]) {
	Calendar myCalendar = new GregorianCalendar();
		
		System.out.println(myCalendar.getTime().toString());

		myCalendar.clear();
		myCalendar.set(2015, 2, 12);
		System.out.println(myCalendar.getTime());
		System.out.println(myCalendar.get(Calendar.MONTH));
		
		Date myDate = new Date();
		
		System.out.println(myDate.toString());
		
		
	}

}
