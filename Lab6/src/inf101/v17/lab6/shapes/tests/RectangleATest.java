package inf101.v17.lab6.shapes.tests;

import inf101.v17.lab6.shapes.a.FactoryA;
import inf101.v17.lab6.shapes.tests.properties.AbstractRectangleTest;

public class RectangleATest extends AbstractRectangleTest {

	public RectangleATest() {
		super(new FactoryA());
	}

}
