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
		this.r = this.mass / 2f;
	}

	public void show(PApplet app) {
		app.fill(0, 0, 100, 10);
		app.noStroke();
		app.circle(pos.x, pos.y, this.r);
	}
}
