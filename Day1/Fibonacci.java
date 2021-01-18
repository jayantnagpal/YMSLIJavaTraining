
public class Fibonacci 
{
	public static void main(String[] args) 
	{
		int temp, a=1,b=1;
		float sum=1;
		System.out.println(a);
		for(int i=0;i<19;i++)
		{
			System.out.println(b);
			sum+=b;
			temp=b;
			b=a+b;
			a=temp;
			
		}
		
		System.out.println(sum/20);
	}
}
