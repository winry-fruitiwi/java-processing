package pathfollowing;

import processing.core.PApplet;
import processing.core.PVector;

public class Path {
	PVector start, end;
	float radius;

	public Path(float x1, float y1, float x2, float y2) {
		this.start = new PVector(x1, y1);
		this.end = new PVector(x2, y2);

		// analogous to a road's width.
		this.radius = 20;
	}

	public void show(PApplet app) {
		app.stroke(0, 0, 100);
		app.strokeWeight(2);
		app.line(this.start.x, this.start.y, this.end.x, this.end.y);

		app.stroke(0, 0, 100, 20);
		app.strokeWeight(this.radius * 2);
		app.line(this.start.x, this.start.y, this.end.x, this.end.y);
	}
}
