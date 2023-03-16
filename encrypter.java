import java.util.Scanner;
class BT_ende
{
	public static void main(String args[])
	{
		System.out.println("Would you like to encrypt or decrypt? (e/d)");
		Scanner s=new Scanner(System.in);
		int condition=1;
		while(condition==1){
			char choice=s.nextChar();
			Switch(choice){
				case e:
				condition=0;
				encrypter();
				break;

				case d:
				condition=0;
				decrypter();
				break;

				default:
				condition=1;
				System.out.println("Invalid selection, please try again!");
		}
		}
	}

	public static void encrypter()
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the String that you would like to encrypt: ");
		String str=s1.nextLine();
		char[] chars=str.toCharArray();
		System.out.print("The encrypted String hence is: ");
		for(char c:chars)
		{
			c=(char)(c+5);
			System.out.print(c);
		}
	}

	public static void decrypter()
	{
		Scanner s2=new Scanner(System.in);
		System.out.println("Enter the String that you would like to decrypt: ");
		String str=s2.nextLine();
		char[] chars=str.toCharArray();
		System.out.print("The decrypted String hence is: ");
		for(char c:chars)
		{
			c=(char)(c-5);
			System.out.print(c);
		}
	}
}