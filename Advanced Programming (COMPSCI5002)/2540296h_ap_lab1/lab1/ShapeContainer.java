import shapes.AbstractShape;
import shapes.Circle;
import shapes.RectangleShape;
import shapes.Vec2d;

import java.util.*;

public class ShapeContainer {

    public static void main(String[] args) {
        Set<AbstractShape> shapes = new HashSet<>();

        shapes.add(new Circle(new Vec2d(1, 1), 2));
        shapes.add(new RectangleShape(
                new Vec2d(0, 0),
                new Vec2d(1, 0),
                new Vec2d(0, 1),
                new Vec2d(1, 1)
        ));

        // Print area of each shape
        System.out.println("Printing out areas...");

        for (AbstractShape s: shapes) {
            s.area();
        }

    }
}
