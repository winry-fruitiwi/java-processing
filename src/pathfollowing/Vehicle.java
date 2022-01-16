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

	// PApplets and other rendering tools
	PApplet app;

	public Vehicle(float x, float y) {
		this.pos = new PVector(x, y);
		this.vel = new PVector(0, 0);
		this.acc = new PVector(0, 0);
		this.r = 10;
		this.maxSpeed = 2;
		this.maxForce = 0.03f;

		this.app = new PApplet();
	}

	// one of Craig Reynold's steering behaviors, described in his paper.
	// The vehicle seeks the target passed in.
	public PVector seek(PVector target) {
		return null;
	}

	// applies a force to the vehicle
	public void applyForce(PVector force) {
		// just add the force!
	}

	// updates the vehicle's position, velocity, and acceleration.
	public void update() {
		// add vel to pos, add acc to vel, set acc to zero
	}

	// renders the vehicle
	public void show() {
		// draw a triangle
	}

	public void edges() {
		// if the vehicle is out of bounds, wrap it around like it's on a globe!
	}

	public PVector follow() {
		// FIXME add a path class argument, a Path called path
		return null;
	}

	public PVector findProjection(PVector pos, PVector a, PVector b) {
		// finds the scalar projection of a and b, then returns that added to
		// the pos vector
		return null;
	}
}
