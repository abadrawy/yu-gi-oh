package eg.edu.guc.yugioh.board.player;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Field {

	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;
	private Deck deck;

	public Field() {
		phase = Phase.MAIN1;
		monstersArea = new ArrayList<MonsterCard>();
		spellArea = new ArrayList<SpellCard>();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		deck = new Deck();

	}

	public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden) {
		if (monstersArea.size() < 5) {
			monstersArea.add(monster);
			monster.setLocation(Location.FIELD);
			monster.setMode(m);
			monster.setHidden(isHidden);
		}

	}

	public void addMonsterToField(MonsterCard monster, Mode mode,
			ArrayList<MonsterCard> sacrifices) {
		MonsterCard x=new MonsterCard();
		int s=sacrifices.size();
		for(int i=0;i<s;i++){
			x=sacrifices.remove(0);
			monstersArea.remove(x);
			graveyard.add(x);
			x.setLocation(Location.GRAVEYARD);
		}
		monstersArea.add(monster);
		monster.setMode(mode);
		monster.setLocation(Location.FIELD);
		
		
		/*if (s < 5) {
	if (monster.getLevel() < 5) {
				monstersArea.add(monster);
				monster.setLocation(Location.FIELD);
				monster.setMode(mode);
			} 
	else if (monster.getLevel() == 5 || monster.getLevel() == 6) {
				if (y >= 1) {
					x=sacrifices.remove(0);
					graveyard.add(x);
					monstersArea.add(monster);
					monster.setLocation(Location.FIELD);
					monster.setMode(mode);
				}}
	 else if (monster.getLevel() == 7 || monster.getLevel() == 8) {
				if (y >= 2) {
					x=sacrifices.remove(0);
					graveyard.add(x);
					x=sacrifices.remove(0);
					graveyard.add(x);
					monstersArea.add(monster);
					monster.setLocation(Location.FIELD);
					monster.setMode(mode);
				}
			
			}*/
			
			
			
			
		}
	

	public void removeMonsterToGraveyard(MonsterCard monster) {
		if (monster.getLocation() == Location.HAND) {
			hand.remove(monster);
		} else
			monstersArea.remove(monster);
		graveyard.add(monster);
		monster.setLocation(Location.GRAVEYARD);

	}

	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters) {
		int j = monsters.size();
		for (int i = 0; i < j; i++) {
			if (monstersArea.contains(monsters.get(i))) {
				MonsterCard m = (monsters.get(i));

				monstersArea.remove(m);
				graveyard.add(m);
				m.setLocation(Location.GRAVEYARD);

			}
		}
		monsters.clear();
	}

	public void addSpellToField(SpellCard action, MonsterCard monster,
			boolean hidden) {

		action.setHidden(hidden);
		if (spellArea.size() < 5) {
			if (hidden == false)
			{   action.setLocation(Location.FIELD);
			    spellArea.add(action);
				activateSetSpell(action, monster);}

			else {
				spellArea.add(action);
				action.setLocation(Location.FIELD);
			}
		}

	}

	public void activateSetSpell(SpellCard action, MonsterCard monster) {
		
		if (action.getLocation() == Location.FIELD) {
			SpellCard x=new SpellCard();
			
			switch(action.getName()){
			
			
			case("Card Destruction"):x=(CardDestruction)action;x.action(monster);break;
			
			
			case("Change Of Heart") :x=(ChangeOfHeart)action;break;
			case("Dark Hole"):x=(DarkHole)action;break;
			case("Graceful Dice"):x=(GracefulDice)action;break;
			case("Harpie Feather Duster"):x=(HarpieFeatherDuster)action;break;
			case("Heavy Strom"):x=(HeavyStorm)action;break;
			case("Mage Power"):x=(MagePower)action;break;
			case("Pot Of Greed"):x=(PotOfGreed)action;break;
			case("Raigeki"):x=(Raigeki)action;break;
			case("Monster Reborn"):x=(MonsterReborn)action;break;
			
			}
			
			
			x.action(monster);
			spellArea.remove(x);
			graveyard.add(x);
			x.setLocation(Location.GRAVEYARD);
		}

	}

	public void removeSpellToGraveyard(SpellCard spell) {
		if (spellArea.contains(spell)) {
			spellArea.remove(spell);
			graveyard.add(spell);
			spell.setLocation(Location.GRAVEYARD);
		}
	}

	public void removeSpellToGraveyard(ArrayList<SpellCard> spells) {
		int x = spells.size();
		for (int i = 0; i < x; i++) {
			SpellCard s = spells.remove(0);
			if (spellArea.contains(s)) {
				spellArea.remove(s);
				spells.remove(s);
				graveyard.add(s);
				s.setLocation(Location.GRAVEYARD);
			}
		}
	}

	public void addCardToHand() {
		Card c = new Card();
		c = this.getDeck().drawOneCard();
		c.setLocation(Location.HAND);
		hand.add(c);

	}

	public void addNCardsToHand(int n) {

		for (int i = 0; i < n; i++) {
			Card c = new Card();
			c = this.getDeck().drawOneCard();
			c.setLocation(Location.HAND);
			hand.add(c);
		}

	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public void setMonstersAreas(ArrayList<MonsterCard> monstersArea) {
		this.monstersArea = monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public void setSpellArea(ArrayList<SpellCard> spellArea) {
		this.spellArea = spellArea;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public void setGraveyard(ArrayList<Card> graveyard) {
		this.graveyard = graveyard;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
