public class GoldenEditionBook extends Book {


    public GoldenEditionBook(String author, String name, double price) {
        super(author, name, price);
    }

    @Override
    public void setPrice(double price) {
        double goldenPrice =price +(price * 0.30);
        super.setPrice(goldenPrice);
    }
}
