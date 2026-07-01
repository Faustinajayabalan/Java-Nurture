class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + " | " + title + " | " + author);
    }
}

public class Exercise6_LibraryManagement {

    static void linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found using Linear Search:");
                b.display();
                return;
            }
        }
        System.out.println("Book not found");
    }

    static void binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = title.compareToIgnoreCase(books[mid].title);

            if (result == 0) {
                System.out.println("Book Found using Binary Search:");
                books[mid].display();
                return;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "Data Structures", "Mark Allen"),
                new Book(102, "Java Programming", "James Gosling"),
                new Book(103, "Operating System", "Galvin"),
                new Book(104, "Python Basics", "Guido")
        };

        linearSearch(books, "Java Programming");

        System.out.println();

        binarySearch(books, "Operating System");
    }
}