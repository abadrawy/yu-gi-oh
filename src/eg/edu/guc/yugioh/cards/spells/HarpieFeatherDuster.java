package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {

	public HarpieFeatherDuster(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {
		// getBoard().getOpponentPlayer().getField().setSpellArea(null);
		int x = getBoard().getOpponentPlayer().getField().getSpellArea().size();
		SpellCard a;
		for (int i = 0; i < x; i++) {
			
			a=getBoard().getOpponentPlayer().getField().getSpellArea().remove(0);
			
			getBoard().getOpponentPlayer().getField().getGraveyard().add(a);
			a.setLocation(Location.GRAVEYARD);
		}
	}
}