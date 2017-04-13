package SSP.HomeWork.Second;

public class SoftwareDeveloper extends Employee implements IEmployee {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String placeOfWork;
    private String rank;
    private double rate;

    public SoftwareDeveloper(String firstName, String middleName, String lastName, int age, String placeOfWork, String rank, double rate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.rank = rank;
        this.rate = rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void kpi() {
        System.out.println("Ценный сотрудник!");
    }

    @Override
    public void informationAboutEmployee() {
        System.out.format("Ф.И.О: %s %s %s;\nВозраст: %d;\nМесто работы: %s;\nДолжность: %s;\nСтавка: %.2f;\n",
                this.getLastName(),
                this.getFirstName(),
                this.getMiddleName(),
                this.getAge(),
                this.getPlaceOfWork(),
                this.getRank(),
                this.getRate());
    }

    @Override
    public void workingHours() {
        if(this.getRate() == 1) {
            System.out.println("Время работы: 8 часов");
        } else if (this.getRate() == 0.5) {
            System.out.println("Время работы: 4 часа");
        } else if (this.getRate() == 0.25) {
            System.out.println("Время работы: 2 часа");
        }
    }

    public static void main(String[] args) {
        SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper(
                "Владислав",
                "Вячеславович",
                "Грицук",
                20,
                "EpolSoft",
                "Training",
                0.25
        );

        softwareDeveloper.informationAboutEmployee();
        softwareDeveloper.workingHours();
        softwareDeveloper.kpi();
    }


}
