import Models.Book;

public abstract class PublishHouse {

    public static PublishHouse GetInstance(String author) {
        if ("Jozef Kraszewski".equalsIgnoreCase(author)) {
            return new PublishingHouseHistorical(author);
        } else if ("Alex Michaelides".equalsIgnoreCase(author)) {
            return new PublishingHouseThriller(author);
        } else if ("Maslaw".equalsIgnoreCase(author)) {
            return new PublishingHousePoems(author);
        } else {
            return null;
        }
    }

    abstract Book CreateBook(String title, int pages);
}