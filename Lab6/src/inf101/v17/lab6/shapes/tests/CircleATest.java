package inf101.v17.lab6.shapes.tests;

import inf101.v17.lab6.shapes.a.FactoryA;
import inf101.v17.lab6.shapes.tests.properties.AbstractCircleTest;

public class CircleATest extends AbstractCircleTest {

	public CircleATest() {
		super(new FactoryA());
	}

}
