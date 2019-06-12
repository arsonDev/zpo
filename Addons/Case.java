package Addons;

import Decorator.BookDecorator;
import Models.IPublication;

public class Case extends BookDecorator {

    public Case(IPublication publication) throws Exception {
        super(publication);
    }

    @Override
    public String toMyString() {
        return super.toMyString() + " | Zwykła okładka";
    }
}
