
interface Mammal{
    void drinkMilk();
}
class Human implements Mammal{
    public void drinkMilk(){
        System.out.println("Human is Drinking Milk");
    }
}

class Zebra implements  Mammal{
    public void drinkMilk(){
        System.out.println("Zebra is Drinking milk");
    }

}
class factory{
    public static Mammal get(String Mamaltype){
        if(Mamaltype.equals("Human"))
        {
            return new Human();
        }

        else if(Mamaltype.equals("Zebra"))
        {
            return  new Zebra();
        }
        else
        {
            return null;
        }

    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Mammal obj1 = factory.get("Zebra");
        Mammal obj2 = factory.get("Human");
        obj1.drinkMilk();


        obj2.drinkMilk();
    }

}