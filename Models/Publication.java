package Models;

public class Publication extends Book {

    public Publication(String author,String title, int pageCount) {
        this.author = author;
        this.pageCount = pageCount;
        this.title = title;
    }
}
