package eg.edu.guc.yugioh.board.player;

import java.io.File;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
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

public class Deck implements Cloneable {

	private static ArrayList<Card> monsters=new ArrayList<Card>();
	private static ArrayList<Card> spells=new ArrayList<Card>();
	private ArrayList<Card> deck=new ArrayList<Card>();

	public Deck() {
		deck = new ArrayList<Card>();
		ArrayList<Card> monsters;
		ArrayList<Card> spells;
		 monsters = loadCardsFromFile("Database-Monsters.csv");
		 spells = loadCardsFromFile("Database-Spells.csv");
		if(!monsters.isEmpty()&&!spells.isEmpty())
		  buildDeck(monsters, spells);
		shuffleDeck();

	}

	public static ArrayList<Card> loadCardsFromFile(String path) {
		ArrayList<Card> array = new ArrayList<Card>();
		String filename = path;
		File file = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (sc.hasNext()) {

			String data = sc.nextLine();

			String[] temp = data.split(",");

			if (temp[0].equals("Monster")) {
				MonsterCard x = new MonsterCard(temp[1], temp[2],
						Integer.parseInt(temp[5]), Integer.parseInt(temp[3]),
						Integer.parseInt(temp[4]));
				array.add(x);
			}

			else {
				switch (temp[1]) {
				case ("Card Destruction"):
					array.add(new CardDestruction(temp[1], temp[2]));break;
				case ("Change Of Heart"):
					array.add(new ChangeOfHeart(temp[1], temp[2]));break;
				case ("Dark Hole"):
					array.add(new DarkHole(temp[1], temp[2]));break;
				case ("Graceful Dice"):
					array.add(new GracefulDice(temp[1], temp[2]));break;
				case ("Harpie's Feather Duster"):
					array.add(new HarpieFeatherDuster(temp[1], temp[2]));break;
				case ("Heavy Strom"):
					array.add(new HeavyStorm(temp[1], temp[2]));break;
				case ("Mage Power"):
					array.add(new MagePower(temp[1], temp[2]));break;
				case ("Pot of Greed"):
					array.add(new PotOfGreed(temp[1], temp[2]));break;
				case ("Raigeki"):
					array.add(new Raigeki(temp[1], temp[2]));break;
				case ("Monster Reborn"):
					array.add(new MonsterReborn(temp[1], temp[2]));

				}
			}
		}

		sc.close();
		return array;
	}

	public void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) {
      Card c=new Card();
		ArrayList<Card> cloneM = (ArrayList<Card>) monsters.clone();
		ArrayList<Card> cloneS = (ArrayList<Card>) spells.clone();
		for (int i = 0; i < 15; i++) {
			int x = (int) Math.random() * 30;
			
			 c=cloneM.remove(x);
			deck.add(c);
			c.setLocation(Location.DECK);
			//deck.add(cloneM.remove(x));
		}
		for (int i = 0; i < 5; i++) {
			int x = (int) Math.random() * 10;
			 c=cloneS.remove(x);
			deck.add(c);
			c.setLocation(Location.DECK);
			//deck.add(cloneS.remove(x));
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);

	}

	public ArrayList<Card> drawNCards(int n) {
		ArrayList<Card> draw = new ArrayList<Card>();
		
		for (int i = 0; i < n; i++) {
			draw.add(drawOneCard());
		}
		return draw;
	}

	public Card drawOneCard() {
		//if (deck.get(0).getLocation() == Location.DECK)
			//deck.get(0).setLocation(Location.HAND);
		//return deck.remove(0);
		Card c=new Card();
		 c=deck.remove(0);
		c.setLocation(Location.DECK);
		return c;
	}

	public ArrayList<Card> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public ArrayList<Card> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

}
