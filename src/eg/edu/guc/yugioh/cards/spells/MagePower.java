package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends SpellCard {

	public MagePower(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {
		int x = getBoard().getActivePlayer().getField().getMonstersArea()
				.indexOf(monster);
		getBoard()
				.getActivePlayer()
				.getField()
				.getMonstersArea()
				.get(x)
				.setAttackPoints(
						getBoard().getActivePlayer().getField()
								.getMonstersArea().get(x).getAttackPoints()
								+ (500 * (getBoard().getActivePlayer()
										.getField().getSpellArea().size())));
		getBoard()
				.getActivePlayer()
				.getField()
				.getMonstersArea()
				.get(x)
				.setDefensePoints(
						getBoard().getActivePlayer().getField()
								.getMonstersArea().get(x).getDefensePoints()
								+ (500 * (getBoard().getActivePlayer()
										.getField().getSpellArea().size())));

	}
}
