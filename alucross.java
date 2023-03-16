//Created by Manoj Basnet on 4-22-2020 6:39

import java.util.Scanner;
import java.util.Random;


class alucross
{
	public static void main(String args[])
	{	

		char board[][]={{' ','|',' ','|',' '},
						{'-',' ','-',' ','-'},
						{' ','|',' ','|',' '},
						{'-',' ','-',' ','-'},
						{' ','|',' ','|',' '},
		};
		createBoard(board);
		place(board);

	}

	public static void createBoard(char[][] a)
	{
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	public static void place(char[][] board)
	{
		char alucross;
		int placement=0;
		int userpos[]=new int[5];
		int cpupos[]=new int[5];
		int temp[]={0,0,0,0,0,0,0,0,0};
		int l=0;
		int k=0;
		for(int a=0;a<9;a++)
		{
			if(a%2==0){
				alucross='X';
				Scanner s=new Scanner(System.in);
				System.out.println("Enter your placement (1-9): ");
				placement=s.nextInt();
				int num1=0;
				int b=0;
				while(b<9)
				{
						num1=checkUser(temp,placement,b);
						if(num1!=placement)
						{
							placement=num1;
							b=-1;
						}
						b++;
				}
				switch_val(board,placement,alucross);
				createBoard(board);
				temp[a]=placement;
				userpos[l]=temp[a];
				l++;

				if((winner(userpos))==1) 
				{
					System.out.println("Congratulation on winning the game!");
					break;
				}
			}	

			else{
				alucross='O';
				Random rand=new Random();
				System.out.println("CPU plays this: ");
				placement=rand.nextInt(9)+1;
				int num=0;
				int c=0;
				while(c<9)
				{
					num=checkCpu(temp,placement,c);
					if(num!=placement)
					{
						placement=num;
						c=-1;
					}
					c++;	
				}
				switch_val(board,placement,alucross);
				createBoard(board);
				temp[a]=placement;
				cpupos[k]=placement;
				k++;
				if((winner(cpupos))==1)
				{
					System.out.println("You Lost Bitch!");
					break;
				}
			}

		}

	}

	public static int checkUser(int[] temp, int placement,int b)
	{
					if(placement!=temp[b])
					{
						return placement;
					}

					else
					{
						System.out.println("The placement has already been made! Try another: ");
						Scanner s=new Scanner(System.in);
						int replacement=s.nextInt();
						return checkUser(temp,replacement,0);

					}

	}

		public static int checkCpu(int[] temp, int placement,int b)
	{
					if(placement!=temp[b])
					{
						return placement;
					}

					else
					{
						Random rand=new Random();
						int replacement=rand.nextInt(9)+1;
						return checkCpu(temp,replacement,0);
					}

	}

	public static void switch_val(char[][] board, int placement,char alucross)
	{
		
			switch(placement)
			{
				case 1:
				board[0][0]=alucross;
				break;
				case 2:
				board[0][2]=alucross;
				break;
				case 3:
				board[0][4]=alucross;
				break;
				case 4:
				board[2][0]=alucross;
				break;
				case 5:
				board[2][2]=alucross;
				break;
				case 6:
				board[2][4]=alucross;
				break;
				case 7:
				board[4][0]=alucross;
				break;
				case 8:
				board[4][2]=alucross;
				break;
				case 9:
				board[4][4]=alucross;
				break;
				default:
				break;
			}		
	}

	public static int winner(int[] pos)
	{
		int pat[][]={{1,2,3},
					 {4,5,6},
					 {7,8,9},
					 {1,4,7},
					 {2,5,8},
					 {3,6,9},
					 {1,5,9},
					 {3,5,7},
		};
		int count=0;
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<3;k++)
				{
					if(pos[j]==pat[i][k])
						count++;
				}
				if(count>=3)
					return 1;
			}	
			count=0;		
		}
		return 0;
	}
}

//The game was officially finished creating on 4-22-2020 10:26