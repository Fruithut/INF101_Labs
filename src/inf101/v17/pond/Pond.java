package inf101.v17.pond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pond {
	// private Duck[] ducks = new Duck[10];
	private List<IPondObject> objects = new ArrayList<>();
	private double width;
	private double height;

	public Pond(double width, double height) {
		this.width = width;
		this.height = height;

	}

	public void step() {
		// for(int i = 0; i < ducks.size(); i++)
		// ducks.get(i).step();

		for (IPondObject obj : objects) {
			obj.step();
		}
	}

	public void draw(GraphicsContext context) {
		context.setFill(Color.SLATEBLUE);
		context.fillOval(0, 0, width, height);
		for (IPondObject obj : objects) {
			obj.draw(context);
		}
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	/**
	 * @param obj An object to be added
	 */
	public void addObject(IPondObject obj) {
		objects.add(obj);
	}

	/**
	 * @param obj An object to be removed
	 */
	public void removeObject(IPondObject obj) {
		objects.remove(obj);
	}

	/**
	 * @return A list of all the objects in the pond
	 */
	public List<IPondObject> allObjects() {
		return new ArrayList<>(objects);
	}

	/**
	 * Return a list of pond objects that are close to thisObject
	 * 
	 * The resulting list will not include thisObject, and is sorted based on the distance to thisObject.
	 * 
	 * @param thisObject An object in the pond
	 * @param distanceLimit Maximum distance (objects further away will be excluded), or 0 to include all objects
	 * @return A list of objects no more than distanceLimit away from thisObject
	 */
	public List<IPondObject> nearbyObjects(IPondObject thisObject, double distanceLimit) {
		if (distanceLimit < 0 || thisObject == null)
			throw new IllegalArgumentException();

		List<IPondObject> result = new ArrayList<>(objects);
		result.remove(thisObject);
		Position pos = thisObject.getPosition();
		if (distanceLimit > 0) {
			result.removeIf((IPondObject o) -> pos.distanceTo(o.getPosition()) > distanceLimit);
		}

		Collections.sort(result, (IPondObject o1, IPondObject o2) -> Double.compare(pos.distanceTo(o1.getPosition()), pos.distanceTo(o2.getPosition())));
		
		return result;
	}

	public Position getCenter() {
		return new Position(width / 2, height / 2);
	}
}