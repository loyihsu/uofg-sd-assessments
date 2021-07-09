import _4gons.*;
import shapes.Vec2d;

import java.util.ArrayList;

public class Q8_4gonContainer {
    public static void main(String[] args) {
        // Create an ArrayList and add the _4gons with a helper method.
        ArrayList<_4gon> list = new ArrayList<>();

        add4gonToList(list, new _4gon(new Vec2d(-3,2), new Vec2d(0,-1), new Vec2d(8, -1), new Vec2d(5,2)));
        add4gonToList(list, new Parallelogram(new Vec2d(0,0), new Vec2d(10, 0), new Vec2d(14,4), new Vec2d(4, 4)));
        add4gonToList(list, new Rectangle(new Vec2d(0,0), new Vec2d(2,0), new Vec2d(2,1), new Vec2d(0,1)));
        add4gonToList(list, new Square(new Vec2d(0,0), new Vec2d(1,0), new Vec2d(1,1), new Vec2d(0,1)));

        testIfConvexLiternals();    // Demo the correctness of the convex checking method.

        // Not convex and convex test.
        add4gonToList(list, new _4gon(new Vec2d(5,-5), new Vec2d(1,-6), new Vec2d(7, -7), new Vec2d(6,-1)));  // Not a convex 4gon, should fail
        add4gonToList(list, new _4gon(new Vec2d(7,-8), new Vec2d(5,2), new Vec2d(-3, -4), new Vec2d(-2,-7))); // A convex 4gon, should success

        for (_4gon shape: list) {
            System.out.println("(Perimeter: " + shape.perimeter() + ")");
        }
    }

    // Test function to demo the correctness of two sample quadrilaterals.
    private static void testIfConvexLiternals() {
        _4gon notConvex = new _4gon(new Vec2d(5,-5), new Vec2d(1,-6), new Vec2d(7, -7), new Vec2d(6,-1));   // Re-creation of the sample non-convex
        _4gon convex = new _4gon(new Vec2d(7,-8), new Vec2d(5,2), new Vec2d(-3, -4), new Vec2d(-2,-7));     // Re-creation of the sample convex

        System.out.println(checkConvexQuadrilateral(notConvex.a, notConvex.b, notConvex.c, notConvex.d));   // should be false
        System.out.println(checkConvexQuadrilateral(convex.a, convex.b, convex.c, convex.d));               // should be true
    }

    // Helper method to add a _4gon to the list.
    private static void add4gonToList(ArrayList<_4gon> list, _4gon item) {
        // Check whether it is a convex quadrilateral with helper method.
        if (checkConvexQuadrilateral(item.a, item.b, item.c, item.d)) {
            list.add(item);
        }
    }

    // It uses a helper method to calculate the cross product two vectors formed by three points.
    // If a convex 4gon, four cross products should be the same sign.
    private static boolean checkConvexQuadrilateral(Vec2d p, Vec2d q, Vec2d r, Vec2d s) {
        int trues = 0, falses = 0;
        boolean[] muls = {(crossProduct(p, q, r) >= 0), (crossProduct(q, r, s) >= 0),
                (crossProduct(r, s, p) >= 0), (crossProduct(s, p, q) >= 0)} ;
        for (boolean mul: muls) {
            if (mul) trues++;
            else falses++;
        }
        return (trues * falses == 0);
    }

    // A helper method that gets three points and calculate cross product of the two vectors formed by them.
    private static double crossProduct(Vec2d p, Vec2d q, Vec2d r) {
        Vec2d pq = new Vec2d(p.getX()-q.getX(), p.getY() - q.getY());
        Vec2d qr = new Vec2d(q.getX()-r.getX(), q.getY() - r.getY());
        return pq.getX() * qr.getY() - pq.getY() * qr.getX();
    }
}