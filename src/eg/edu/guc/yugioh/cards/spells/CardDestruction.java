package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;


public class CardDestruction extends SpellCard {

	public CardDestruction(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	public void  action (MonsterCard monster){
	
	int x=getBoard().getActivePlayer().getField().getHand().size();
	Card t=new Card();
		
		
		int y=getBoard().getOpponentPlayer().getField().getHand().size();
		while(!getBoard().getActivePlayer().getField().getHand().isEmpty()){
			t=getBoard().getActivePlayer().getField().getHand().get(0);
			
			
			getBoard().getActivePlayer().getField().getHand().remove(t);
			
			getBoard().getActivePlayer().getField().getGraveyard().add(t);
			t.setLocation(Location.GRAVEYARD);
			 
		 }
		while(!getBoard().getOpponentPlayer().getField().getHand().isEmpty()){
			
			 t=getBoard().getOpponentPlayer().getField().getHand().get(0);
			 getBoard().getOpponentPlayer().getField().getHand().remove(t);
			 getBoard().getOpponentPlayer().getField().getGraveyard().add(t);
			 t.setLocation(Location.GRAVEYARD);
			 
		 }
		
		getBoard().getActivePlayer().getField().addNCardsToHand(x);
		
		getBoard().getOpponentPlayer().getField().addNCardsToHand(y);
		
		
	}

}
