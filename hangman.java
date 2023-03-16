import java.util.Scanner;
class hangman
{
	public static String word[]={"?","?","r","?","c","?","d","?","r","?"};
	public static int rightguess=0;
	public static int wrongguess=0;
	public static String userin;
	public static String guess[]={" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
	public static int temp=0;

	static void gameboard(String[] gameboard,int rguess,int wguess)
	{
		System.out.println();
		for(String i:gameboard)
		{
			System.out.print(i+" ");
		}
		System.out.println();System.out.println();
		System.out.println("Number of Right Guesses: "+rguess);
		System.out.println("Number of Wrong Guesses: "+wguess);
		graphics(wrongguess);
	}


	static void userinput()
	{
		int num=1;
		while(word[0]=="?"||word[1]=="?")
		{
			if(wrongguess==6)
			{
				System.out.println("Sorry! You Lost the Game!");
				break;
			}
			
			while(num==1)			
			{
				userin=enter();
				num=duplicate_guess(userin);
			}
			guess[temp]=userin;
			temp++;
			check(userin);
			num=1;
		}
	}

	static String enter()
	{
		String a;
		Scanner s=new Scanner(System.in);
		System.out.println();
		System.out.print("Please Enter the letter of your Guess: ");
		a=s.nextLine();
		return a;
	}

	static int duplicate_guess(String userin)
	{
		for(int i=0;i<26;i++)
			{
				if(guess[i].equals(userin))
				{				
					System.out.println("The letter has already been guessed, try again!");
					return 1;
				}
			}
		return 0;
	}

	static void check(String userin)
	{
		if(userin.equals("a"))
		{
			word[0]=userin;
			word[3]=userin;
			word[5]=userin;
			word[9]=userin;
			rightguess++;
			System.out.println();
			System.out.println("Congrats!, Right guess!");
			gameboard(word,rightguess,wrongguess);

		}

		else if(userin.equals("b"))
		{
			word[1]=userin;
			word[7]=userin;
			rightguess++;
			gameboard(word,rightguess,wrongguess);
			System.out.println("Congrats!, Right guess!");
		}

		else
		{
			System.out.println("Sorry! Wrong guess, try again!");
			wrongguess++;
			gameboard(word,rightguess,wrongguess);
		}
	}
	
	public static void graphics(int wrnguess)
	{
		if(wrnguess==6)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("  (|)  |");
			System.out.println("  ( )  |");
			System.out.println("       |");
		}
		else if(wrnguess==5)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("  (|)  |");
			System.out.println("  (    |");
			System.out.println("       |");
		}
		else if(wrnguess==4)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("  (|)  |");
			System.out.println("       |");
			System.out.println("       |");
		}
		else if(wrnguess==3)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("  (|   |");
			System.out.println("       |");
			System.out.println("       |");
		}
		else if(wrnguess==2)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("   |   |");
			System.out.println("       |");
			System.out.println("       |");
		}
		else if(wrnguess==1)
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("   O   |");
			System.out.println("       |");
			System.out.println("       |");
			System.out.println("       |");
		}
		else
		{
			System.out.println();
			System.out.println("   +---+ ");
			System.out.println("   |   |");
			System.out.println("       |");
			System.out.println("       |");
			System.out.println("       |");
			System.out.println("       |");
		}
	}

	public static void main(String args[])
	{	
		gameboard(word,rightguess,wrongguess);
		userinput();
	}
}
