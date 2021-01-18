import java.util.Scanner;

public class BookStore 
{
	Book[] books=new Book[10];
	
	public void sell(String bookTitle, int noOfCopies)
	{
		boolean bookFound=false;
		for(int i=0;i<10;i++)
		{	
			if(books[i].bookTitle.equals(bookTitle))
			{
				books[i].numOfCopies-=noOfCopies;
				bookFound=true;
				break;
			}
			
		}
		
		if(bookFound==false)
		{
			System.out.println("Book not found in inventory");
		}
	}
	
	public void order(String isbn, int noOfCopies)
	{
		Scanner sc= new Scanner(System.in);
		
		int i=0;
		boolean bookFound=false;
		for(i=0;i<10;i++)
		{
			if(books[i]==null)
			{
				System.out.println("Enter book title: ");
				String bookTitle= sc.nextLine();
				System.out.println("Enter author name: ");
				String author= sc.nextLine();
				books[i]=new Book(bookTitle, author, isbn, noOfCopies);
				break;
			}
			
			if(books[i].ISBN.equals(isbn))
			{
				bookFound=true;
			}
		
		
			if(i>9)
			{
				System.out.println("No Space");
				break;
			}
		
			if(bookFound)
			{
				books[i].numOfCopies+=noOfCopies;
				break;
			}
			
		}
	}
	
	
	public void display()
	{
		for(int i=0;i<10; i++)
		{
			if(books[i]==null)
				continue;
			
			books[i].display();
			System.out.println();
		}
	}
}
