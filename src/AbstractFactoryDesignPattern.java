import org.w3c.dom.ls.LSOutput;
import java.awt.*;

interface Shape{
    void draw();
}

interface Colour{
    void fill();
}

class circle implements Shape{
    public void draw(){
        System.out.println("Inside the circle draw method");
    }
}

class rectangle implements Shape{
    public void draw(){
        System.out.println("Inside the rectangle draw method");
    }
}

class square implements Shape{
    public void draw(){
        System.out.println("Inside the square draw method");
    }
}

class red implements Colour{
    @Override
    public void fill() {
        System.out.println("Inside the red fill method");
    }
}

class  blue implements Colour{
    public void fill() {
        System.out.println("Inside the blue fill method");
    }

}

class green implements Colour{
    public void fill() {
        System.out.println("Inside the green fill method");
    }

}

abstract class abstractFactory{
    abstract Colour getColour(String Colour);
    abstract Shape getShape(String Shape);

}

class shapeFactory extends abstractFactory{
    public Shape getShape(String shape){
        if(shape == null) {
            return null;
        } else if (shape.equals("CIRCLE")) {
            return new circle();
        } else if (shape.equals("RECTANGLE")) {
            return new rectangle();
        } else if (shape.equals("SQUARE")) {
            return new square();
        }
        return null;
    }

    @Override
    public Colour getColour(String Colour) {
        return null;
    }
}

class colourFactory extends abstractFactory{
    public Colour getColour(String colour){
        if (colour == null){
            return null;
        } else if (colour.equals("RED")) {
            return new red();
        } else if (colour.equals("BLUE")) {
            return new blue();
        } else if (colour.equals("GREEN")) {
            return new green();
        }
        return null;
    }

    @Override
    public Shape getShape(String Shape) {
        return null;
    }
}

class factoryProducer{
    public static abstractFactory getFactory(String choice) {
        if(choice.equals("SHAPE")){
            return new shapeFactory();
        }
        if(choice.equals("COLOUR")){
            return new colourFactory();
        }
        return null;
    }
}
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        abstractFactory shapeFactory = factoryProducer.getFactory("SHAPE");


        Shape shape1 = shapeFactory.getShape("CIRCLE");
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        Shape shape3 = shapeFactory.getShape("SQUARE");

        abstractFactory colourFactory = factoryProducer.getFactory("COLOUR");

        Colour colour1 = colourFactory.getColour("RED");
        Colour colour2 = colourFactory.getColour("GREEN");
        Colour colour3 = colourFactory.getColour("BLUE");

        shape1.draw();
        shape2.draw();
        colour1.fill();
        colour2.fill();

    }
}
