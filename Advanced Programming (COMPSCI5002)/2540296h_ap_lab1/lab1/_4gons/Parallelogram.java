package _4gons;

import shapes.Vec2d;

public class Parallelogram extends _4gon implements ValidityChecker {

    public Parallelogram(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
        super(a, b, c, d);  // reuse the constructor function
    }

    public boolean isValid() {
        // Checking if this is a valid parallelogram.
        // It uses vectors to check whether both sides are parallel.

        Vec2d ab = new Vec2d(a.getX() - b.getX(), a.getY() - b.getY());
        Vec2d dc = new Vec2d(d.getX() - c.getX(), d.getY() - c.getY());

        // This should be equal if it is parallel.
        if (ab.getX() * dc.getY() != ab.getY() * dc.getX()) return false;

        Vec2d bc = new Vec2d(b.getX() - c.getX(), b.getY() - c.getY());
        Vec2d ad = new Vec2d(a.getX() - d.getX(), a.getY() - d.getY());

        // This should be equal if it is parallel.
        if (bc.getX() * ad.getY() != bc.getY() * ad.getX()) return false;

        return true;
    }

    @Override
    public float area() {
        return super.area();        // Use the generic implementation to calculate the area.
    }

    public static void main(String[] args) {
        // Tests for isValid()
        Parallelogram par = new Parallelogram(new Vec2d(-3, 2), new Vec2d(0, -1), new Vec2d(8, -1), new Vec2d(5, 2));
        System.out.println(par.isValid());    // Should be true

        Parallelogram pp = new Parallelogram(new Vec2d(7, -8), new Vec2d(5, 2), new Vec2d(-3, -4), new Vec2d(-2, -7));
        System.out.println(pp.isValid());    // Should be false
    }
}
