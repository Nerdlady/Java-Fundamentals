public class Book {
    private String name;
    private double price;
    private String author;

    public Book(String author,String name,  double price) {
        this.setName(name);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String[] names = author.split("\\s+");
        if (names.length > 1) {
            if (Character.isDigit(names[1].charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("Title: ").append(this.getName()).append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor()).append(System.lineSeparator())
                .append("Price: ").append(this.getPrice()).append(System.lineSeparator());
        return sb.toString();
    }

}
