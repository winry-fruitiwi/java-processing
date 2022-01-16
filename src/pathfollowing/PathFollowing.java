package pathfollowing;

import processing.core.PApplet;
import processing.core.PVector;

/*
TODO
	☒ add template project
	☒ add Vehicle class with constructor and template
	☒ add essential functions: update, applyForce, show, edges, test here
	☒ add seek, test here
	☐ add Path class with constructor and template
	☐ add essential functions: show, test here
	☐ add follow to Vehicle, test here
*/

public class PathFollowing extends PApplet {
	Vehicle vehicle;
	Path path;

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
		path = new Path(0, height / 2f, width, height / 2f);
	}

	@Override
	public void draw() {
		background(234, 34, 24);

		// create and render target every frame
		PVector target = new PVector(mouseX, mouseY);
		fill(120f, 80f, 80f, 100f);
		noStroke();
		circle(target.x, target.y, 20);

		// render and update the vehicle.
		vehicle.show(this);
		vehicle.update();
		// sophisticated example... pretty sure it's too jerky
		/* if (frameCount % 30 == 0) {
		       vehicle.applyForce(PVector.random2D());
		}
		*/
		vehicle.seek(target);
		vehicle.edges(this);

		// path operations
		path.show(this);
	}
}
