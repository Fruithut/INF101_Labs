package inf101.v17.pond;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MaleDuck extends Duck {

    public MaleDuck(Position pos, Direction dir, Pond pond) {
        super(pos, dir, pond);

        this.size = 1.2;
        this.speed = 1.0;
    }

    public Color getColor() {
        return Color.SILVER;
    }

    public boolean isMale() {
        return true;
    }

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
