package enums;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;
 
public class Deck
{
  private Stack<Card> deck;
 
  public Deck ()
  {
    this.deck = new Stack<Card>();
    
    /*
    for (int i = 0; i < 13; i++)
    {
      CardValue value = CardValue.values()[i];
 
      for (int j = 0; j < 4; j++)
      {
        Suit suit = Suit.values()[j];
        Card card = new Card(value, suit);
        this.deck.push(card);
      }
    }
    */
 	
    
    for (CardValue value : CardValue.values()) 
    {
    	for (Suit suit : Suit.values()) 
    	{
    		Card card = new Card(value, suit);
            this.deck.push(card);
    	}
    }
    
  }
  
  public void shuffle() 
  {
	  Collections.shuffle(deck);
  }
  
  public Card draw() {
	  try {
		  return deck.pop();
	  }
	  catch(EmptyStackException e) {
		  System.out.println("No more cards to draw");
	  }
	  
	  return null;
  }
  
  @Override 
  public String toString() 
  {
	  StringBuilder sb = new StringBuilder();
	  Iterator<Card> cardIterator = deck.iterator();
	  
	  while (cardIterator.hasNext())
	  {
		  Card aCard = cardIterator.next();
		  sb.append(aCard.getCardValue() + " of " + aCard.getSuit() + "\n");
	  }
	  
	  return sb.toString();
  }
  
  
  public void displayDeck() 
  {
	  Iterator<Card> cardIterator = deck.iterator();
	  
	  while (cardIterator.hasNext())
	  {
		  Card aCard = cardIterator.next();
		  System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
	  }
	  
  }
  
}
