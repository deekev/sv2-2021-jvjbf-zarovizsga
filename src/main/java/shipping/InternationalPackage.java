package shipping;

public class InternationalPackage implements Transportable {

    private static final int SHIPPING_FEE = 1200;
    private static final int BREAKABLE_MULTIPLIER = 2;
    private static final int KM_FEE = 10;

    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) {
            return SHIPPING_FEE * BREAKABLE_MULTIPLIER + (distance * KM_FEE);
        }
        return SHIPPING_FEE + (distance * KM_FEE);
    }
}
