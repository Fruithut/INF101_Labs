package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class FemaleDuck extends Duck {

    public FemaleDuck(Position pos, Direction dir, Pond pond) {
        super(pos, dir, pond);

        this.size = 1.0;
        this.speed = 1.0;
    }

    public Color getColor() {
        return Color.SADDLEBROWN;
    }

    public boolean isMale() {
        return false;
    }

    public boolean isFemale() {
        return true;
    }

    @Override
    public void step() {
        List<IPondObject> nearbyObjects = pond.nearbyObjects(this, 400);
        for (IPondObject o : nearbyObjects) {
            if (o instanceof Duckling) {
                super.swim();
                super.step();
            } else {
                this.stop();
            }
        }
    }

    @Override
    public void draw(GraphicsContext context) {
        this.bodyColor = Color.SADDLEBROWN;
        this.headColor = Color.SADDLEBROWN.brighter();
        this.billColor = Color.SANDYBROWN;

        super.draw(context);
    }
}
