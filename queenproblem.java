import java.util.Scanner;
class queenproblem
{

	public static int column[][]={{1,9,17,25,33,41,49,57},{2,10,18,26,34,42,50,58},{3,11,19,27,35,43,51,59},{4,12,20,28,36,44,52,60},{5,13,21,29,37,45,53,61},{6,14,22,30,38,46,54,62},{7,15,23,31,39,47,55,63},{8,16,24,32,40,48,56,64}};
	public static int row[][]={{1,2,3,4,5,6,7,8},{9,10,11,12,13,14,15,16},{17,18,19,20,21,22,23,24},{25,26,27,28,29,30,31,32},{33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48},{49,50,51,52,53,54,55,56},{57,58,59,60,61,62,63,64}};
	public static int rdiag[][]={{1},{9,2},{17,10,3},{25,18,11,4},{33,26,19,12,5},{41,34,27,20,13,6},{49,42,35,28,21,14,7},{57,50,43,36,29,22,15,8},{58,51,44,37,30,23,16},{59,52,45,38,31,24},{60,53,46,39,32},{61,54,47,40},{62,55,48},{63,56},{64}};
	public static int ldiag[][]={{8},{16,7},{24,15,6},{32,23,14,5},{40,31,22,13,4},{48,39,30,21,12,3},{56,47,38,29,20,11,2},{64,55,46,37,28,19,10,1},{63,54,45,36,27,18,9},{62,53,44,35,26,17},{61,52,43,34,25},{60,51,42,33},{59,50,41},{58,49},{57}};

	public static void main(String args[])
	{
		int solution[]=new int[8];
		int spos=0;
		Scanner s=new Scanner(System.in); //taking value
		System.out.print("Enter the position value in which you want to place your first queen: ");
		int prevqueen=s.nextInt();
		solution[spos++]=prevqueen;

		for(int k=0;k<7;k++)
		{
			System.out.println();
			System.out.print("Enter the position value in which you want to place your next queen: ");
			int currentqueen=s.nextInt();
			solution[spos++]=check(solution,currentqueen);
		}

		System.out.print("The Solution to Queen Problem is: ");
		for(int l:solution)
		{
			System.out.print(l+", ");
		}

	}

	static int check(int solution[],int currentqueen)
	{
		int pcolpos=0,prowpos=0,prdiagpos=0,pldiagpos=0,ccolpos=0,crowpos=0,crdiagpos=0,cldiagpos=0,count;
				//finding the position of previous queen

		int condition=1;
		while(condition!=0)
		{
			for(int previqueen:solution)
			{
				count=0;
				for(int i[]: column)
				{
					count++;
					for(int j:i)
					{
						if(previqueen==j)
							pcolpos=count;
					}
				}

				count=0;
				for(int i[]: row)
				{
					count++;
					for(int j:i)
					{
						if(previqueen==j)
							prowpos=count;
					}
				}

				count=0;
				for(int i[]: rdiag)
				{
					count++;
					for(int j:i)
					{
						if(previqueen==j)
							prdiagpos=count;
					}
				}

				count=0;
				for(int i[]: ldiag)
				{
					count++;
					for(int j:i)
					{
						if(previqueen==j)
							pldiagpos=count;
					}
				}

		//System.out.println(pcolpos+", "+prowpos+", "+prdiagpos+", "+pldiagpos);

				count=0;
				for(int i[]: column)
				{
					count++;
					for(int j:i)
					{
						if(currentqueen==j)
							ccolpos=count;
					}
				}

				count=0;
				for(int i[]: row)
				{
					count++;
					for(int j:i)
					{
						if(currentqueen==j)
							crowpos=count;
					}
				}

				count=0;
				for(int i[]: rdiag)
				{
					count++;
					for(int j:i)
					{
						if(currentqueen==j)
							crdiagpos=count;
					}
				}

				count=0;
				for(int i[]: ldiag)
				{
					count++;
					for(int j:i)
					{
						if(currentqueen==j)
							cldiagpos=count;
					}
				}

		//System.out.println(ccolpos+", "+crowpos+", "+crdiagpos+", "+cldiagpos);

				if(pcolpos==ccolpos||prowpos==crowpos||prdiagpos==crdiagpos||pldiagpos==cldiagpos)
				{
					System.out.print("You cannot place your queen in this position, please choose another position value: ");
					System.out.println();
					Scanner s=new Scanner(System.in);
					currentqueen=s.nextInt();
					condition=1;
					break;
				}
				else
				{
					condition=0;
				}
			}
			
		}

		return currentqueen;	

	}
}