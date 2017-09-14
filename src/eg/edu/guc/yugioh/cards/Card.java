package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;

public class Card implements Cloneable {

	private String name;
	private String description;
	private Location location;
	private boolean isHidden;
	private static Board board;

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		Card.board = board;
	}

	public Card(String name, String description) {
		this.name = name;
		this.description = description;
		setHidden(true);
		location = Location.DECK;
	}

	public Card() {

	}

	public Card clone() throws CloneNotSupportedException {
		return (Card) super.clone();

	}

	public void action(MonsterCard monster) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

}
