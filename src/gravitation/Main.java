package gravitation;

import peasy.*;
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
	// These are our variables.
	List<Planet> planets;
	PeasyCam cam;
    // Planet attractor;

	public static void main(String[] args) {
		// We just need to override everything.
		PApplet.main(new String[]{Main.class.getName()});
	}

	// This is where we declare our sizes, perhaps modes, and more.
	@Override
	public void settings() {
		size(700, 600, P3D);
	}

	// We fill up our variables here, if any are made previously.
	@Override
	public void setup() {
//		rectMode(RADIUS);
		// I'm used to coding in HSB!
		colorMode(HSB, 360f, 100f, 100f, 100f);

		// This is our arrayList of planets.
		planets = new ArrayList<>();
		cam = new PeasyCam(this, width/2, height/2, 0, 800);

		// Now it's time to fill the lists up! The random function calls
		// are probably derived from Math.random. I have a lot of trouble
		// understanding all the Math function code.
		for (int i=0; i<100; i++) {
			planets.add(new Planet(this, (int) random(100, width - 100),
					(int) random(100, height - 100),
					(int) random(100)+4));
		}

		// we don't have this huge attractor anymore!
//		attractor = new Planet(this, width/2, height/2, 500);
	}

	@Override
	public void draw() {
		background(210, 100, 30, 100);

		// We need to make each planet attract each other planet.
		// This is very costly, but we don't have quad trees so this is all
		// we can do for now.
		for (Planet p : planets) {
			// Attract every other planet!
			for (Planet otherP : planets) {
				// We don't want to attract ourselves, or else we'd be
				// making huge forces!
				if (p != otherP) {
					PVector forceOfAttraction = p.attract(this, otherP);
					otherP.applyForce(this, forceOfAttraction);
				}
			}
		}

		// we need to update each planet separately from the main loop
		// so that no planet sees into the future by accident.
		for (Planet p : planets)
			p.update(this);

		// Now that we're done with the other loop, we can see the planets.
		for (Planet p : planets)
			p.show(this);
	}

	@Override
	public void mousePressed() {
		// We make a new planet where our mouse is.
		// TODO: Maybe print framerate?
//		planets.add(new Planet(this, mouseX, mouseY, (int) random(200)+4));
	}
}