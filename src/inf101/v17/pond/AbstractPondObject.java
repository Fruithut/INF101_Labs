package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractPondObject implements IPondObject {
    protected double size;
    protected double speed;
    protected Pond pond;
    protected Position pos = new Position(1600, 500);
    protected Direction direction = new Direction(-1.0, 0.0);

    public AbstractPondObject(Position pos, Direction dir, Pond pond) {
        this.direction = dir.copy();
        this.pos = pos.copy();
        this.pond = pond;
    }

    public double getWidth() {
        return 200 * size;
    }

    public double getHeight() {
return 100 * size;
}

    public Position getPosition() {
        return pos.copy();
    }

    public Direction getDirection() {
        return direction.copy();
    }

    public abstract void step();

    public abstract void draw(GraphicsContext context);
}
