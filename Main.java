import Addons.HardCase;
import Addons.Wrapper;
import Models.IPublication;
import Models.Publication;
import Models.Book;

public class Main {

    public static void main(String[] args) throws Exception {
        IPublication p1 = new Publication("Mickiewicz", "Dziady", 130);
        System.out.println(p1.toMyString());
        p1 = new HardCase(new Publication("Mickiewicz", "Pan tadeusz", 340));
        System.out.println(p1.toMyString());
        IPublication p2 = new Wrapper(new Publication("Mickiewicz", "Pan tadeusz", 340));
        System.out.println(p2.toMyString());

        PublishHouse pHouse = PublishHouse.GetInstance("Jozef Kraszewski");
        Book book = pHouse.CreateBook("Maslaw", 3000);
        System.out.println(book.toMyString());

    }
}
