package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;


public class ChangeOfHeart extends SpellCard {

	public ChangeOfHeart(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
public void action(MonsterCard monster){
	getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);

	getBoard().getActivePlayer().getField().getMonstersArea().add(monster);
	
	

}
}
