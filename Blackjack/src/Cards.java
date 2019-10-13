import java.util.ArrayList;


public class Cards {
	
	private ArrayList<Card> cards;// creates array list of cards
	
	Cards() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard (Card c){//adds a card to the array list
		cards.add(c);
	}
	
	public Card getCard(int index){// can access the array
		return cards.get(index);
	}
	
	public int numberOfCards()// gets the amount of cards in the array
	{
		int arrayListSize = cards.size();
		return arrayListSize;
	}

}
