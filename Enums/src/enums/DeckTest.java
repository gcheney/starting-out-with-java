package enums;

public class DeckTest 
{
	public static void main(String[] args) 
	{		
		Deck theDeck = new Deck();
		System.out.println(theDeck);
		theDeck.shuffle();
		theDeck.displayDeck();
		System.out.println("\n" + theDeck.draw());
	}

}
