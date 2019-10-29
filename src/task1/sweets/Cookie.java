package task1.sweets;

public class Cookie extends Sweet {
    private boolean withNuts;

    public Cookie(String name, double weight, double price, boolean withNuts) {
        super(name, weight, price);
        this.withNuts = withNuts;
    }

    public boolean isWithNuts() {
        return withNuts;
    }

    public void setWithNuts(boolean withNuts) {
        this.withNuts = withNuts;
    }

    @Override
    public String toString() {
        return "Cookie{" + super.toString() +
                "withNuts=" + withNuts +
                "} ";
    }
}
