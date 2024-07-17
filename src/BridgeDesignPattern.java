interface ObjectShapes{
    public void draw(int radius);
}
class CircleObj implements ObjectShapes{
    @Override
    public void draw(int radius) {
        System.out.println("Drawing Circle with radius: "+ radius);
    }
}

class TriangleObj implements ObjectShapes{
    public void draw(int radius) {
        System.out.println("Drawing Circle colour : Red, radius: "+ radius + " & centre co-ordinates " +x+","+y);
    }
}

abstract class shapes{
    protected Draw draw;
    protected shapes(Draw drawAPI){
        this.draw = drawAPI;
    }

    public abstract void draw();
}
class Circle extends shapes{
    private int x,y,radius;
    public Circle(int x,int y, int radius,Draw drawAPI){
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        draw.drawcircle(radius,x,y);
    }
}

public class BridgeDesignPattern {
    public static void main(String[] args) {
        shapes redCircle = new Circle(100,100,10,new RedCircle());
        shapes greenCircle = new Circle(100,100,10,new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}

