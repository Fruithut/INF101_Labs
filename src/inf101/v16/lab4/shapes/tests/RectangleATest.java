package inf101.v16.lab4.shapes.tests;

import inf101.v16.lab4.shapes.a.FactoryA;
import inf101.v16.lab4.shapes.tests.properties.AbstractRectangleTest;

public class RectangleATest extends AbstractRectangleTest {

	public RectangleATest() {
		super(new FactoryA());
	}

}
