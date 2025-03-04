package main;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import scenes.SceneManager;

public class KeyHandler {
    private SceneManager sceneManager;
    private double mouseX, mouseY;

    // 🔥 เพิ่มตัวแปรสำหรับ SceneBattle และ Map Scene
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed, attackPressed;
    public boolean enterPressed, qPressed, escapePressed, xPressed, skillPressed, gPressed; // ✅ เพิ่ม gPressed

    public KeyHandler() {}

    public void setMousePosition(double x, double y) {
        this.mouseX = x;
        this.mouseY = y;
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void keyPressed(KeyEvent e) {
        KeyCode keyCode = e.getCode();
        System.out.println("Key Pressed: " + keyCode);  // Debugging step

        if (sceneManager == null) {
            System.out.println("SceneManager is NULL!");  // Debugging sceneManager
            return;
        }

        // Handle key events for different scenes
        switch (sceneManager.getCurrentScene()) {
            case SceneManager.MENU_SCENE:
                handleMenuSceneKeys(keyCode);
                break;
            case SceneManager.CHARACTER_SELECT_SCENE:
                handleCharacterSelectSceneKeys(keyCode);
                break;
            case SceneManager.MAP_SCENE:
                handleMapSceneKeys(keyCode);
                break;
            case SceneManager.STAGE_SCENE:
                handleStageSceneKeys(keyCode);
                break;
            case SceneManager.BATTLE_SCENE:
                handleBattleSceneKeys(keyCode);
                break;
        }
    }

    private void handleMenuSceneKeys(KeyCode keyCode) {
        if (keyCode == KeyCode.ENTER) {
            System.out.println("✅ Enter detected, switching to MAP_SCENE");
            sceneManager.setScene(SceneManager.MAP_SCENE);
        }
    }

    private void handleCharacterSelectSceneKeys(KeyCode keyCode) {
        switch (keyCode) {
            case Q:
                qPressed = true;
                sceneManager.setScene(SceneManager.MAP_SCENE);
                break;
            case LEFT:
                leftPressed = true;
                break;
            case RIGHT:
                rightPressed = true;
                break;
            case X:
                xPressed = true;
                break;
        }
    }

    private void handleMapSceneKeys(KeyCode keyCode) {
        switch (keyCode) {
            case W, UP:
                upPressed = true;
                break;
            case S, DOWN:
                downPressed = true;
                break;
            case A, LEFT:
                leftPressed = true;
                break;
            case D, RIGHT:
                rightPressed = true;
                break;
            case SPACE:
                attackPressed = true;
                break;
            case SHIFT:
                shiftPressed = true;
                break;
            case ESCAPE:
                escapePressed = true;
                sceneManager.setScene(SceneManager.MENU_SCENE);
                break;
            case G: // ✅ ตรวจจับปุ่ม G
                gPressed = true;
                break;
        }
    }

    private void handleStageSceneKeys(KeyCode keyCode) {
        if (keyCode == KeyCode.Q) {
            qPressed = true;
        }
    }

    private void handleBattleSceneKeys(KeyCode keyCode) {
        switch (keyCode) {
            case UP, W:
                upPressed = true;
                break;
            case DOWN, S:
                downPressed = true;
                break;
            case ENTER:
                enterPressed = true;
                break;
            case X:
                skillPressed = true;
                break;
            case ESCAPE:
                escapePressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        KeyCode keyCode = e.getCode();

        switch (keyCode) {
            case W, UP:
                upPressed = false;
                break;
            case S, DOWN:
                downPressed = false;
                break;
            case A, LEFT:
                leftPressed = false;
                break;
            case D, RIGHT:
                rightPressed = false;
                break;
            case SPACE:
                attackPressed = false;
                break;
            case SHIFT:
                shiftPressed = false;
                break;
            case ESCAPE:
                escapePressed = false;
                break;
            case Q:
                qPressed = false;
                break;
            case ENTER:
                enterPressed = false;
                break;
            case X:
                xPressed = false; 
                skillPressed = false;
                break;
            case G: // ✅ รีเซ็ตค่าเมื่อปล่อยปุ่ม G
                gPressed = false;
                break;
        }
    }
}
