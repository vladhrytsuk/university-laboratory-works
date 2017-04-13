package IS.LabWork3.uliana;

public class Employee extends Clothes {

    private String name;
    private int age;
    private String speciality;

    public Employee(String shopName, Double area, String type, String name, int age, String speciality) {
        super(shopName, area, type);
        this.name = name;
        this.age = age;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Veore Clothing", 100.5, "Свадебные платья", "Пастушенко Ульяна Викторовна", 20, "Швея");
        System.out.println("Название магазина: " + e.getShopName() +
                           "\nПлощадь магазина: " + e.getArea() +
                           "\nМагазин продаёт: " + e.getType() +
                           "\nФ.И.О сотрудника: " + e.getName() +
                           "\nВозраст сотрудника: " + e.getAge() +
                           "\nСпециальность сотрудника: " + e.getSpeciality());
    }
}
