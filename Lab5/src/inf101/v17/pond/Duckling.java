package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

import java.util.List;


public class Duckling extends AbstractDuck {

    public Duckling(Position pos, Direction dir, Pond pond) {
        super(pos, dir, pond);
        this.size = 0.4;
        this.speed = 0.5;
    }

    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public boolean isMale() {
        return false;
    }

    @Override
    public boolean isFemale() {
        return false;
    }

    @Override
    public void step(){
        super.step();

        // follow mother
        List<IPondObject> nearbyObjects = pond.nearbyObjects(this, 600);
        for (IPondObject o : nearbyObjects) {
            if (o instanceof FemaleDuck) {
                AbstractDuck d = (AbstractDuck) o;
                direction.turnTowards(pos.directionTo(d.getPosition()), 5);
                break;
            }
        }
    }

    @Override
    public void draw(GraphicsContext context) {
        Paint bodyColor = Color.GOLD, headColor = Color.GOLD.brighter(), billColor = Color.SANDYBROWN;

        double x = pos.getX(), y = pos.getY();
        double w = getWidth(), h = getHeight();

        context.save();
        context.translate(x, y);
        double a = direction.toAngle();

        context.rotate(180 + a);

        x = -getWidth() / 2;
        y = -getHeight() / 2;
        if (direction.getMovement(1.0).getX() > 0) {
            context.scale(1.0, -1.0);
        }

        // body
        context.setFill(bodyColor);
        context.fillOval(x, y, w, h);

        // front
        context.setFill(Color.SADDLEBROWN);
        context.fillArc(x, y, w, h, 135, 90, ArcType.ROUND);

        // head
        context.setFill(headColor);
        context.fillOval(x - w * .1, y + h * .7, w * .5, h * .5);

        // eye
        context.setFill(Color.BLACK);
        context.fillOval(x + w * .1, y + h * .95, w * .05, h * .05);

        // bill
        context.save();
        context.setFill(billColor);
        context.translate(x - w * .01, y + h * .90);
        context.rotate(200);
        context.fillArc(0, 0, w * .5, h * .1, 135, 90, ArcType.ROUND);
        context.restore();

        context.restore();
    }
}
