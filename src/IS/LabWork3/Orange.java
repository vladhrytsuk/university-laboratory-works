package IS.LabWork3;


public class Orange extends Fruit {
    private String color;

    public Orange(int weight, String type, String color) {
        super(weight, type);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Orange orange = new Orange(20, "Цитрус", "Красное");
        System.out.println("weight: " + orange.getWeight() + "\n" + "type: " + orange.getType() + "\n" + "color: " + orange.getColor());
    }
}
