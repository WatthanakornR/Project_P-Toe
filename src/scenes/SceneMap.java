package scenes;

import javafx.scene.canvas.GraphicsContext;
import main.GamePanel;
import main.KeyHandler;

public class SceneMap extends Scene {
    private GamePanel gp;

    public SceneMap(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        // Don't create new instances of TileManager and Player here,
        // just use the ones from GamePanel
    }

    @Override
    public void update() {
        // Player update is now handled in GamePanel's update method
    }

    @Override
    public void draw(GraphicsContext gc) {
        // Map drawing is now handled in GamePanel's draw method
    }
}
