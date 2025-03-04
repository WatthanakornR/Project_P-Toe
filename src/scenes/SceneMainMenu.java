package scenes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;
import main.KeyHandler;

public class SceneMainMenu extends Scene {
    private Image background;
    private Image pressEnterText;
    private boolean showText = true;
    private int tickCount = 0;
    
    private GamePanel gp;
    private KeyHandler keyH;

    public SceneMainMenu(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        background = loadImage("/assets/backgrounds/title_screen.png");
        pressEnterText = loadImage("/assets/backgrounds/press-enter-text.png");
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    @Override
    public void update() {
        tickCount++;
        if (tickCount % 30 == 0) {
            showText = !showText;
        }
        
        // ✅ Detect Enter Key
        if (keyH.enterPressed) {
            System.out.println("✅ Enter Pressed! -> Switching to MAP Scene");
            gp.sceneManager.setScene(SceneManager.MAP_SCENE); // Switch to Map Scene
            keyH.enterPressed = false; // Reset input state
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (background != null) {
            gc.drawImage(background, 0, 0, 800, 600);
        }
        if (showText && pressEnterText != null) {
            int textX = (800 - (int) pressEnterText.getWidth() * 3) / 2;
            int textY = 500;
            gc.drawImage(pressEnterText, textX, textY, pressEnterText.getWidth() * 3, pressEnterText.getHeight() * 3);
        }
    }
}
