package inf101.v17.lab6.shapes.tests;

import inf101.v17.lab6.shapes.b.FactoryB;
import inf101.v17.lab6.shapes.tests.properties.AbstractRectangleTest;

public class RectangleBTest extends AbstractRectangleTest {

	public RectangleBTest() {
		super(new FactoryB());
	}

}
