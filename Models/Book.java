package Models;

public abstract class Book implements IPublication {

    protected String title;
    protected String author;
    protected int pageCount;

    public Book() {
    }

    public Book(String title, String author, int pages) {
        this.author = author;
        this.pageCount = pages;
        this.title = title;
    }

    @Override
    public String toMyString() {
        return "| " + this.author + " | " + this.title + " | " + String.valueOf(this.pageCount);
    }
}
