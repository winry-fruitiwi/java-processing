package dotproduct;

import processing.core.PApplet;

/**
 * ☒ import template project
 *
 *
 */
public class DotProduct extends PApplet {
	public static void main(String[] args) {
		PApplet.main(new String[]{DotProduct.class.getName()});
	}

	@Override
	public void settings() {
		size(700, 600);
	}

	@Override
	public void setup() {
		rectMode(RADIUS);
		colorMode(HSB, 360f, 100f, 100f, 100f);

		for (int i = 0; i < 8; i++) {
			System.out.printf("    RAM8(in=in, address=address[3..5], " +
							"load=, " +
							"out=out%d);%n",
					i);
		}
	}

	@Override
	public void draw() {
		background(210, 100, 30, 100);
		rect(mouseX, mouseY, 20, 20);
	}

	@Override
	public void mousePressed() {
		System.out.println(mouseX);
	}
}