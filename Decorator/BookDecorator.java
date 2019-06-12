package Decorator;

import Addons.Case;
import Addons.HardCase;
import Addons.Wrapper;
import Models.IPublication;

public abstract class BookDecorator implements IPublication {
    private IPublication publication;

    public BookDecorator(IPublication publication) {
        this.publication = publication;
    }

    @Override
    public String toMyString() {
        return publication.toMyString();
    }
}
