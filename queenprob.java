import java.util.Scanner;
class queenprob
{

	public static int column[][]={{0,1,9,17,25,33,41,49,57},{0,2,10,18,26,34,42,50,58},{0,3,11,19,27,35,43,51,59},{0,4,12,20,28,36,44,52,60},{0,5,13,21,29,37,45,53,61},{0,6,14,22,30,38,46,54,62},{0,7,15,23,31,39,47,55,63},{0,8,16,24,32,40,48,56,64}};
	public static int row[][]={{0,1,2,3,4,5,6,7,8},{0,9,10,11,12,13,14,15,16},{0,17,18,19,20,21,22,23,24},{0,25,26,27,28,29,30,31,32},{0,33,34,35,36,37,38,39,40},{0,41,42,43,44,45,46,47,48},{0,49,50,51,52,53,54,55,56},{0,57,58,59,60,61,62,63,64}};
	public static int rdiag[][]={{0,1},{0,9,2},{0,17,10,3},{0,25,18,11,4},{0,33,26,19,12,5},{0,41,34,27,20,13,6},{0,49,42,35,28,21,14,7},{0,57,50,43,36,29,22,15,8},{0,58,51,44,37,30,23,16},{0,59,52,45,38,31,24},{0,60,53,46,39,32},{0,61,54,47,40},{0,62,55,48},{0,63,56},{0,64}};
	public static int ldiag[][]={{0,8},{0,16,7},{0,24,15,6},{0,32,23,14,5},{0,40,31,22,13,4},{0,48,39,30,21,12,3},{0,56,47,38,29,20,11,2},{0,64,55,46,37,28,19,10,1},{0,63,54,45,36,27,18,9},{0,62,53,44,35,26,17},{0,61,52,43,34,25},{0,60,51,42,33},{0,59,50,41},{0,58,49},{0,57}};
	public static int spos=0;
	public static int previousPlacement[]=new int[64];
	public static int previousplace=0;
	public static int solution[]=new int[1000];
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in); //taking value
		System.out.print("Enter the position value in which you want to place your first queen: ");
		int prevqueen=s.nextInt();
		solution[spos++]=prevqueen;

		while(spos<solution.length && (solution[0]==0||solution[1]==0||solution[2]==0||solution[3]==0||solution[4]==0||solution[5]==0||solution[6]==0||solution[7]==0))
		{
			if(placeQueen(solution,spos,0)>0)
			{
				System.out.println(solution[spos++]=placeQueen(solution,spos,0));
			}
		}

		/*solution=recur(solution,spos,1,0);*/

		System.out.print("The Solution to Queen Problem is: ");
		for(int l:solution)
		{
			System.out.print(l+", ");
		}

	}

	/*int recur[](int solution[],int spos,int newPlacement,int placementCount)
	{
		if(spos<8 || placementCount!=64)
		{
			solution[spos++]=placeQueen(solution,spos,newPlacement);
			return recur(solution,spos,1,placementCount++);
		}
		else if(spos<8 || placementCount==64)
		{

		}
		else
			return solution;
	}*/

	static int placeQueen(int solution[], int spos,int placement)
	{
			/*System.out.println();
			System.out.print("Entering the position value in which you might want to place your next queen: ");*/
			placement++;
			return check(solution,spos,placement);
	}

	static int check(int solution[],int spos,int currentqueen)
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
						if(previqueen==j)
							prowpos=count;

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
						if(previqueen==j)
							prdiagpos=count;

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
						if(previqueen==j)
							pldiagpos=count;

						if(currentqueen==j)
							cldiagpos=count;
					}
				}

				if((pcolpos==ccolpos||prowpos==crowpos||prdiagpos==crdiagpos||pldiagpos==cldiagpos)&&currentqueen<65)
				{
					/*System.out.print("You cannot place your queen in this position, choosing another position value: ");
					System.out.println();*/
					currentqueen++;
					for(int val:previousPlacement)
					{
						if(val==currentqueen)
						{
							currentqueen++;
						}
					}
					condition=1;
					break;
				}
				else if((pcolpos==ccolpos||prowpos==crowpos||prdiagpos==crdiagpos||pldiagpos==cldiagpos)&&currentqueen>=65)
				{
					spos--;
					for(int i:previousPlacement)
					{
						if(i==solution[spos])
						{
							previousplace--;
							break;
						}
						previousPlacement[previousplace]=solution[spos];
					}
					previousplace++;
					solution[spos]=0;
					currentqueen=1;
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