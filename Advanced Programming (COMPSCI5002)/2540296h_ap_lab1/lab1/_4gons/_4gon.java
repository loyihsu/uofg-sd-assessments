package _4gons;

import shapes.Vec2d;

public class _4gon {
	public Vec2d a, b, c, d;

	public _4gon(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public float perimeter() {
		return a.minus(b).l2norm() + b.minus(c).l2norm() +
			c.minus(d).l2norm() + d.minus(a).l2norm();
	}

	// Question 9: Uses a math formula to calculate the area from four vertices.
	public float area() {
		return Math.abs(a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * d. getY() + d.getX() * a.getY()
				- a.getY() * b.getX() - b.getY() * c.getX() - c.getY() * d.getX() - d.getY() * a.getX()) / 2;
	}
}

