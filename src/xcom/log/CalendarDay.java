package xcom.log;

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
}
