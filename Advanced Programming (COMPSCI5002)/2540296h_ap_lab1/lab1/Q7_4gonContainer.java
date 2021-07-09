import _4gons.*;
import shapes.Vec2d;

import java.util.ArrayList;

public class Q7_4gonContainer {
    public static void main(String[] args) {
        // Create an ArrayList and add the _4gons directly.
        ArrayList<_4gon> list = new ArrayList<>();

        list.add(new _4gon(new Vec2d(-3,2), new Vec2d(0,-1), new Vec2d(8, -1), new Vec2d(5,2)));
        list.add(new Parallelogram(new Vec2d(0,0), new Vec2d(10, 0), new Vec2d(14,4), new Vec2d(4, 4)));
        list.add(new Rectangle(new Vec2d(0,0), new Vec2d(2,0), new Vec2d(2,1), new Vec2d(0,1)));
        list.add(new Square(new Vec2d(0,0), new Vec2d(1,0), new Vec2d(1,1), new Vec2d(0,1)));

        for (_4gon shape: list) {
//            if (shape instanceof ValidityChecker) {
//                // Check whether the parallelograms and rectangle above is valid
//                ValidityChecker checker = (ValidityChecker) shape;
//                System.out.println(checker.isValid());
//            }
            System.out.println("(Perimeter: " + shape.perimeter() + ")");
        }
    }
}
