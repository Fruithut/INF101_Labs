package inf101.v17.lab6.shapes.tests;

import inf101.v17.lab6.shapes.b.FactoryB;
import inf101.v17.lab6.shapes.tests.properties.AbstractCircleTest;

public class CircleBTest extends AbstractCircleTest {

	public CircleBTest() {
		super(new FactoryB());
	}

}
