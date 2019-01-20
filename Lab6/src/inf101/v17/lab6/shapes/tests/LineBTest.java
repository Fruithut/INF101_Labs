package inf101.v17.lab6.shapes.tests;

import inf101.v17.lab6.shapes.b.FactoryB;
import inf101.v17.lab6.shapes.tests.properties.AbstractLineTest;

public class LineBTest extends AbstractLineTest {

	public LineBTest() {
		super(new FactoryB());
	}

}
