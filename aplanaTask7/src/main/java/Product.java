public class Product {
    private String name;
    private double priceWithoutGurantee;
    private double price;
    private int guarantee;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public double getPriceWithoutGurantee() {
        return priceWithoutGurantee;
    }

    public void setPriceWithoutGurantee(double priceWithoutGurantee) {
        this.priceWithoutGurantee = priceWithoutGurantee;
    }
}
