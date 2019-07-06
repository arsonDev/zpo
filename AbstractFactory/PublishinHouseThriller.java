import Models.Book;

public class PublishingHouseThriller extends PublishHouse {

    private String author;

    public PublishingHouseThriller(String author) {
        this.author = author;
    }

    @Override
    public Book CreateBook(String title, int pages) {
        // TODO Auto-generated method stub
        return new Thriller(title, author, pages);
    }
}