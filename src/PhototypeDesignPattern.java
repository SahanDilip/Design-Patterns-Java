import java.util.Hashtable;

abstract  class Shapes implements Cloneable{ //to get the method clone implements clonable
    private String id;
    protected String type;
    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone(){  // retuns the bitwise copy of the current object using the clone method
        Object clone =  null; // try to clone an object that doent implement the cloneable that error must be handled
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
    public String getType() {
        return type;
    }
}

class circles extends Shapes {
    public circles(){
        type = "CIRCLE";
    }
    public void draw(){
        System.out.println("Inside the circle draw method");
    }
}

class rectangles extends Shapes {
    public rectangles(){
        type = "RECTANGLE";
    }
    public void draw(){
        System.out.println("Inside the rectangle draw method");
    }
}

class squares extends Shapes {

    public squares(){
        type = "SQUARE";
    }
    public void draw(){
        System.out.println("Inside the square draw method");
    }
}

class ShapeCache{
    private static Hashtable<String ,Shapes> shapeMap = new Hashtable<String,Shapes>();
    public static Shapes getShape(String shapeID){
        Shapes catchedshape = shapeMap.get(shapeID);
        return (Shapes) catchedshape.clone();
    }

    public static void LoadCatche(){
        circles circle1 = new circles();
        circle1.setId("1");
        shapeMap.put(circle1.getId(),circle1);
        squares square1 = new squares();
        square1.setId("2");
        shapeMap.put(square1.getId(),square1);
        rectangles rectangle1  = new rectangles();
        rectangle1.setId("3");
        shapeMap.put(rectangle1.getId(),rectangle1);
    }

}
public class PhototypeDesignPattern {
    public static void main(String[] args) {
        ShapeCache.LoadCatche();
        Shapes clonedShape = (Shapes) ShapeCache.getShape("1");
        System.out.println("Shapes " + clonedShape.getType());
        Shapes clonedShape2 = (Shapes) ShapeCache.getShape("2");
        System.out.println("Shapes " + clonedShape2.getType());
        Shapes clonedShape3 = (Shapes) ShapeCache.getShape("3");
        System.out.println("Shapes " + clonedShape3.getType());
    }

}
