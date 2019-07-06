import Models.Book;

public class PublishingHousePoems extends PublishHouse {

    private String author;

    public PublishingHousePoems(String author) {
        this.author = author;
    }

    @Override
    public Book CreateBook(String title, int pages) {
        // TODO Auto-generated method stub
        return new Poem(title, author, pages);
    }
}