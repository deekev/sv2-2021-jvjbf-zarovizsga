package shipping;

import java.util.*;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(p -> p.isBreakable() == breakable)
                .filter(p -> p.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable actual: packages) {
            String key = actual.getDestinationCountry();
            if (!result.containsKey(key)) {
                result.put(key, 1);
            } else {
                result.put(key, result.get(key) + 1);
            }
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(p -> p instanceof InternationalPackage)
                .sorted(Comparator.comparingInt(o -> ((InternationalPackage) o).getDistance()))
                .toList();
    }
}
