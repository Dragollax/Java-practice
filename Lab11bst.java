import java.util.Random;
public class Lab11bst
{
	public static void main(String[] args)
	{
		System.out.println("Lab11bst.JAVA");

      
		System.out.println();     
      Deck deck = new Deck();
      deck.add("Clubs","Two",2);
      deck.add("Clubs","Three",3);
      deck.add("Clubs","Four",4);
      deck.add("Clubs","Five",5);
      deck.add("Clubs","six",6);
       deck.add("Clubs","seven",7);
      deck.add("Clubs","Eight",8);
       deck.add("Clubs","Nine",9);
      deck.add("Clubs","Ten",10);
       deck.add("Clubs","Jack",10);
      deck.add("Clubs","Queen",10);
      deck.add("Clubs","King",10);
      deck.add("Clubs","Ace",11);
      
      
      deck.add("Diamonds","Two",2);
      deck.add("Diamonds","Three",3);
      deck.add("Diamonds","Four",4);
      deck.add("Diamonds","Five",5);
      deck.add("Diamonds","six",6);
       deck.add("Diamonds","seven",7);
      deck.add("Diamonds","Eight",8);
       deck.add("Diamonds","Nine",9);
      deck.add("Diamonds","Ten",10);
       deck.add("Diamonds","Jack",10);
      deck.add("Diamonds","Queen",10);
      deck.add("Diamonds","King",10);
      deck.add("Diamonds","Ace",11);
      
      deck.add("Hearts","Two",2);
      deck.add("Hearts","Three",3);
      deck.add("Hearts","Four",4);
      deck.add("Hearts","Five",5);
      deck.add("Hearts","six",6);
       deck.add("Hearts","seven",7);
      deck.add("Hearts","Eight",8);
       deck.add("Hearts","Nine",9);
      deck.add("Hearts","Ten",10);
       deck.add("Hearts","Jack",10);
      deck.add("Hearts","Queen",10);
      deck.add("Hearts","King",10);
      deck.add("Hearts","Ace",11);
      
      deck.add("Spades","Two",2);
      deck.add("Spades","Three",3);
      deck.add("Spades","Four",4);
      deck.add("Spades","Five",5);
      deck.add("Spades","six",6);;
       deck.add("Spades","seven",7);
      deck.add("Spades","Eight",8);
       deck.add("Spades","Nine",9);
      deck.add("Spades","Ten",10);
       deck.add("Spades","Jack",10);
      deck.add("Spades","Queen",10);
      deck.add("Spades","King",10);
      deck.add("Spades","Ace",11);
      
      
      
 
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
      size = 52;
		cards = new Card[size];
	}    
 
 public String toString(){
    String temp = "";
    for (int i = 0; i < space; i++){
    temp = temp + cards[i].toString() + "\n";
}
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