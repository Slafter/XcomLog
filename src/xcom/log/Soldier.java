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
	public static final int NO_SPEC =	8;
	
	public static final int ROOKIE = 				0;
	public static final int SPECIALIST = 			1;
	public static final int LANCE_CORPORAL = 		2;
	public static final int CORPORAL = 				3;
	public static final int SERGEANT = 				4;
	public static final int TECH_SERGEANT = 		5;
	public static final int GUNNERY_SERGEANT = 		6;
	public static final int MASTER_SERGEANT = 		7;
	
	public static final int NON_WOUNDED = 			-1;
	public static final int WOUNDED = 				0;
	public static final int GRAVELY_WOUNDED = 		1;
	public static final int CRITICALLY_WOUNDED = 	2;
	
	public static final int NON_OFFICER = 		-1;
	public static final int LIEUTENANT = 		0;
	public static final int CAPTAIN = 			1;
	public static final int MAJOR = 			2;
	public static final int COLONEL = 			3;
	public static final int FIELD_COMMANDER = 	4;
	
	private static final int OPERATION_ID = 	0; // for use with the operationHistory array
	private static final int KILLS = 			1;
	private static final int RANK = 			2;
	private static final int HP = 				3;
	private static final int MOBILITY = 		4;
	private static final int WILL = 			5;
	private static final int AIM = 				6;
	private static final int WOUNDED_STATUS = 	7;
	private static final int DAYS_OUT = 		8;
	
	private Calendar dateRecruited;
	private String name;
	private static int numberOfSoldiers = 0;
	private int soldierId;
	private int specialization = NO_SPEC;
	private int baseHp;
	private int baseMobility;
	private int baseWill;
	private int baseAim;
	private int defense; // only changes with MEC conversion
	private int officerRank = NON_OFFICER;
	private int numOperations = 0;
	private boolean isPsion;
	private boolean isMec;
	private boolean isGeneMod;
	
	private int[][] operationHistory = new int[1][9];
	// operationId, new (kills, rank, hp, mobility, will, aim, woundedStatus, daysOut)
	

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
	
	// includes specialization for the first rank up
	public void addOperation (int operationId, int kills, int rank, int specialization, 
			int hp, int mobility, int will, int aim, int woundedStatus, int daysOut) {
		if (numOperations == 0) {
			operationHistory[0][OPERATION_ID] = operationId;
			operationHistory[0][KILLS] = kills;
			operationHistory[0][RANK] = rank;
			operationHistory[0][HP] = hp;
			operationHistory[0][MOBILITY] = mobility;
			operationHistory[0][WILL] = will;
			operationHistory[0][AIM] = aim;
			operationHistory[0][WOUNDED_STATUS] = woundedStatus;
			operationHistory[0][DAYS_OUT] = daysOut;
			this.specialization = specialization;
			numOperations++;
		}
		else {
			operationHistory = addRowToHistoryArray(operationHistory);
			operationHistory[getNextEmptyRow(operationHistory)][OPERATION_ID] = operationId;
			operationHistory[getNextEmptyRow(operationHistory)][KILLS] = kills;
			operationHistory[getNextEmptyRow(operationHistory)][RANK] = rank;
			operationHistory[getNextEmptyRow(operationHistory)][HP] = hp;
			operationHistory[getNextEmptyRow(operationHistory)][MOBILITY] = mobility;
			operationHistory[getNextEmptyRow(operationHistory)][WILL] = will;
			operationHistory[getNextEmptyRow(operationHistory)][AIM] = aim;
			operationHistory[getNextEmptyRow(operationHistory)][WOUNDED_STATUS] = woundedStatus;
			operationHistory[getNextEmptyRow(operationHistory)][DAYS_OUT] = daysOut;
			this.specialization = specialization;
			numOperations++;
		}
	}
	
	// generic add operation
	public void addOperation (int operationId, int kills, int rank, int hp, int mobility, 
			int will, int aim, int woundedStatus, int daysOut) {
		if (numOperations == 0) {
			operationHistory[0][OPERATION_ID] = operationId;
			operationHistory[0][KILLS] = kills;
			operationHistory[0][RANK] = rank;
			operationHistory[0][HP] = hp;
			operationHistory[0][MOBILITY] = mobility;
			operationHistory[0][WILL] = will;
			operationHistory[0][AIM] = aim;
			operationHistory[0][WOUNDED_STATUS] = woundedStatus;
			operationHistory[0][DAYS_OUT] = daysOut;
			numOperations++;
		}
		else {
			operationHistory = addRowToHistoryArray(operationHistory);
			operationHistory[getNextEmptyRow(operationHistory)][OPERATION_ID] = operationId;
			operationHistory[getNextEmptyRow(operationHistory)][KILLS] = kills;
			operationHistory[getNextEmptyRow(operationHistory)][RANK] = rank;
			operationHistory[getNextEmptyRow(operationHistory)][HP] = hp;
			operationHistory[getNextEmptyRow(operationHistory)][MOBILITY] = mobility;
			operationHistory[getNextEmptyRow(operationHistory)][WILL] = will;
			operationHistory[getNextEmptyRow(operationHistory)][AIM] = aim;
			operationHistory[getNextEmptyRow(operationHistory)][WOUNDED_STATUS] = woundedStatus;
			operationHistory[getNextEmptyRow(operationHistory)][DAYS_OUT] = daysOut;
			numOperations++;
		}
	}
	
	private int[][] addRowToHistoryArray(int[][] array) {
		int[][] modifiedArray = new int[array.length + 1][array[0].length]; // robust to future length changes
		
		// copies only existing data, leaves last row blank
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				modifiedArray[i][j] = array[i][j];
			}
		}
		
		return modifiedArray;
	}
	
	private int getNextEmptyRow (int[][] array) {
		return array.length - 1;
	}
	
	public String toString() {
		String output;
		
		output = "Recruited:\t" 		+ dateRecruited.toString()
				+ "\nName:\t" 			+ name
				+ "\nID:\t"				+ soldierId
				+ "\nSpecialization:\t"	+ specialization
				+ "\nStats:\t"			+ baseHp + " " + baseMobility + " " + baseWill + " " +
										baseAim + " " + defense + "\n";
		
		output += "Operation History:\n"
				+ "ID\tKills\tRank\tHP\tMob\tWill\tAim\tWounds\tDays Out\n";
		for (int i = 0; i < operationHistory.length; i++) {
			for (int j = 0; j < operationHistory[0].length; j++) {
				output += operationHistory[i][j] + "\t";
			}
			output += "\n";
		}
		
		return output;
	}
	
	// TODO getters and setters
}
