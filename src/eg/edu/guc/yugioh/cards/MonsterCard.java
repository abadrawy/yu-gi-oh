package eg.edu.guc.yugioh.cards;

public class MonsterCard extends Card {
private int level;
private int defensePoints;
private int attackPoints;
private Mode mode;

	public MonsterCard(String name,String description ,int level,int attackPoints,int DefensePoints) {
		super(name,description);
		this.mode=Mode.DEFENSE;
		this.level=level;
		this.attackPoints=attackPoints;
		this.defensePoints=DefensePoints;
		
	}
public MonsterCard(){
	
}
public void clone(MonsterCard m){
	m=new MonsterCard(m.getName(),m.getDescription(),m.getLevel(),m.getAttackPoints(),m.getDefensePoints());
}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackpoints) {
		this.attackPoints = attackpoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int DefensePoints) {
		this.defensePoints = DefensePoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	@Override
	public void action(MonsterCard monster) {
		// TODO Auto-generated method stub
		
	}
	
	

}

