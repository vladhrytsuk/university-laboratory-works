package IS.LabWork3.uliana;

public class Clothes extends Shop {

    private String type;

    public Clothes(String shopName, Double area, String type) {
        super(shopName, area);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
