package Addons;

import Decorator.BookDecorator;
import Models.IPublication;

public class HardCase extends BookDecorator {

    public HardCase(IPublication publication) throws Exception {
        super(publication);
    }

    @Override
    public String toMyString() {
        return super.toMyString() + " | Twarda okładka";
    }
}
