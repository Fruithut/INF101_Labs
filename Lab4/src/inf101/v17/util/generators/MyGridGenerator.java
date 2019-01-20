package inf101.v17.util.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import inf101.v17.datastructures.IGrid;
import inf101.v17.datastructures.MyGrid;
import inf101.v17.util.IGenerator;

public class MyGridGenerator<T> implements IGenerator<IGrid<T>> {
	/**
	 * Generator for the width of a random grid
	 */
	private final IGenerator<Integer> widthGenerator;
	/**
	 * Generator for the height of a random grid
	 */
	private final IGenerator<Integer> heightGenerator;
	/**
	 * Generator for one element of a random grid
	 */
	private final IGenerator<T> elementGenerator;

	public MyGridGenerator(IGenerator<T> elementGenerator) {
		this.elementGenerator = elementGenerator;
		this.widthGenerator = new IntGenerator(1,100); // bredde blir et tall fra 1 til 100
		this.heightGenerator = new IntGenerator(1, 100); // høyde blir et tall fra 1 til 100
	}	

	public MyGridGenerator(IGenerator<T> elementGenerator, int maxWidth, int maxHeight) {
		if(maxWidth < 1 || maxHeight < 1)
			throw new IllegalArgumentException("Width and height must be 1 or greater");
		
		this.elementGenerator = elementGenerator;
		this.widthGenerator = new IntGenerator(1, maxWidth);
		this.heightGenerator = new IntGenerator(1, maxHeight);
	}	

	public MyGridGenerator(IGenerator<T> elementGenerator, IGenerator<Integer> widthGenerator, IGenerator<Integer> heightGenerator) {
		this.elementGenerator = elementGenerator;
		this.widthGenerator = widthGenerator;
		this.heightGenerator = heightGenerator;
	}	

	@Override
	public IGrid<T> generate(Random r) {
		// TODO: fyll inn; bruk bredde/høyde-generatorer til å finne størrelsen på 
		// et nytt grid, opprett et MyGrid-objekt, og fyll det med elementer
		// fra elementgeneratoren (T element = elementGenerator.generate(r);)
		//
		// Viktig: sende med argumentet 'r' når du kaller generate på subgeneratorene
		// fra denne metoden.

		IGrid<T> rand = new MyGrid<>(widthGenerator.generate(r), heightGenerator.generate(r), null);
		for (int i = 0; i < rand.getWidth(); i++) {
			for (int j = 0; j < rand.getHeight(); j++) {
				rand.set(i,j,elementGenerator.generate(r));
			}
		}

		return rand;
	}

	@Override
	public List<IGrid<T>> generateEquals(Random r, int n) {
		long seed = r.nextLong();

		List<IGrid<T>> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			list.add(generate(new Random(seed)));
		
		return list;
	}

	@Override
	public List<IGrid<T>> generateEquals(int n) {
		return generateEquals(IntGenerator.getRandom(), n); 
	}

	@Override
	public IGrid<T> generate() {
		return generate(IntGenerator.getRandom());
	}

}
