package main;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import scenes.SceneManager;
import tiles.TileManager;
import entity.Player;
import object.SuperObject;

public class GamePanel extends Pane {
    final int FPS = 60;
    public final int TILE_SIZE = 48;
    public final int screenWidth = 800;
    public final int screenHeight = 600;
    
    private AnimationTimer gameLoop;
    public KeyHandler keyH = new KeyHandler();
    public SceneManager sceneManager;
    public TileManager tileM;
    public CollisionChecker cChecker;
    public Player player;
    public SuperObject[] obj = new SuperObject[10];
    public int tileSize = TILE_SIZE;

    private Canvas canvas;
    private GraphicsContext gc;

    // Store selected character
    public String selectedCharacter = "knight"; // Default

    public GamePanel() {
        this.setPrefSize(screenWidth, screenHeight);
        this.setStyle("-fx-background-color: black;");
        
        canvas = new Canvas(screenWidth, screenHeight);
        gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);

        // Set up game components
        sceneManager = new SceneManager(this, keyH); // Ensure SceneManager is initialized first
        keyH.setSceneManager(sceneManager);
        
        cChecker = new CollisionChecker(this);
        player = new Player(this, keyH);
        tileM = new TileManager(this);

        // Handle key events
        this.setOnKeyPressed(event -> keyH.keyPressed(event));
        this.setOnKeyReleased(event -> keyH.keyReleased(event));
        this.setFocusTraversable(true);
        this.requestFocus();

        startGameLoop();
    }

    public void startGameLoop() {
        gameLoop = new AnimationTimer() {
            private long lastTime = System.nanoTime();
            private final double drawInterval = 1000000000.0 / FPS;

            @Override
            public void handle(long now) {
                if (now - lastTime >= drawInterval) {
                    update();
                    draw();
                    lastTime = now;
                }
            }
        };
        gameLoop.start();
    }

    public void update() {
        if (sceneManager != null) {
            sceneManager.update();
        }

        // 🔥 Ensure GamePanel has focus after scene changes
        this.requestFocus();

        // Update player only in MAP_SCENE
        if (sceneManager != null && sceneManager.getCurrentScene() == SceneManager.MAP_SCENE) {
            player.update();
        }
    }

    public void draw() {
        gc.clearRect(0, 0, screenWidth, screenHeight); // Clear canvas before drawing

        // Draw current scene
        if (sceneManager != null) {
            sceneManager.draw(gc);
        }

        if (sceneManager != null && sceneManager.getCurrentScene() == SceneManager.MAP_SCENE) {
            tileM.draw(gc);

            // Draw objects
            for (SuperObject superObject : obj) {
                if (superObject != null) {
                    superObject.draw(gc, this);
                }
            }

            // Draw player
            player.draw(gc);
        }
    }

    public void setSelectedCharacter(String character) {
        this.selectedCharacter = character;
    }

    public String getSelectedCharacter() {
        return selectedCharacter;
    }

    // Getter for canvas
    public Canvas getCanvas() {
        return canvas;
    }
}
