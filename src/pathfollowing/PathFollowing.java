package pathfollowing;

import processing.core.PApplet;

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
	}

	@Override
	public void draw() {
		background(210, 100, 30, 100);
	}
}
