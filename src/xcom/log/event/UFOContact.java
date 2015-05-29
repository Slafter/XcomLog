package xcom.log.event;


public class UFOContact extends Event {
	
	// UFO Types
	public static final int SCOUT = 			0;
	public static final int FIGHTER = 			1;
	public static final int RAIDER = 			2;
	public static final int DESTROYER = 		3;
	public static final int OVERSEER = 			4;
	public static final int ABDUCTOR = 			5;
	public static final int HARVESTER = 		6;
	public static final int TRANSPORT = 		7;
	public static final int TERROR_SHIP = 		8;
	public static final int BATTLESHIP = 		9;
	public static final int ASSAULT_CARRIER = 	10;
	public static final int UNIDENTIFIED_TYPE = 11;
	
	// UFO Sizes
	public static final int UNIDENTIFIED_SIZE =	0;
	public static final int SMALL = 			1;
	public static final int MEDIUM = 			2;
	public static final int LARGE = 			3;
	public static final int VERY_LARGE = 		4;
	
	// UFO Altitude
	public static final int NOE = 				0;
	public static final int LOW = 				1;
	public static final int HIGH = 				2;
	
	// Locations
	public static final int UNITED_STATES = 	0;
	public static final int CANADA = 			1;
	public static final int MEXICO = 			2;
	public static final int ARGENTINA = 		3;
	public static final int BRAZIL = 			4;
	public static final int EGYPT = 			5;
	public static final int SOUTH_AFRICA = 		6;
	public static final int NIGERIA = 			7;
	public static final int UNITED_KINGDOM = 	8;
	public static final int RUSSIA = 			9;
	public static final int FRANCE = 			10;
	public static final int GERMANY = 			11;
	public static final int CHINA = 			12;
	public static final int JAPAN = 			13;
	public static final int INDIA = 			14;
	public static final int AUSTRALIA = 		15;
	
	// Results
	public static final int CONTACT_LOST = 			0;
	public static final int DESTROYED = 			1;
	public static final int SHOT_DOWN = 			2;
	public static final int LANDED = 				3;
	public static final int SATELLITE_DESTROYED = 	4;
	public static final int ABDUCTION = 			5;
	public static final int TERROR_ATTACK = 		6;
	public static final int BASE_DEFENSE = 			7;
	public static final int INFILTRATION = 			8;
	public static final int HANGAR_DEFENSE = 		9;
	
	private static int numberOfContacts = 0;
	private int contactNumber;
	private int location;
	private int type;
	private int size;
	private int altitude;
	private int result;
	
	public UFOContact(int location, int type, int size, int altitude) {
		this.majorEvent = true;
		this.location = location;
		this.type = type;
		this.size = size;
		this.altitude = altitude;
		numberOfContacts++;
		contactNumber = numberOfContacts;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getType() {
		return type;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getAltitude() {
		return altitude;
	}
	
	public int getResult() {
		return result;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}
	
}
