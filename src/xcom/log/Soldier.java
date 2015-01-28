package xcom.log;

import java.util.Calendar;

public class Soldier {
	
	public static final int ASSAULT =	0;
	public static final int INFANTRY = 	1;
	public static final int ROCKETEER =	2;
	public static final int GUNNER = 	3;
	public static final int SNIPER = 	4;
	public static final int SCOUT = 	5;
	public static final int MEDIC = 	6;
	public static final int	ENGINEER = 	7;
	
	public static final int MAX_RANK = 			7;
	public static final int NUM_GROWTH_STATS = 	4;
	
	public static final int LIEUTENANT = 		0;
	public static final int CAPTAIN = 			1;
	public static final int MAJOR = 			2;
	public static final int COLONEL = 			3;
	public static final int FIELD_COMMANDER = 	4;
	
	private Calendar dateRecruited;
	private String name;
	private int specialization;
	private int baseHp;
	private int baseMobility;
	private int baseWill;
	private int baseAim;
	private int defense; // only changes with MEC conversion
	private boolean isOfficer;
	private int officerRank;
	private boolean isPsion;
	private boolean isMec;
	private boolean isGeneMod;
	
	private int[][] statGrowth = new int[MAX_RANK][NUM_GROWTH_STATS]; 
	// TODO need to increase array length for each critical wound
	
	
	Soldier () {
		
	}
	
	// TODO getters and setters
}
