package _4gons;

import shapes.Vec2d;

public class Rectangle extends Parallelogram {
    float l_a, l_b;

    public Rectangle(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
        super(a, b, c, d);  // reuse the constructor function
        l_a = a.minus(b).l2norm();
        l_b = b.minus(c).l2norm();
    }

    public boolean isValid() {
        if (!super.isValid()) return false;
        // Checking whether it is a valid rectangle.
        // It multiplies all vectors to make sure they are vertical.

        Vec2d ab = new Vec2d(a.getX() - b.getX(), a.getY() - b.getY());
        Vec2d bc = new Vec2d(b.getX() - c.getX(), b.getY() - c.getY());
        Vec2d cd = new Vec2d(c.getX() - d.getX(), c.getY() - d.getY());
        Vec2d da = new Vec2d(d.getX() - a.getX(), d.getY() - a.getY());

        // Dot product should be 0 if it is 90 deg.
        if (dotProduct(ab, bc) != 0) return false;
        if (dotProduct(bc, cd) != 0) return false;
        if (dotProduct(cd, da) != 0) return false;
        if (dotProduct(da, ab) != 0) return false;

        return true;
    }

    // A helper method to produce dot product of two vectors.
    private double dotProduct(Vec2d vector1, Vec2d vector2) {
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY();
    }

    @Override
    public float area() {
        return super.area();        // Use the generic implementation to calculate the area.
    }

    public static void main(String[] args) {
        // Tests for isValid()
        Rectangle par = new Rectangle(new Vec2d(-3, 2), new Vec2d(0, -1), new Vec2d(8, -1), new Vec2d(5, 2));
        System.out.println(par.isValid());    // Should be false

        Rectangle pp = new Rectangle(new Vec2d(0, 0), new Vec2d(2, 0), new Vec2d(2, 3), new Vec2d(0, 3));
        System.out.println(pp.isValid());    // Should be true
    }
}
