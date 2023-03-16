class recursionsort
{
	static	int a[]={1,98,36,45,78,15,369,75498,9315,1232,647,56,12,4,9};
	static int count=0;
	static int recursion(int c)
	{
		if(c==a.length-1)
		{
			return 0;
		}
		else
		{
			display();
			return recursion(sort(a));
		}
	}

	static int sort(int n[])
	{
		int temp;
		count=0;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]>a[i+1])
			{
				temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
			}
			else
				count++;
		}
		return count;
	}

	public static void main(String args[])
	{
		recursion(0);
	}

	static void display()
	{
		System.out.print("[ ");
		for(int n:a)
		{
			System.out.print(n+", ");
		}
		System.out.print(" ]");
		System.out.println();
	}
}