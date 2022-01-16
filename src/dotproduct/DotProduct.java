package dotproduct;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * ☒ import template project
 * ☐ add variables
 * ☐ draw initial lines
 * ☐ add vectorProjection
 * ☐ add debug lines and points
 * ☐ comment debug lines
 *
 * TODO:
 *     ☐ make a sort of mirror using scalar projection!
 *     ☐ projection point: beehive, place beehive, reverse scalar projection
 */
public class DotProduct extends PApplet {
	public static void main(String[] args) {
		PApplet.main(new String[]{DotProduct.class.getName()});
	}

	PVector a, b, v, pos;

	@Override
	public void settings() {
		size(640, 360);
	}

	@Override
	public void setup() {
		rectMode(RADIUS);
		colorMode(HSB, 360f, 100f, 100f, 100f);

		// I'll start with a straight line just to test, then give it a slope.
		// b = new PVector(200, 0);
		b = new PVector(200, 60);
		pos = new PVector(100, 200);
	}

	@Override
	public void draw() {
		background(234, 34, 24);
		a = new PVector(mouseX, mouseY);

		strokeWeight(4);
		stroke(0, 0, 100);
		// lines for my vectors. Mostly debug info, only the line for b matters.
		line(pos.x, pos.y, a.x, a.y);
		line(pos.x, pos.y, pos.x + b.x, pos.y + b.y);

		v = vectorProjection(a.copy().sub(pos), b);
		strokeWeight(8);
		stroke(240, 100, 80);
		// extra debug info
		line(pos.x, pos.y, pos.x + v.x, pos.y + v.y);

		// the line connecting the A vector to the V vector. extra debug info
		strokeWeight(1);
		stroke(0, 0, 100);
		line(a.x, a.y, v.x + pos.x, v.y + pos.y);

		// point at the position. extra debug info
		strokeWeight(14);
		stroke(120, 90, 80);
		point(pos.x, pos.y);

		// point at a
		strokeWeight(14);
		stroke(120, 90, 80);
		point(a.x, a.y);

		// point at the scalar projection
		strokeWeight(14);
		stroke(0, 90, 80);
		point(v.x + pos.x, v.y + pos.y);
	}

	public PVector vectorProjection(PVector a, PVector b) {
		PVector bCopy = b.copy().normalize();
		float sp = a.dot(bCopy);
		bCopy.mult(sp);
		return bCopy;
	}
}
