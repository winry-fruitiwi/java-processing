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
		vel = PVector.random2D().mult(2);
		acc = new PVector(0, 0);
		this.mass = mass;
		this.r = (float) Math.sqrt(this.mass);
	}

	public void show(PApplet app) {
		app.fill(0, 0, 100, 40);
		app.noStroke();
		app.circle(pos.x, pos.y, this.r*2);
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


	// attracts other to this.pos using Newton's Universal Law of Gravitation
	public PVector attract(PApplet app, Planet other) {
		// We want a distance between the two, as required by Newton's Law
		float distance = PVector.dist(this.pos, other.pos);
		if (distance == 0) {
			// then other is either ourselves or exactly on us!
			System.out.println("0 in attract!");
			return new PVector(0.001f, 0.001f);

		}

		// Now it's time for the fun part: Newton's Law of Gravitation!
		// g = G*m₁*m₂/r^2

		int G = 1;

		float mass_product = this.mass*other.mass;
		mass_product = mass_product/(distance * distance) * G;
		// We need a vector pointing from other.pos to this.pos.
		PVector vectorToUs = PVector.sub(this.pos, other.pos);
		vectorToUs.setMag(mass_product);

		// We can't make gravity too big!
		float magnitude = PApplet.constrain(vectorToUs.mag(), 20, 80);
		vectorToUs.setMag(magnitude);

		return vectorToUs;
	}

}
