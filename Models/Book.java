package Models;

abstract class Book implements IPublication {

    protected String title;
    protected String author;
    protected int pageCount;

    @Override
    public String toMyString() {
        return "| "+this.author+" | "+this.title+" | "+String.valueOf(this.pageCount);
    }
}
