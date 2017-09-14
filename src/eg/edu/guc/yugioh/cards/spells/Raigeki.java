package eg.edu.guc.yugioh.cards.spells;

//import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends SpellCard {

	public Raigeki(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {

		//ArrayList<MonsterCard> x = new ArrayList<MonsterCard>();
		MonsterCard m = new MonsterCard();
		int x=getBoard().getOpponentPlayer().getField()
				.getMonstersArea().size();
		for (int i = 0; i < x; i++) {

			m = getBoard().getOpponentPlayer().getField().getMonstersArea()
					.get(0);
			//x.add(m);
			getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(m);
			
			
		}
		//getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(x);

	}

}
