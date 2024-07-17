class SingleObject{
    SingleObject(){}
    private static SingleObject instance = new SingleObject();
    public static SingleObject getInstance(){
        return instance;
    }

    public void showSomeText(){
        System.out.println("Hellow");
    }
}

public class Main {
    public static void main(String[] args) {
        SingleObject obj = SingleObject.getInstance();
        System.out.println("Hello world!");
        obj.showSomeText();
    }
}