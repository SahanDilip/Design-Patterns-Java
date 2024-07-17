class Builder {
    private String name;
    private String city;
    private int year;
    private int age;
    private float balance;

    public Builder(String name, String city, int year, int age, float balance) {
        this.name = name;
        this.city = city;
        this.year = year;
        this.age = age;
        this.balance = balance;
    }
    public String toString(){
        return "Deatails[name = " +name + ",city = " +city + ",year = " + year + ",age = " + age + ",balance = "  + balance +  "]";
    }

}

class BuilderBody{
    private String name;
    private String city;
    private int year;
    private int age;
    private float balance;


    public BuilderBody setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderBody setCity(String city) {
        this.city = city;
        return this;
    }

    public BuilderBody setYear(int year) {
        this.year = year;
        return this;
    }

    public BuilderBody setAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderBody setBalance(float balance) {
        this.balance = balance;
        return this;
    }

    public Builder getBuilder(){
        return  new Builder(name,city,year,age,balance);
    }
}

public class Operate{
    public static void main(String[] args) {
        Builder obj1 = new BuilderBody().setName("vgsgv").setCity("fghfhsj").setAge(20).setBalance(2214.42F).getBuilder();
        Builder obj2 = new BuilderBody().setAge(76).setCity("Matara").setBalance(84.0F).getBuilder();
        Builder obj3 = new BuilderBody().setAge(7).setCity("Matara").setYear(45).getBuilder();
        System.out.println( obj1.toString());
        System.out.println( obj2.toString());
        System.out.println( obj3.toString());
    }
}