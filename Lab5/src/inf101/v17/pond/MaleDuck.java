package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MaleDuck extends AbstractDuck {

    public MaleDuck(Position pos, Direction dir, Pond pond) {
        super(pos, dir, pond);
        this.size = 1.2;
        this.speed = 1.0;
    }

    @Override
    public boolean isAdult() {
        return true;
    }

    public Color getColor() {
        return Color.SILVER;
    }

    @Override
    public boolean isMale() {
        return true;
    }

    @Override
    public boolean isFemale() {
        return false;
    }

    @Override
    public void draw(GraphicsContext context) {
        this.bodyColor = Color.SILVER;
        this.headColor = Color.DARKGREEN;
        this.billColor = Color.YELLOW;

        super.draw(context);
    }

}
