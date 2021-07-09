package shapes;

public class Vec2d {
	float x;
	float y;

	public Vec2d(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vec2d add(Vec2d that) {
		return new Vec2d(this.x + that.x, this.y + that.y);
	}

	public Vec2d scale(float alpha) {
		return new Vec2d(alpha*this.x, alpha*this.y);
	}

	public Vec2d minus(Vec2d that) {
		return this.add(that.scale(-1.0f));
	}

	public float l2norm() {
		return (float)Math.sqrt(x*x + y*y);
	}

	public float getX() { return x; }
	public float getY() { return y; }
}

