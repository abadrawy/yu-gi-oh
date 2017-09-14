package eg.edu.guc.yugioh.board;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {
	private Player activePlayer;
    private Player opponentPlayer;
    private	Player winner;
	
    public Board(){
    	Card.setBoard(this);
    	
    	
    }
    
	public void whoStarts(Player p1, Player p2){
	
		activePlayer=new Player(null);
    	opponentPlayer=new Player(null);
    	winner=new Player(null);
				
	int e1=(int)Math.random()*10;
	int e2=(int)Math.random()*10;
	int p;
	p=Math.max(e1, e2);
	if(p==e1)
		activePlayer=p1;
	else opponentPlayer=p2;
	
	}
	
	
	public void startGame(Player p1, Player p2){

		whoStarts(p1,p2);
		activePlayer.getField().addNCardsToHand(6);
		opponentPlayer.getField().addNCardsToHand(5);
	}
	
	public void nextPlayer(){
			
		Player temp;
		temp=activePlayer;
		activePlayer=opponentPlayer;
		opponentPlayer=temp;
		activePlayer.getField().addCardToHand();
		
	}


	public Player getActivePlayer() {
		return activePlayer;
	}


	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}


	public Player getOpponentPlayer() {
		return opponentPlayer;
	}


	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}


	public Player getWinner() {
		return winner;
	}


	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	
}
