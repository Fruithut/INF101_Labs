package inf101.v17.lab6;

import inf101.v17.lab6.shapes.a.CircleA;
import inf101.v17.lab6.shapes.a.LineA;
import inf101.v17.lab6.shapes.a.RectangleA;

/**
 * Created by Olav_ on 07/04/2017.
 */
public class ShapeMain {
    public static void main(String[] args) {
        CircleA firstCircle = new CircleA(3.14);
        System.out.println("Circle has radius: " + firstCircle.getRadius() + ", area=" + firstCircle.getArea() +
                           ", circumference=" + firstCircle.getCircumference());
        System.out.println("Circle's sizebox has width=" + firstCircle.getSizeBox().getWidth() + ", height=" +
                           firstCircle.getSizeBox().getHeight() + ", area=" + firstCircle.getSizeBox().getArea() +
                           ", circumference=" + firstCircle.getSizeBox().getCircumference());

        RectangleA firstRectangle = new RectangleA(10, 20);
        System.out.println("Rectangle has width: " + firstRectangle.getWidth() + ", height=" + firstRectangle.getHeight() +
                           ", area=" + firstRectangle.getArea() + ", circumference=" + firstRectangle.getCircumference());


        LineA firstLine = new LineA(20);
        System.out.println("Line has length: " + firstLine.getLength() + ", circumference=" + firstLine.getCircumference());
    }
}
