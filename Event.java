package xcom.log;

public abstract class Event {
	
	protected boolean majorEvent = false; // Defaults as a minor event (non-major)
	
	Event() {
		
	}

	public boolean isMajorEvent() {
		return majorEvent;
	}
	
}
