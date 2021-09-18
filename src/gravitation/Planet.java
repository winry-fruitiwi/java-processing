package gravitation;

import processing.core.PApplet;
import processing.core.PVector;

public class Planet {
	PVector pos;
	PVector vel;
	PVector acc;
	int mass;
	float r;

	public Planet(PApplet app, int x, int y, int mass) {
		pos = new PVector(x, y);
		vel = PVector.random2D();
		acc = new PVector(0, 0);
		this.mass = mass;
		this.r = this.mass / 1.5f;
	}

	public void show(PApplet app) {
		app.fill(0, 0, 100, 20);
		app.noStroke();
		app.circle(pos.x, pos.y, this.r);
	}


	public void update(PApplet app) {
		pos.add(vel);
		vel.add(acc);
		acc.mult(0);
	}

	public void applyForce(PApplet app, PVector force) {
		// F = ma, so a = F/m. m usually doesn't equal 1, so we keep that.
		acc.add(force);
		acc.div(this.mass);
	}

}
