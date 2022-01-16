package pathfollowing;

import processing.core.PApplet;
import processing.core.PVector;

public class Vehicle {
	// underlying class variables
	PVector pos;
	PVector vel;
	PVector acc;
	float r;
	float maxSpeed;
	float maxForce;

	// PApplets and other rendering tools (didn't actually need this)
    // PApplet app;

	public Vehicle(float x, float y) {
		this.pos = new PVector(x, y);
		this.vel = new PVector(0, 0);
		this.acc = new PVector(0, 0);
		this.r = 20;
		this.maxSpeed = 10f;
		this.maxForce = 0.06f;

		// this.app = new PApplet();
	}

	// one of Craig Reynold's steering behaviors, described in his paper.
	// The vehicle seeks the target passed in.
	public void seek(PVector target) {
		PVector force = PVector.sub(target, this.pos);
		force.setMag(this.maxSpeed);
		force.sub(this.vel);
		force.limit(this.maxForce);

		this.applyForce(force);
	}

	// applies a force to the vehicle
	public void applyForce(PVector force) {
		// just add the force!
		this.acc.add(force);
	}

	// updates the vehicle's position, velocity, and acceleration.
	public void update() {
		// add vel to pos, add acc to vel, set acc to zero
		this.pos.add(this.vel);
		this.vel.add(this.acc).limit(this.maxSpeed);
		this.acc.mult(0);
	}

	// renders the vehicle
	public void show(PApplet app) {
		app.noStroke();
		app.fill(0, 0, 100);

		app.push();
		app.translate(this.pos.x, this.pos.y);
		app.rotate(this.vel.heading());

		app.triangle(
				-this.r/2, this.r/2,
				this.r, 0,
				-this.r/2, -this.r/2
		);

		app.pop();
	}

	public void edges(PApplet app) {
		// if the vehicle is out of bounds, wrap it around like it's on a globe!

		// right side
		if (this.pos.x > app.width) {
			this.pos.x = 0;
		}

		// left side
		if (this.pos.x < 0) {
			this.pos.x = app.width;
		}

		// top side
		if (this.pos.y > app.height) {
			this.pos.y = 0;
		}

		// bottom side
		if (this.pos.y < 0) {
			this.pos.y = app.height;
		}
	}

	public PVector follow(PApplet app) {
		// FIXME add a path class argument, a Path called path
		return null;
	}

	public PVector findProjection(PVector pos, PVector a, PVector b) {
		// finds the scalar projection of a and b, then returns that added to
		// the pos vector
		return null;
	}
}
