import java.util.Scanner;

public class Book {
    public int serialNumber;
    public String bookName;
    public String authorName;
    public int bookQuantity;

    Scanner input=new Scanner(System.in);

    public Book(){
        System.out.println("Enter the Serial Number of the Book.");
        this.serialNumber=input.nextInt();
        input.nextLine();

        System.out.println("Enter the book Name.");
        this.bookName=input.nextLine();

        System.out.println("Enter the Author Name");
        this.authorName=input.nextLine();

        System.out.println("Enter the Quantity of a Book.");
        this.bookQuantity=input.nextInt();

    }
}
