package task1.sweets;

public class Candy extends Sweet {
    private int chocolatePercentage;

    public Candy(String name, double weight, double price, int chocolatePercentage) {
        super(name, weight, price);
        this.chocolatePercentage = chocolatePercentage;
    }

    public int getChocolatePercentage() {
        return chocolatePercentage;
    }

    public void setChocolatePercentage(int chocolatePercentage) {
        this.chocolatePercentage = chocolatePercentage;
    }

    @Override
    public String toString() {
        return "Candy{" + super.toString() +
                "chocolatePercentage=" + chocolatePercentage +
                "} ";
    }
}
