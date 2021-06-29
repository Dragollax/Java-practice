//Lab12avst.java     This is the Student-Starting file. 
// This version is implemented with "Dynamic Arrays"
// This assignment pertains to some of the "Elevens" AP Lab Materials
//***************************************************************************
// The "Elevens" AP Lab is created for the College Board APCS
// curriculum by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Leon Schram has altered some of the "Elevens" files to focus on 
// specific CS topics as the "Elevens" Lab is integrated into the curriculum.


import java.util.Random;

import java.util.ArrayList;

public class Lab12ast
{
	public static void main(String[] args)
	{
		System.out.println("Lab12bst.JAVA");
		System.out.println();     
      Deck deck = new Deck();
      //System.out.println("90 point version shuffle");
      //deck.shufflethousand();
      
      System.out.println("100 point version shuffle");
      deck.shufflethousand();
      System.out.println(deck);
	}
}


class Deck 
{
	private ArrayList<Card> cards;
	public int size;
   private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
   private String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine",
                             "Ten","Jack","Queen","King","Ace"};
   private int[] pointValues = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	public Deck() 
   {
      size = 52;
		cards = new ArrayList<Card>(size);
      int count = 0;
       for (int suitIndex = 0; suitIndex < 4; suitIndex++)
      {
          for (int rankIndex = 0; rankIndex < 13; rankIndex++)
          {
             cards.add(count, new Card(suits[suitIndex],ranks[rankIndex],pointValues[rankIndex]));
             count++;
         }
       }
	}    
   
     public void add(String suit, String rank, int pointValue)
    {
    Card temp = new Card(suit,rank,pointValue);
    cards.add(temp);
 }
//place cards in random location 
public void shufflerandom() {
   Random num = new Random();
   for (int i = 0; i < size; i++) {
   		    int randompos = num.nextInt(size);
   		    Card temp = cards.get(i);
             Card temp2 = cards.get(randompos);
   		    cards.set(i, temp2);
    		    cards.set(randompos, temp2);
             
        }

		
}

//swap two cards 1000 times
 public void shufflethousand(){
   for(int i = 0; i < 1000; i++){
   int rand = (int)Math.floor(Math.random()*(51-0+1)+0);//get random number from range 0-51
   int rand2 = (int)Math.floor(Math.random()*(51-0+1)+0);//get random number from range 0-51
   Card num = cards.get(rand);
   Card num2 = cards.get(rand2);
   cards.set(rand, num2);
   cards.set(rand2, num); 

 
 }
 }
  
   public String toString(){
    String temp = "";
    for (int i = 0; i < size; i++){
    temp = temp + cards.get(i).toString() + "\n";
}
return temp;
}
   
   
   
   
 }
