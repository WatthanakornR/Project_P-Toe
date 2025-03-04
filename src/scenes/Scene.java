package scenes;

import javafx.scene.canvas.GraphicsContext;

public abstract class Scene {
    public abstract void update();
    public abstract void draw(GraphicsContext gc);
}
