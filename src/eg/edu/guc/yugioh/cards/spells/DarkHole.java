package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {

	public DarkHole(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster) {
		super.action(monster);
		MonsterCard m = new MonsterCard();
		int x=getBoard().getActivePlayer().getField()
				.getMonstersArea().size();
		for (int i = 0; i < x; i++) {

			m = getBoard().getActivePlayer().getField().getMonstersArea()
					.get(0);
			
			getBoard().getActivePlayer().getField().removeMonsterToGraveyard(m);
			
			
		}
		

	}
}
