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
	
	public static final int NO_OPERATION = 		-1;
	
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
	private int numStatChanges = 0;
	private boolean isPsion;
	private boolean isMec;
	private boolean isGeneMod;
	
	private SoldierStats[] statHistory = new SoldierStats[1];

	public Soldier (Calendar dateRecruited, String name, int hp, int mobility, int will, int aim, int defense) {
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
		if (numStatChanges == 0) {
			statHistory[0] = new SoldierStats(operationId, kills, rank, hp, mobility, 
					will, aim, woundedStatus, daysOut);
			this.specialization = specialization;
			numOperations++;
			numStatChanges++;
		}
		else {
			statHistory = addRowToHistoryArray(statHistory);
			statHistory[getNextEmptyRow(statHistory)] = new SoldierStats(operationId, kills, 
					rank, hp, mobility, will, aim, woundedStatus, daysOut);
			this.specialization = specialization;
			numOperations++;
			numStatChanges++;
		}
	}
	
	// assumes a rank up, but not the first one
	public void addOperation (int operationId, int kills, int rank, int hp, int mobility, 
			int will, int aim, int woundedStatus, int daysOut) {
		// TODO there's something redundant in here, brain not functioning...
		if (numStatChanges == 0) {
			statHistory[0] = new SoldierStats(operationId, kills, rank, hp, mobility, 
					will, aim, woundedStatus, daysOut);
			numOperations++;
			numStatChanges++;
		}
		else {
			statHistory = addRowToHistoryArray(statHistory);
			statHistory[getNextEmptyRow(statHistory)] = new SoldierStats(operationId, kills, 
					rank, hp, mobility, will, aim, woundedStatus, daysOut);
			numOperations++;
			numStatChanges++;
		}
	}
	
	// add operation, no rank up
	public void addOperation (int operationId, int kills, int woundedStatus, int daysOut) {
		
		if (numStatChanges == 0) {
			statHistory[0] = new SoldierStats(operationId, kills, Soldier.ROOKIE, baseHp, baseMobility, 
					baseWill, baseAim, woundedStatus, daysOut);
			numOperations++;
			numStatChanges++;
		}
		else {
			int previousOpIndex = statHistory.length - 1;
			statHistory = addRowToHistoryArray(statHistory);
			// assigns unchanged values to new operation, ie. rank is unchanged so use last mission's rank
			statHistory[getNextEmptyRow(statHistory)] = new SoldierStats(operationId, kills, 
					statHistory[previousOpIndex].getRank(), statHistory[previousOpIndex].getHp(), 
					statHistory[previousOpIndex].getMobility(), statHistory[previousOpIndex].getWill(), 
					statHistory[previousOpIndex].getAim(), woundedStatus, daysOut);
			numOperations++;
			numStatChanges++;
		}
	}
	
	public void addPsiTraining (int psiTrainingId, int will) {
		// not possible to psi train without at least one (5, technically) change in stats
		statHistory = addRowToHistoryArray(statHistory);
		statHistory[getNextEmptyRow(statHistory)] = new SoldierStats(psiTrainingId, will);
		numStatChanges++;
	}
	
	public void addMecConversion (int mecConversionId, int hp, int mobility, int will, int aim) {
		// not possible to mec convert without at least one stat change
		statHistory = addRowToHistoryArray(statHistory);
		statHistory[getNextEmptyRow(statHistory)] = new SoldierStats(mecConversionId, hp, mobility, will, aim);
		numStatChanges++;
	}
	
	private SoldierStats[] addRowToHistoryArray(SoldierStats[] statHistory) {
		SoldierStats[] modifiedArray = new SoldierStats[statHistory.length + 1]; // robust to length changes
		
		// copies only existing data, leaves last row blank
		for (int i = 0; i < statHistory.length; i++) {
				modifiedArray[i] = statHistory[i];
		}
		
		return modifiedArray;
	}
	
	private int getNextEmptyRow (SoldierStats[] array) {
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
		
		output += "Stat History:\n"
				+ "ID\tKills\tRank\tHP\tMob\tWill\tAim\tWounds\tDays Out";
		
		for (int i = 0; i < statHistory.length; i++) {
			output += "\n";
			if (statHistory[i].getReasonForChange() == SoldierStats.OPERATION)
				output += statHistory[i].getOperationId() + "\t";
			else if (statHistory[i].getReasonForChange() == SoldierStats.PSI_TRAINING)
				output += statHistory[i].getPsiId() + "\t";
			else
				output += statHistory[i].getMecId() + "\t";
			
			output += statHistory[i].getKills() + 		"\t";
			output += statHistory[i].getRank() + 		"\t";
			output += statHistory[i].getHp() + 			"\t";
			output += statHistory[i].getMobility() + 	"\t";
			output += statHistory[i].getWill() + 		"\t";
			output += statHistory[i].getAim() + 		"\t";
			output += statHistory[i].getWoundedStatus() + "\t";
			output += statHistory[i].getDaysOut() + 	"\t";
		}
		
		return output;
	}
	
	// TODO getters and setters
}
