import com.badlogic.gdx.graphics.g2d.Sprite;


//Written by Zain Siddique
public class Card {
	Sprite cardImage;
	String cardName;
	int value;
	boolean valueAdded;
	
	Card (String name, Sprite cardPic, boolean valueAdd){// card constructor
		
		cardImage = cardPic;
		cardName = name;
		valueAdded = valueAdd;
	}
	
	public void setValue(){// determines what each cards value is worth
		
		if (cardName == "ace"){// if the card that is pulled is an ace it has a value of 1 or 11
			value = 1;

		}
		
		else if (cardName == "two")// if the card that is pulled is a 2 of any suit it will be worth 2
			value = 2;
		
		else if (cardName == "three")
			value = 3;
		
		else if (cardName == "four")
			value = 4;
		
		else if (cardName == "five")
			value = 5;
		
		else if (cardName == "six")
			value = 6;
		
		else if (cardName == "seven")
			value = 7;
		
		else if (cardName == "eight")
			value = 8;
		
		else if (cardName == "nine")
			value = 9;

		// a ten and any face card that is pulled is worth a 10
		else if (cardName == "ten" || cardName == "jack" || cardName == "queen" || cardName == "king")
			value = 10;
	}
	
	public int getValue (){// gets value
		return value;
	}
	

	
}
