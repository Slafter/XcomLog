package xcom.log.event;


public class GlobeMission extends Event {
	
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
		
		// Activity Level
		public static final int NONE =				-1;
		public static final int LIGHT = 			0;
		public static final int MODERATE = 			1;
		public static final int HEAVY = 			2;
		public static final int SWARMING = 			3;
		
		/// Mission Type
		public static final int ABDUCTION = 		0;
		public static final int TERROR_ATTACK = 	1;
		public static final int COUNCIL_MISSION = 	2;
		public static final int BASE_DEFENSE = 		3;
		public static final int EXALT_MISSION = 	4;
		
		private int location;
		private int activity;
		private int reward;
		private int type;
		
		public GlobeMission(int type, int location, int activity, int reward) {
			this.type = type;
			this.location = location;
			
			if (type == ABDUCTION || type == COUNCIL_MISSION)
				this.activity = activity;
			else
				this.activity = -1;
			
			if (type == TERROR_ATTACK || type == BASE_DEFENSE)
				this.reward = 0;
			else
				this.reward = reward;
		}
		
		
		public int getType() {
			return type;
		}
		
		public int getLocation() {
			return location;
		}
		
		public int getActivity() {
			return activity;
		}
		
		public int getReward() {
			return reward;
		}
		
		public void setReward(int reward) {
			this.reward = reward;
		}
}
