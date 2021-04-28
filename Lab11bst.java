import java.util.Random;
public class Lab11bst
{
	public static void main(String[] args)
	{
		System.out.println("Lab11bst.JAVA");

      
		System.out.println();     
      Deck deck = new Deck();
      deck.add("a","Four",4);
      deck.add("b","Four",4);
      deck.add("c","Four",4);
      deck.add("d","Four",4);
      deck.add("e","Four",4);
       deck.add("f","Four",4);
      deck.add("g","Four",4);
       deck.add("h","Four",4);
      deck.add("i","Four",4);
       deck.add("j","Four",4);
      deck.add("k","Four",4);
      
      
      /*
      there are two notes i put for this lab, the second can be found below
      by the shuffling method.
      This note is to say that I do not know if I was required to provide a decktester or anything, since there wasn't
      any specific instructions on adding anything, so I just commented out the shuffle method below, until 52 cards are added
      Another thing is that I had to change the Card class toString() method to print output in this format: [Clubs, Two, 2]
      If, it wasn't allowed at all to change that part of the code, please allow me to redo this lab
      And if i was supposed to add a decktester, please allow me to redo this lab again
      Thank you!
      */
      deck.shuffle();
      System.out.println(deck);
      
	}
}


class Deck 
{
	private Card[] cards;
	private int size;
   private int space = 0;
	public Deck() 
   {
      size = 11;
		cards = new Card[size];
	}    
 
 public String toString(){
    String temp = "";
    for (int i = 0; i < space; i++)
    temp = temp + cards[i].toString() + "\n";
    return temp;
 }
/* public void shuffle(){
//swap two cards 1000 times
   for(int i = 0; i < 1000; i++){
   int rand = (int)Math.floor(Math.random()*(51-0+1)+0);//get random number from range 0-51
   int rand2 = (int)Math.floor(Math.random()*(51-0+1)+0);//get random number from range 0-51
   Card temp1 = cards[rand];
   cards[rand] = cards[rand2];
   cards[rand2] = temp1; 

 }
 }
 */

 
/*NOTE: I am not sure if this is what the lab instructions meant for the 100 point versions,
I did not understand what it was trying to say 
In the event that this does not meet the requirements for the 100 point version, 
please allow me to redo this part again. Thank you!
*/
public void shuffle() {
   Random num = new Random();
   for (int i = 0; i < cards.length; i++) {
   		    int randompos = num.nextInt(cards.length);
   		    Card temp = cards[i];
   		    cards[i] = cards[randompos];
   		    cards[randompos] = temp;
   		}

		
}



//add an add method for cards
    public void add(String suit, String rank, int pointValue)
    {
    Card temp = new Card(suit,rank,pointValue);
    cards[space] = temp;
    space++;
 }
 
 }