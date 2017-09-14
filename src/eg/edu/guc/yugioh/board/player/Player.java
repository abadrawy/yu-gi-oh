package eg.edu.guc.yugioh.board.player;

public class Player {

	private String name;
	private int lifePoints;
	private Field field;
	
	public Player(String name){
		this.name=name;
		this.field = new Field();
		this.lifePoints=8000;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	
}

