package task1.sweets;

public class Jellybean extends Sweet {
    private String flavor;

    public Jellybean(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Jellybean{" + super.toString() +
                "flavor=" + flavor +
                "} ";
    }
}
