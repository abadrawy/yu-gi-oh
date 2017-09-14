package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {

	public GracefulDice(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}


	public void action(MonsterCard monster){
		int x=(int) ((Math.random()*10)+1);
		
		
		//all monsters i control as in visible or not 
		for(int i=0;i<getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
			getBoard().getActivePlayer().getField().getMonstersArea().get(i).setAttackPoints(getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints()+100*x);
			getBoard().getActivePlayer().getField().getMonstersArea().get(i).setDefensePoints(getBoard().getActivePlayer().getField().getMonstersArea().get(i).getDefensePoints()+100*x);
		}
		
	}
	}

