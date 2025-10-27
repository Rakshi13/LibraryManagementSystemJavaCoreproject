import java.util.Scanner;

public class Books {

    public int count;
    Book[] theBooks = new Book[50];

    public void showMessage() {
        System.out.println("----------------------------------------------------------");
        System.out.println("PRESS 0 TO EXIT AN APPLICATION");
        System.out.println("PRESS 1 TO ADD A BOOK");
        System.out.println("PRESS 2 TO SEARCH A BOOK");
        System.out.println("PRESS 3 TO UPGRADE A QUANTITY OF BOOK");
        System.out.println("PRESS 4 TO SHOW ALL THE BOOKS");
        System.out.println("PRESS 5 TO REGISTER A STUDENT");
        System.out.println("PRESS 6 TO SHOW ALL THE REGISTERED STUDENTS");
        System.out.println("PRESS 7 TO CHECK OUT A BOOK");
        System.out.println("PRESS 8 TO CHECK IN A BOOK");
        System.out.println("----------------------------------------------------------");
    }

    public int compareBooks(Book a, Book b) {
        //compare book name

        if (a.bookName.equalsIgnoreCase(b.bookName)) {
            System.out.println("Book already exist.");
            return 0;
        }

        if (a.serialNumber == b.serialNumber) {
            System.out.println("Book already exist");
            return 0;
        }

        return 1;
    }

    public void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.compareBooks(b, this.theBooks[i]) == 0) {
                return;
            }
        }

        if (count < 50) {
            theBooks[count] = b;
            count++;
        } else {
            System.out.println("No space to add the book.");
        }

        System.out.println("Book added");
    }

    public void showAllBooks() {
        if (count == 0) {
            System.out.println("No Books Found.");
            return;
        }
        System.out.println("SerialNumber\t\tBookName\t\tAuthorName\t\tTotalQuantity");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(
                    theBooks[i].serialNumber + "\t\t\t\t" +
                            theBooks[i].bookName + "\t\t\t" +
                            theBooks[i].authorName + "\t\t\t" +
                            theBooks[i].bookQuantity
            );
        }
    }

    public void searchBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to search the serial number");
        System.out.println("Press 2 to search for Book name");

        int choice = input.nextInt();
        boolean bookfound = false;

        switch (choice) {
            case 1:
                System.out.println("Enter the Serial Number:");
                int sNo = input.nextInt();
                for (int i = 0; i < count; i++) {
                    if (sNo == theBooks[i].serialNumber) {
                        System.out.println("SerialNumber\t\tBookName\t\tAuthorName\t\tTotalQuantity");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(
                                theBooks[i].serialNumber + "\t\t\t\t" +
                                        theBooks[i].bookName + "\t\t\t" +
                                        theBooks[i].authorName + "\t\t\t" +
                                        theBooks[i].bookQuantity
                        );
                        bookfound = true;
                    }
                }
                if (!bookfound) {
                    System.out.println("No Books found for this serial No");
                }
                break;
            case 2:
                System.out.println("Enter the book name:");
                String bookNames = input.next();
                input.nextLine();
                boolean bookNameFound = false;

                for (int i = 0; i < count; i++) {
                    if (bookNames.equalsIgnoreCase(theBooks[i].bookName)) {
                        System.out.println("SerialNumber\t\tBookName\t\tAuthorName\t\tTotalQuantity");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(
                                theBooks[i].serialNumber + "\t\t\t\t" +
                                        theBooks[i].bookName + "\t\t\t" +
                                        theBooks[i].authorName + "\t\t\t" +
                                        theBooks[i].bookQuantity
                        );
                        bookNameFound = true;
                    }
                }
                if (!bookNameFound) {
                    System.out.println("No book found for this given Book name");
                }
                break;
            default:
                System.out.println("Please enter no between 1 and 2");
        }
    }

    public void updateQuantity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the serial Number of a book which you want to update.");
        int sNo = input.nextInt();
        boolean updateBookFound=false;

        if(count==0){
            System.out.println("No Books found.");
            return;
        }

        System.out.println("Enter the quantity to this book that you want to update.");
        int quantity = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].serialNumber) {
                theBooks[i].bookQuantity += quantity;
                updateBookFound=true;
                System.out.println("Updated the Total Quantity of this book.");
            }
        }
        if(!updateBookFound){
            System.out.println("No Books Found for the given serial Number.");
        }
    }

    public void checkInBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the serial no of the book to check-in");
        int srNo=input.nextInt();
        boolean checkin=false;

        for(int i=0;i<count;i++){
            if(srNo==theBooks[i].serialNumber){
                theBooks[i].bookQuantity++;
                checkin=true;
                System.out.println("This book "+srNo+" is checkedIn");
            }
        }
        if(checkin==false){
            System.out.println("No Books Found.");
        }
    }

    public void checkOutBook(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the serial no of the book to check-in");
        int srNo=input.nextInt();
        boolean checkin=false;

        for(int i=0;i<count;i++){
            if(srNo==theBooks[i].serialNumber){
                theBooks[i].bookQuantity--;
                checkin=true;
                System.out.println("This book "+srNo+" is checkedOut");
            }
        }
        if(checkin==false){
            System.out.println("No Books Found.");
        }
    }

}
