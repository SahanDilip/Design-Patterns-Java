import java.awt.*;
import java.util.ArrayList;
import java.util.List;

interface Componenets{
    void showPrice();
}
class leaf implements Componenets{
    String name;
    int price;

    public leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println("Name : " + name +" Price " + price);
    }
}

class composite implements Componenets{
    String name;

    public composite(String name) {
        this.name = name;
    }
    List<Componenets> componenetsList =new ArrayList<>();

    public void addComponenet(Componenets com){
        componenetsList.add(com);
    }
    @Override
    public void showPrice() {
        System.out.println(name);
        for(Componenets c: componenetsList){
            c.showPrice();
        }
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {

    Componenets hard = new leaf("HDD",5000);
    Componenets keyboard = new leaf("KEYBOARD",2000);
    Componenets mouse = new leaf("MOUSE",1000);
    Componenets ram = new leaf("RAM",8000);
    composite motherboard = new composite("MOTHERBOARD");
    composite casing = new composite("CASING");

    motherboard.addComponenet(ram);
    motherboard.addComponenet(hard);
    casing.addComponenet(motherboard);

    keyboard.showPrice();
    mouse.showPrice();
    motherboard.showPrice();
    casing.showPrice();

    }
}
