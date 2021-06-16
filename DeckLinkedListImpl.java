package com.olympic.cis143.m02.student.homework;

import java.util.*;

import com.olympic.cis143.m02.student.homework.Card;

/**
 * Note that you can think of the deck implementation as being an iterator in that its creates 
 * and used once. Meaning, when a card is delt is  MUST be removed from the deck.
 */
public class DeckLinkedListImpl {

    /**
     * This will be the stack object for you to work with.
     */
    private Deque<Card> deck = new LinkedList<Card>();

    /**
     * Const.
     * @param jokers True if you want jokers in this deck.
     */
    public DeckLinkedListImpl(final boolean jokers) 
    {
        createDeck(jokers);
    }

    /**
     * Private. THis is the place where you will need to create a deck of cards. You can iterate throug
     * ther enums in Card.
     *
     * Some rules:
     * ============
     * 1. Note the boolean jokers parameter. If true add the Jokers to the deck with a Card.Suite.NONE.
     * 2. Do not create cards, other than jokers, with a Card.Suite.NONE.
     *
     * Outcome
     * ========
     * if jokers == true, 54 cards will be created.
     * if jokers == false, 52 cards are created.
     *
     * @param jokers True if you want jokers added to the deck.
     */
    private void createDeck(final boolean jokers) 
    {
    	/* Create an array for suit
    	 * Create an array for value
    	 * Create the deck by iterating through the two arrays
    	 * Add jokers if applicable
    	 */
    	Card.Suit[] suits = {Card.Suit.HEARTS,Card.Suit.CLUBS,Card.Suit.DIAMONDS,Card.Suit.SPADES};
    	Card.Value[] value = {Card.Value.KING,Card.Value.QUEEN,Card.Value.JACK,Card.Value._10,
    						  Card.Value._9,Card.Value._8,Card.Value._7,Card.Value._6,
    						  Card.Value._5,Card.Value._4,Card.Value._3,Card.Value._2,
    						  Card.Value.ACE};
        for (Card.Suit theSuit: suits)
    	{
    		for (Card.Value theValue: value)
    		{
    			deck.add(new Card(theSuit, theValue));
    		}
    	}
        if (jokers)
        {
        	deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
        	deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
        }
    }

    /**
     * Gets the deck.
     * @return The deck.
     */
    public Deque<Card> getDeck() 
    {
        return deck;
    }
    /**
     * Randomize and shuffle the deck of cards.
     */
    public void shuffle() 
    {
    	Collections.shuffle((List<?>) deck);
    }

    /**
     * True if the deck has cards remaining else false.
     * @return
     */
    public boolean hasNext()
    {
        return deck.size() > 0;
    }

    /**
     * Always call the hasNext() method before calling this method.
     * This method should get the next card in the deck.
     *
     * Outcome
     * =======
     * The method will remove the next from the deck and return it in the method.
     *
     * If the deck is empty it should through a RuntimeException.
     * @return
     */
    public Card dealCard() {
        return deck.removeFirst();
    }
}
