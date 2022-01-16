package pathfollowing;

import processing.core.PApplet;
import processing.core.PVector;

/*
TODO
	☒ add template project
	☐ add Vehicle class with constructor and template
	☐ add essential functions: update, applyForce, show, edges, test here
	☐ add seek, test here
	☐ add Path class with constructor and template
	☐ add essential functions: show, test here
	☐ add follow to Vehicle, test here
*/

public class PathFollowing extends PApplet {
	Vehicle vehicle;

	public static void main(String[] args) {
		PApplet.main(new String[]{PathFollowing.class.getName()});
	}

	@Override
	public void settings() {
		size(640, 360);
	}

	@Override
	public void setup() {
		rectMode(RADIUS);
		colorMode(HSB, 360f, 100f, 100f, 100f);

		vehicle = new Vehicle(width / 2f, height / 2f);
	}

	@Override
	public void draw() {
		background(234, 34, 24);

		// render and update the vehicle.
		vehicle.show(this);
		vehicle.update();
		// sophisticated example... pretty sure it's too jerky
		/* if (frameCount % 30 == 0) {
		       vehicle.applyForce(PVector.random2D());
		}
		*/
		vehicle.edges(this);
	}
}
