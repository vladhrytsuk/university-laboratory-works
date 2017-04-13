package IS.LabWork1;

import java.util.HashMap;
import java.util.Map;

public class City {

    private String name;
    private Map<String, Double> range = new HashMap<>();

    public City(String name, Map<String, Double> range) {
        this.name = name;
        this.range = range;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getRange() {
        return range;
    }

    public void setRange(Map<String, Double> range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        return range != null ? range.equals(city.range) : city.range == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", range=" + range +
                '}';
    }
}
