


interface OS{
    public void showfeature();
}

class Windows implements OS{
    @Override
    public void showfeature() {
        System.out.println("This is a open sources");
    }
}

class Andriod implements OS{
    @Override
    public void showfeature() {
        System.out.println("Frequentlyused");
    }
}
class Mac implements OS{
    @Override
    public void showfeature() {
        System.out.println("Highspeed");
    }
}

class Factory {
    String str;

    public static OS createFactory(String str) {
        if (str.equalsIgnoreCase("Open")) {
            return new Windows();
        } else if (str.equalsIgnoreCase("Frequentlyused")) {
            return new Andriod();
        } else if (str.equalsIgnoreCase("Highspeed")) {
            return new Mac();
        }
        return null;
    }
}

public class FactoryMethodDesignPattern {

    public static void main(String[] args) {
        OS obj1 = Factory.createFactory("open");
        OS obj2 = Factory.createFactory("highspeed");
        obj1.showfeature();
        obj2.showfeature();
    }
}
