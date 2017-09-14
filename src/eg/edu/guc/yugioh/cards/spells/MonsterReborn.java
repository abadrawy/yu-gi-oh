package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {

	public MonsterReborn(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {
		MonsterCard m1 = new MonsterCard();
		int max1 = 0;
		int a = getBoard().getActivePlayer().getField().getGraveyard().size();
		for (int i = 0; i < a; i++) {
			if (getBoard().getActivePlayer().getField().getGraveyard().get(i) instanceof MonsterCard) {
				if (((MonsterCard) getBoard().getActivePlayer().getField()
						.getGraveyard().get(i)).getAttackPoints() > max1) {
					max1 = ((MonsterCard) getBoard().getActivePlayer()
							.getField().getGraveyard().get(i))
							.getAttackPoints();
					m1 = (MonsterCard) getBoard().getActivePlayer().getField()
							.getGraveyard().get(i);

				}

			}
		}
		MonsterCard m2 = new MonsterCard();
		int max2 = 0;
		int o = getBoard().getOpponentPlayer().getField().getGraveyard().size();
		for (int i = 0; i < o; i++) {
			if (getBoard().getOpponentPlayer().getField().getGraveyard().get(i) instanceof MonsterCard) {
				if (((MonsterCard) getBoard().getOpponentPlayer().getField()
						.getGraveyard().get(i)).getAttackPoints() > max2) {
					max2 = ((MonsterCard) getBoard().getOpponentPlayer()
							.getField().getGraveyard().get(i))
							.getAttackPoints();
					m2 = (MonsterCard) getBoard().getOpponentPlayer()
							.getField().getGraveyard().get(i);
				}

			}
		}

		if (m1.getAttackPoints() > m2.getAttackPoints()) {
			getBoard().getActivePlayer().getField().getGraveyard().remove(m1);
			getBoard().getActivePlayer().getField().getMonstersArea().add(m1);
			m1.setLocation(Location.FIELD);

		} else {
			getBoard().getOpponentPlayer().getField().getGraveyard().remove(m2);
			getBoard().getActivePlayer().getField().getMonstersArea().add(m2);
			m2.setLocation(Location.FIELD);
		}

	}
}
