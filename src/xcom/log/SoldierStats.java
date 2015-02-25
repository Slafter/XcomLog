package xcom.log;

// a snapshot of a soldier's statistics at a given time
public class SoldierStats {
	
	// reasons for change
	public static final int OPERATION = 		0;
	public static final int PSI_TRAINING = 		1;
	public static final int MEC_CONVERSION = 	2;
	
	// default to -1 to denote an unchanged value
	private int operationId = 		-1;
	private int psiTrainingId =		-1;
	private int mecConversionId = 	-1;
	private int rank = 				-1;
	private int hp = 				-1;
	private int mobility = 			-1;
	private int will = 				-1;
	private int aim = 				-1;
	private int kills = 			-1;
	private int woundedStatus = 	-1;
	private int daysOut = 			-1;
	private int reasonForChange = 	-1;
	
	// Operation changes
	public SoldierStats(int operationId, int kills, int rank, int hp, int mobility, 
			int will, int aim, int woundedStatus, int daysOut) {
		
		this.operationId = operationId;
		this.kills = kills;
		this.rank = rank;
		this.hp = hp;
		this.mobility = mobility;
		this.will = will;
		this.aim = aim;
		this.woundedStatus = woundedStatus;
		this.daysOut = daysOut;
		reasonForChange = OPERATION;
	}
	
	// Psi Training changes
	public SoldierStats(int psiTrainingId, int will) {
		this.psiTrainingId = psiTrainingId;
		this.will = will;
		reasonForChange = PSI_TRAINING;
	}
	
	// Mec Conversion changes
	public SoldierStats(int mecConversionId, int hp, int mobility, int will, int aim) {
		this.mecConversionId = mecConversionId;
		this.hp = hp;
		this.mobility = mobility;
		this.will = will;
		this.aim = aim;
		reasonForChange = MEC_CONVERSION;
	}
	
	public int getOperationId() {
		return operationId;
	}
	
	public int getPsiId() {
		return psiTrainingId;
	}
	
	public int getMecId() {
		return mecConversionId;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMobility() {
		return mobility;
	}
	
	public int getWill() {
		return will;
	}
	
	public int getAim() {
		return aim;
	}
	
	public int getKills() {
		return kills;
	}
	
	public int getWoundedStatus() {
		return woundedStatus;
	}
	
	public int getDaysOut() {
		return daysOut;
	}
	
	public int getReasonForChange() {
		return reasonForChange;
	}
	
	
}
