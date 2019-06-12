package Addons;

import Decorator.BookDecorator;
import Models.IPublication;

public class Wrapper extends BookDecorator {

    public Wrapper(IPublication publication) throws Exception {

            super(publication);
        if ((publication instanceof HardCase) || (publication instanceof Case))
            throw new Exception("blad");
    }

    @Override
    public String toMyString() {
        return super.toMyString() + " | Z obwolutą";
    }
}
