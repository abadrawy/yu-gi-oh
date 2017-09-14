package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster {

	public HeavyStorm(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {
		SpellCard a;
		super.action(monster);
		int x = getBoard().getActivePlayer().getField().getSpellArea().size();
		for (int i = 0; i < x; i++) {
			a = getBoard().getActivePlayer().getField().getSpellArea().remove(0);
			
			
			getBoard().getActivePlayer().getField().getGraveyard().add(a);
			a.setLocation(Location.GRAVEYARD);
		}
	}
}
