package lab2;
public class LibraryTest {

    abstract static class LibraryItem {
        private String title;
        private String author;
        private int year;

        public LibraryItem(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public int getYear() { return year; }

        @Override
        public String toString() {
            return "Item[title='" + title + "', author='" + author + "', year=" + year + "]";
        }
    }

    static class Book extends LibraryItem {
        private int pages;

        public Book(String title, String author, int year, int pages) {
            super(title, author, year);
            this.pages = pages;
        }

        public int getPages() { return pages; }

        @Override
        public String toString() {
            return "Book" + super.toString().substring(4) + ", pages=" + pages + "]";
        }
    }

    static class Magazine extends LibraryItem {
        private int issueNumber;

        public Magazine(String title, String author, int year, int issue) {
            super(title, author, year);
            this.issueNumber = issue;
        }

        public int getIssueNumber() { return issueNumber; }

        @Override
        public String toString() {
            return "Magazine" + super.toString().substring(4) + ", issue=" + issueNumber + "]";
        }
    }

    public static void main(String[] args) {
        LibraryItem b = new Book("Java Guide", "Gosling", 2023, 450);
        LibraryItem m = new Magazine("Tech World", "Editor Team", 2025, 7);

        System.out.println(b);
        System.out.println(m);
    }
}