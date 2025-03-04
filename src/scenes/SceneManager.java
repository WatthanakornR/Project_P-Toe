package scenes;

import javafx.scene.canvas.GraphicsContext;
import main.GamePanel;
import main.KeyHandler;
import entity.unit.Unit_Player;
import entity.base.Unit;

public class SceneManager {
    public static final int MAP_SCENE = 0;
    public static final int CHARACTER_SELECT_SCENE = 1;
    public static final int MENU_SCENE = 2;
    public static final int STAGE_SCENE = 3;
    public static final int BATTLE_SCENE = 4; // 🔥 เพิ่มฉากต่อสู้

    private Scene currentScene;
    private int currentSceneID;
    private GamePanel gp;
    private KeyHandler keyH;
    
    public SceneManager(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setScene(MENU_SCENE); // Start at Main Menu
    }
    
    public void setScene(int sceneID) {
        if (currentSceneID == sceneID) {
            System.out.println("⚠️ Scene already active: " + sceneID);
            return;
        }

        System.out.println("🔄 Switching to scene: " + sceneID);
        this.currentSceneID = sceneID;
        resetKeys();

        switch (sceneID) {
            case MAP_SCENE:
                System.out.println("✅ Loading SceneMap...");
                currentScene = new SceneMap(gp, keyH);
                break;
            case CHARACTER_SELECT_SCENE:
                System.out.println("✅ Loading SceneCharacterSelect...");
                currentScene = new SceneCharacterSelect(gp, keyH);
                break;
            case STAGE_SCENE:
                System.out.println("✅ Loading SceneStageSelect...");
                currentScene = new SceneStageSelect(gp, keyH);
                break;
            case MENU_SCENE:
                System.out.println("✅ Loading SceneMainMenu...");
                currentScene = new SceneMainMenu(gp, keyH);
                break;
            default:
                System.out.println("⚠️ Scene not found: " + sceneID);
                break;
        }

        gp.draw(); // 🔥 บังคับให้รีเฟรชหน้าจอ
    }

    /** 🔥 เพิ่มเมธอด startBattle() */
    public void startBattle(Unit_Player player, Unit enemy) {
        System.out.println("⚔️ Starting Battle: " + player.getUnitName() + " VS " + enemy.getUnitName());
        this.currentSceneID = BATTLE_SCENE;
        this.currentScene = new SceneBattle(gp, player, enemy);
        resetKeys();
        gp.draw();
    }

    private void resetKeys() {
        keyH.upPressed = false;
        keyH.downPressed = false;
        keyH.leftPressed = false;
        keyH.rightPressed = false;
        keyH.shiftPressed = false;
        keyH.attackPressed = false;
        keyH.enterPressed = false;
        keyH.qPressed = false;
    }

    public int getCurrentScene() {
        return this.currentSceneID;
    }
    
    public void update() {
        if (currentScene != null) {
            currentScene.update();
            gp.draw(); 
        }
    }
    
    public void draw(GraphicsContext gc) {
        if (currentScene != null) {
            currentScene.draw(gc);
        }
    }
}
