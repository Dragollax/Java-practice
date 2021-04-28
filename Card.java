public class Card
{
   private String suit;
   private String rank;
   private int pointValue;

   public Card(String s, String r, int pV)
   {
      suit = s;
      rank = r;
      pointValue = pV;
   }

   public String suit()      { return suit; }
   public String rank()      { return rank; }
   public int pointValue()   { return pointValue; }
 	
   public boolean matches(Card otherCard) 
   {
		return otherCard.suit().equals(this.suit())
			 && otherCard.rank().equals(this.rank())
			 && otherCard.pointValue() == this.pointValue();
	}
  
   public String toString()
   {
     return "[" + suit + ", " + rank + ", " + pointValue + "]";
   }
}

