package shapes;

public class RectangleShape extends AbstractShape {
    Vec2d a;
    Vec2d b;
    Vec2d c;
    Vec2d d;

    public RectangleShape(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean isInterior(Vec2d x) {
        return false;
    }

    @Override
    public float area() {
        return 0;
    }
    // TODO: Define the data members and implement area and interior checking
}
