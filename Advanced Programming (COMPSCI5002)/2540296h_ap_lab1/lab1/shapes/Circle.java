package shapes;

public class Circle extends AbstractShape {
    Vec2d centre;
    float radius;

    public Circle(Vec2d centre, float radius) {
        this.centre = centre;
        this.radius = radius;
    }

    // TODO: Implement the logic to test interior.
    @Override
    public boolean isInterior(Vec2d x) {
        return false;
    }

    @Override
    public float area() {
        return 0;
    }
}
