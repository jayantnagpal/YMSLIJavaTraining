
public class Book 
{
	String bookTitle;
	String author;
	String ISBN;
	int numOfCopies;
	
	Book(){}
	
	Book(String bookTitle, String author, String ISBN, int numOfCopies)
	{
		this.bookTitle=bookTitle;
		this.author=author;
		this.ISBN=ISBN;
		this.numOfCopies=numOfCopies;
	}
	
	void display()
	{
		System.out.println("Title: "+ this.bookTitle);
		System.out.println("Author: " + this.author);
		System.out.println("ISBN: " + this.ISBN);
		System.out.println("Number of Copies: " + this.numOfCopies);
	}
}
