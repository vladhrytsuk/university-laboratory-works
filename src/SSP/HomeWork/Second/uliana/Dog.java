package SSP.HomeWork.Second.uliana;

public class Dog extends Animal implements IAnimal {
    private String name;
    private int age;
    private double weight;
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void run() {
        System.out.println(this.name + " умеет бегать");
    }

    @Override
    public void jump() {
        if(this.weight < 10) {
            System.out.println(this.name + " высоко прыгает.");
        } else System.out.println(this.name + " прыгает.");

    }

    @Override
    public void sleep() {
        if(this.age < 4) {
            System.out.println(this.name + " умеет спать.");
        } else System.out.println(this.name + " в силу своего возраста долго спит.");

    }

    @Override
    public void eat() {
        if(this.weight < 10) {
            System.out.println(this.name + " мало ест.");
        } else System.out.println(this.name + " много ест.");
    }

    public static void main(String[] args) {
        Dog eli = new Dog("Эли", 3, 5.0, "Чихуа-хуа");
        System.out.println("Собака - Имя: " + eli.getName() + ", возраст: " + eli.getAge() + ", вес: " + eli.getWeight() + ", порода: " + eli.getBreed());
        eli.run();
        eli.jump();
        eli.sleep();
        eli.eat();
    }
}
