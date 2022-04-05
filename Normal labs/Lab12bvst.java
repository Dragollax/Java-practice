// Lab12bvst.java     This is the student starting version.
// This assignment pertains to some of the "Magpie" AP Lab Materials
//***************************************************************************
// The "Magpie" AP Lab is created for the College Board APCS
// curriculum by Laurie White.
// Leon Schram has altered some of the "Magpie" files to focus on 
// specific CS topics as the "Magpie" Lab is integrated into the curriculum.

 
import java.util.Scanner;
import java.util.ArrayList;

public class Lab12bvst
{
	public static void main(String[] args)
	{
		MagpieLab12b maggie = new MagpieLab12b();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}
}


class MagpieLab12b
{
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	public String getResponse(String statement)
	{
		String response = "";
      final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
      ArrayList<String> arrl = new ArrayList<String>();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
      String[] arr = 
      {"How's your family?",
      "How are your parents?",
      "Do you have any brother or sisters?",
      "Tell me more about your family!",
      "When was the best time you had with your family?",
      "Do you have any children?",
      "What did you get for your family during christmas?",
      "I hope you and your family are doing well!",
      "Family is important",
      "Never take your family for granted"};
       int count = 0;
       for (int i = 0; i < NUMBER_OF_RESPONSES; i++)
      {
             arrl.add(count, arr[count]);
             count++;
         
       }


		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0
            || statement.indexOf("parent") >= 0
            || statement.indexOf("family") >=0
            )
		{
			response = arrl.get(whichResponse);
         return response;
         
         		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
      String[] arr = 
      {"I have no idea what you're saying",
      "That's weird...let's switch a topic",
      "This bores, me next topic!",
      "Boring, but did you know chatbot ELIZA was the first chatbot?",
      "Wow cool!",
      "You should be hired at Disney for what you're saying",
      "I like turtles",
      "I'm not interested anymore, you should terminate the program",
      "I am the dumbest chatbot in this world!",
      "It's so hot!!"};
           
		response = arr[whichResponse];
		return response;
	}
}