import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        System.out.println("************************WELCOME TO THE COLLEGE LIBRARY************************");
        System.out.println(
                "                        SELECT FROM THE FOLLOWING OPTIONS                           ");

        System.out.println("*******************************************************************************");

        Scanner input=new Scanner(System.in);

        int choice;
        Books ob=new Books();

        do{
            ob.showMessage();
            choice=input.nextInt();

            switch(choice){
                case 1:
                    //add a book
                    Book b=new Book();
                    ob.addBook(b);
                    break;
                case 2:
                    //search a book
                    ob.searchBook();
                    break;
                case 3:
                    //update the total quantity of individual book
                    ob.updateQuantity();
                    break;
                case 4:
                    //show all the books
                    ob.showAllBooks();
                    break;
                case 5:
                    //check-in book
                    ob.checkInBook();
                    break;
                case 6:
                    //check-out-book
                    ob.checkOutBook();
                    break;
                default:
                    System.out.println("Please enter Number between 0 and 9");
                    break;
            }
        }while(choice!=0);
    }
}