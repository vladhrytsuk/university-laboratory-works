package IS.LabWork3;


public class Fruit extends Plant{

    private String type;

    public Fruit(int weight, String type) {
        super(weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
