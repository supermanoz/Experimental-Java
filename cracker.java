import java.util.Scanner;
class cracker
{
	public static void main(String args[])
	{
		System.out.print("Enter your password: ");
		Scanner s=new Scanner(System.in);
		String pw=s.nextLine();
		crack(pw);
	}

	public static void crack(String pass)
	{
		String pw=pass;
		int n=4;
		char password[]=new char[n];
		int varname[]={31,31,31,31};
		//for(int i=0;i<4;i++)
		//{
		int i=0;
			recursion(i,pw,password,varname);
		//}
	}

	public static int recursion(int size,String pw,char[] password, int[] varname)
	{
		String pwd="";
		if(size>=3)
		{
			while(varname[size]<=125)
			{
				varname[size]++;
				password[size]=(char)varname[size];
				pwd=new String(password);
				System.out.println(pwd);
				if(pwd.equals(pw))
				{
					System.out.println("The Password is "+pwd);
					return 0;
				}
			}

			size=0;
			while(varname[size]<=125)
			{
				varname[size]++;
				password[size]=(char)varname[size];		
				System.out.println("Now Running"+ varname[size]);
				
				pwd=new String(password);
				System.out.println(pwd);
				return recursion(++size,pw,password,varname);	
			}

			return 0;
		}

		else
		{
			while(varname[size]<=125)
			{
				varname[size]++;

				System.out.println("Running"+ varname[size]);
				password[size]=(char)varname[size];
				pwd=new String(password);
				System.out.println(pwd);
				return recursion(++size,pw,password,varname);
			}

			return 0;
		}
	}
}