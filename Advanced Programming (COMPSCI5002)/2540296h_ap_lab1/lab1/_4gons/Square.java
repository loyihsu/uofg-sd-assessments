package _4gons;

import shapes.Vec2d;

public class Square extends Rectangle {
    public Square(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
        super(a, b, c, d);  // reuse the constructor function
    }

    @Override
    public boolean isValid() {
        return l_a == l_b;
    }

    @Override
    public float area() {
        return super.area();        // Use the generic implementation to calculate the area.
    }
}
