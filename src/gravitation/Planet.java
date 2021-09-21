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
		vel = new PVector(0, 0);
		acc = new PVector(0, 0);
		this.mass = mass;
		this.r = (float) Math.sqrt(this.mass);
	}

	public void show(PApplet app) {
		app.pushMatrix();
		app.fill(0, 0, 100, 40);
		app.translate(this.pos.x, this.pos.y);

		app.noStroke();
		app.sphere(this.r*2);
		app.popMatrix();
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


	public PVector attract(PApplet app, Planet other) {
		// First we find the distance between us and the other planet.
		float distance = PVector.dist(this.pos, other.pos);
		// Uh oh! What if we're the same as or right on top of the other planet?
//		if (distance == 0) {
//			return new PVector(0, 1000f); No need for this anymore!
//		}

		// We constrain the distance such that if it ever becomes too large
		// or small, we treat it as if it were within the boundaries of the
		// .constrain function.
		distance = PApplet.constrain(distance, 10, 30);


		// We need a vector from the other planet to us. This is what we'll
		// be working with, like an empty body about to be stuffed.
		PVector vectorToUs = PVector.sub(this.pos, other.pos);

		// Now for the fun part: Newton's Universal Law of Gravitation! It is:
		// G*(m₁*m₂)/(r^2)

		// First we need the gravitational constant.
		float G = 1;

		// Now, let's use the Law of Gravitation!
		float attraction = G * (this.mass * other.mass)/(distance * distance);
		vectorToUs.setMag(attraction);

		return vectorToUs;
	}


	// attracts other to this.pos using Newton's Universal Law of Gravitation
	public PVector archived_attract(PApplet app, Planet other) {
		// We want a distance between the two, as required by Newton's Law
		float distance = PVector.dist(this.pos, other.pos);
		if (distance == 0) {
			// then other is either ourselves or exactly on us!
//			System.out.println("0 in attract!");
			return PVector.random2D().mult(1000f);
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
		float magnitude = PApplet.constrain(vectorToUs.mag(), 5, 15);
		vectorToUs.setMag(magnitude);

		return vectorToUs;
	}

}
