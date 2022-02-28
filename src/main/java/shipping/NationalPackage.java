package shipping;

public class NationalPackage implements Transportable {

    private static final int SHIPPING_FEE = 1000;
    private static final int BREAKABLE_MULTIPLIER = 2;

    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) {
            return SHIPPING_FEE * BREAKABLE_MULTIPLIER;
        }
        return SHIPPING_FEE;
    }
}
