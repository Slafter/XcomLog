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
	
	public static final int ROOKIE = 0;
	public static final int SPECIALIST = 1;
	public static final int LANCE_CORPORAL = 2;
	public static final int CORPORAL = 3;
	public static final int SERGEANT = 4;
	public static final int TECH_SERGEANT = 5;
	public static final int GUNNERY_SERGEANT = 6;
	public static final int MASTER_SERGEANT = 7;
	
	public static final int WOUNDED = 				0;
	public static final int GRAVELY_WOUNDED = 		1;
	public static final int CRITICALLY_WOUNDED = 	2;
	
	public static final int NON_OFFICER = 		-1;
	public static final int LIEUTENANT = 		0;
	public static final int CAPTAIN = 			1;
	public static final int MAJOR = 			2;
	public static final int COLONEL = 			3;
	public static final int FIELD_COMMANDER = 	4;
	
	private Calendar dateRecruited;
	private String name;
	private static int numberOfSoldiers = 0;
	private int soldierId;
	private int specialization;
	private int baseHp;
	private int baseMobility;
	private int baseWill;
	private int baseAim;
	private int defense; // only changes with MEC conversion
	private boolean isOfficer = false;
	private int officerRank = NON_OFFICER;
	private boolean isPsion;
	private boolean isMec;
	private boolean isGeneMod;
	
	private int[][] operationHistory = new int[10][6];
	// operationId, change in (rank, hp, mobility, will, aim, woundedStatus, daysOut)
	

	Soldier (Calendar dateRecruited, String name, int hp, int mobility, int will, int aim, int defense) {
		this.dateRecruited = dateRecruited;
		this.name = name;
		this.baseHp = hp;
		this.baseMobility = mobility;
		this.baseWill = will;
		this.baseAim = aim;
		this.defense = defense;
		soldierId = numberOfSoldiers;
		numberOfSoldiers++;
	}
	
	
	// no rank up
	public void addOperation (int operationId, int kills) {
		// TODO
	}
	
	// initial rank up
	public void addOperation (int operationId, int kills, int specialization, 
					int hp, int mobility, int will, int aim) {
		// TODO	
	}
	
	// generic rank up
	public void addOperation (int operationId, int kills, int hp, int mobility, int will, int aim) {
		// TODO
	}
	
	// no rank up
	public void addOperationWounded (int operationId, int kills, int woundedStatus, int daysOut) {
		// TODO
	}
	
	// initial rank up
	public void addOperationWounded (int operationId, int kills, int specialization, 
			int hp, int mobility, int will, int aim, int woundedStatus, int daysOut) {
		// TODO
	}
	
	// generic rank up
	public void addOperationWounded (int operationId, int kills, int hp, int mobility, 
			int will, int aim, int woundedStatus, int daysOut) {
		// TODO
	}
	
	
	
	
	// TODO getters and setters
}
