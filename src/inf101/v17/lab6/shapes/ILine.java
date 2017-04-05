package inf101.v17.lab6.shapes;

/**
 * A line shape.
 *
 * Lines are one-dimensional shapes defined by their length. The "width" is the
 * same as the length, and the "height" is always zero, as is the area and the
 * circumference.
 *
 * @author anya
 *
 */
public interface ILine extends IShape {
	/**
	 * @return The length of the line (same as its width).
	 */
	double getLength();

	/**
	 * Set the length of the line.
	 *
	 * @param newLength
	 */
	void setLength(double newLength);
}
