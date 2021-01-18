import java.util.Scanner;


public class BookStoreApp 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter option number: ");
		int option=sc.nextInt();
		sc.nextLine();
		BookStore bookStore= new BookStore();
		
		while(option!=0)
		{
			if(option==1)
			{
				bookStore.display();
			}
			
			else if(option==2)
			{
				System.out.println("Enter ISBN number: ");
				String isbn=sc.nextLine();
				System.out.println("Enter Copies number: ");
				int noOfCopies=sc.nextInt();
				
				bookStore.order(isbn, noOfCopies);
			}
			
			else if(option==3)
			{
				System.out.println("Enter Book Title: ");
				String bookTitle=sc.nextLine();
				System.out.println("Enter Copies number: ");
				int noOfCopies=sc.nextInt();
				
				bookStore.sell(bookTitle, noOfCopies);
			}
			
			System.out.println("Choose Option: ");
			option=sc.nextInt();
			sc.nextLine();
		}
		sc.close();
	}
}
