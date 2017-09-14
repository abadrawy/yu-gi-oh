package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;



public class SpellCard extends Card {

	public SpellCard(String name,String description){
		super(name,description);
		setHidden(true);
	}

	public SpellCard() {
		// TODO Auto-generated constructor stub
	}

	public void action(MonsterCard monster){
		
	}
	public void clone(SpellCard m){
		
		switch(m.getName()){
		
		
		case("Card Destruction"):new CardDestruction(m.getName(),m.getDescription());
		case("Change Of Heart") :new CardDestruction(m.getName(),m.getDescription());
		case("Dark Hole"):new CardDestruction(m.getName(),m.getDescription());
		case("Graceful Dice"):new CardDestruction(m.getName(),m.getDescription());
		case("Harpie Feather Duster"):new CardDestruction(m.getName(),m.getDescription());
		case("Heavy Strom"):new CardDestruction(m.getName(),m.getDescription());
		case("Mage Power"):new CardDestruction(m.getName(),m.getDescription());
		case("Pot Of Greed"):new CardDestruction(m.getName(),m.getDescription());
		case("Raigeki"):new CardDestruction(m.getName(),m.getDescription());
		case("Monster Reborn"):new CardDestruction(m.getName(),m.getDescription());
		
		}
		
		
	}
	
	
}
