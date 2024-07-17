/*class A{  //early instantiation
    private static A obj = new A();//Early, instance will be created at load time
    private A(){}

    public static A getA(){
        return obj;
    }

    public void doSomething(){
        System.out.println("Object 1 in eraly instatiation Do Something");
    }
}*/

class A{
    private static A instance;
    public static A getInstance(){
        if (instance == null){
            synchronized(A.class){ // syncronized due to when
                    instance = new A();//instance will be created at request time
            }
        }
        return instance;
    }
    public void doSomething(){
        System.out.println("Object in lazy installation Do something");
    }
}
public class SingletonDesignPattern {
    public static void main(String[] args) {
        /*A obj1 = A.getA();
        obj1.doSomething();
        System.out.println(obj1.hashCode());*/
        A obj2 = A.getInstance();
        obj2.doSomething();
        A obj3 = A.getInstance();
        obj3.doSomething();
        System.out.println(obj2.hashCode() == obj3.hashCode());

    }
}
