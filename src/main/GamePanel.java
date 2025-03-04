//package main;
//
//import javafx.animation.AnimationTimer;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.layout.Pane;
//import scenes.SceneManager;
//import tiles.TileManager;
//import entity.Player;
//import entity.base.Unit;
//import object.SuperObject;
//
//public class GamePanel extends Pane {
//    final int FPS = 60;
//    public final int TILE_SIZE = 48;
//    public final int screenWidth = 800;
//    public final int screenHeight = 600;
//    
//    private AnimationTimer gameLoop;
//    public KeyHandler keyH = new KeyHandler();
//    public SceneManager sceneManager;
//    public TileManager tileM;
//    public CollisionChecker cChecker;
//    public Player player; // 🔥 แก้ให้ตรงกับระบบยูนิตใหม่
//    public SuperObject[] obj = new SuperObject[10];
//    public int tileSize = TILE_SIZE;
//
//    private Canvas canvas;
//    private GraphicsContext gc;
//
//    // Store selected character
//    public String selectedCharacter = "knight"; // Default
//
//    public GamePanel() {
//        this.setPrefSize(screenWidth, screenHeight);
//        this.setStyle("-fx-background-color: black;");
//        
//        canvas = new Canvas(screenWidth, screenHeight);
//        gc = canvas.getGraphicsContext2D();
//        this.getChildren().add(canvas);
//
//        // Set up game components
//        sceneManager = new SceneManager(this, keyH); // Ensure SceneManager is initialized first
//        keyH.setSceneManager(sceneManager);
//        
//        cChecker = new CollisionChecker(this);
//        player = new Unit_Player("Hero", 1, 100, 20, 5, null); // 🔥 กำหนดค่าตัวละครเริ่มต้น
//        tileM = new TileManager(this);
//
//        // Handle key events
//        this.setOnKeyPressed(event -> keyH.keyPressed(event));
//        this.setOnKeyReleased(event -> keyH.keyReleased(event));
//        this.setFocusTraversable(true);
//        this.requestFocus();
//
//        startGameLoop();
//    }
//
//    public void startGameLoop() {
//        gameLoop = new AnimationTimer() {
//            private long lastTime = System.nanoTime();
//            private final double drawInterval = 1000000000.0 / FPS;
//
//            @Override
//            public void handle(long now) {
//                if (now - lastTime >= drawInterval) {
//                    update();
//                    draw();
//                    lastTime = now;
//                }
//            }
//        };
//        gameLoop.start();
//    }
//
//    public void update() {
//        if (sceneManager != null) {
//            sceneManager.update();
//        }
//
//        this.requestFocus(); // 🔥 Ensure GamePanel has focus after scene changes
//
//        // Update player only in MAP_SCENE
//        if (sceneManager != null && sceneManager.getCurrentScene() == SceneManager.MAP_SCENE) {
//            player.update();
//        }
//    }
//
//    public void draw() {
//        gc.clearRect(0, 0, screenWidth, screenHeight); // Clear canvas before drawing
//
//        if (sceneManager != null) {
//            sceneManager.draw(gc);
//        }
//
//        if (sceneManager != null && sceneManager.getCurrentScene() == SceneManager.MAP_SCENE) {
//            tileM.draw(gc);
//
//            // Draw objects
//            for (SuperObject superObject : obj) {
//                if (superObject != null) {
//                    superObject.draw(gc, this);
//                }
//            }
//
//            // Draw player
//            player.draw(gc);
//        }
//    }
//
//    public void setSelectedCharacter(String character) {
//        this.selectedCharacter = character;
//    }
//
//    public String getSelectedCharacter() {
//        return selectedCharacter;
//    }
//
//    public Canvas getCanvas() {
//        return canvas;
//    }
//
//    /** 🔥 เพิ่มฟังก์ชันเริ่มการต่อสู้ */
//    public void startBattle(Unit enemy) {
//        if (sceneManager != null) {
//            sceneManager.startBattle(player, enemy);
//        }
//    }
//}
package main;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import scenes.SceneManager;
import tiles.TileManager;
import entity.Player;
import entity.base.Unit;
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
    public Player player; // ✅ ใช้ Player แทน Unit_Player
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
        sceneManager = new SceneManager(this, keyH); 
        keyH.setSceneManager(sceneManager);
        
        cChecker = new CollisionChecker(this);
        player = new Player(this, keyH); // ✅ ใช้ Player เพื่อให้แยกระบบต่อสู้กับการเคลื่อนที่
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

        this.requestFocus(); // 🔥 Ensure GamePanel has focus after scene changes

        // ✅ อัปเดตตัวละครเฉพาะใน MAP_SCENE
        if (sceneManager != null && sceneManager.getCurrentScene() == SceneManager.MAP_SCENE) {
            player.update();
        }
    }

    public void draw() {
        gc.clearRect(0, 0, screenWidth, screenHeight); // Clear canvas before drawing

        if (sceneManager != null) {
            sceneManager.draw(gc);
        }

        // ✅ วาดฉากแผนที่เฉพาะเมื่ออยู่ใน MAP_SCENE
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

    public Canvas getCanvas() {
        return canvas;
    }

    /** 🔥 เพิ่มฟังก์ชันเริ่มการต่อสู้ */
    public void startBattle(Unit enemy) {
        if (sceneManager != null) {
            sceneManager.startBattle(player.getUnitPlayer(), enemy); // ✅ ใช้ Unit_Player จาก Player
        }
    }
}



