import Models.Book;

public class PublishingHouseHistorical extends PublishHouse {

    private String author;

    public PublishingHouseHistorical(String author) {
        this.author = author;
    }

    @Override
    public Book CreateBook(String title, int pages) {
        // TODO Auto-generated method stub
        return new Historical(title, author, pages);
    }
}