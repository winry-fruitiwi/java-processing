package gravitation;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

/**
 * version comments
 * 	planet class with instance variables
 * 	show, update
 * 	applyForce
 * 	testing with 100 planets
 * 	attract
 */
public class Main extends PApplet {
	List<Planet> planets;
	Planet attractor;

	public static void main(String[] args) {
		PApplet.main(new String[]{Main.class.getName()});
	}

	@Override
	public void settings() {
		size(700, 600);
	}

	@Override
	public void setup() {
//		rectMode(RADIUS);
		colorMode(HSB, 360f, 100f, 100f, 100f);
		planets = new ArrayList<>();
		for (int i=0; i<100; i++) {
			planets.add(new Planet(this, (int) random(width),
					(int) random(height),
					(int) random(200)+40));
		}
		attractor = new Planet(this, width/2, height/2, 500);
	}

	@Override
	public void draw() {
		background(210, 100, 30, 100);
		PVector gravity = new PVector(0, 0.4f);

		attractor.show(this);

		for (Planet p : planets) {
			p.show(this);
			p.update(this);
			p.applyForce(this, gravity);
			p.applyForce(this, attractor.attract(this, p));
		}
	}

	@Override
	public void mousePressed() {
		System.out.println(mouseX);
	}
}