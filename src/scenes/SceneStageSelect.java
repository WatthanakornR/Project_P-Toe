package scenes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.GamePanel;
import main.KeyHandler;

public class SceneStageSelect extends Scene {
    private GamePanel gp;
    private Image background, stageBox, chestImage, keyImage;
    private StageButton[] stageButtons;
    private Font fantasyFont;
    private KeyHandler keyH;
    private int selectedStageIndex = 0;
    private int unlockedStages = 1;

    public SceneStageSelect(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        loadAssets();
        initStages();

        // ตั้งค่า Mouse Event Listener สำหรับจับตำแหน่งเมาส์
        gp.getCanvas().setOnMouseMoved(e -> {
            keyH.setMousePosition(e.getX(), e.getY());
        });
    }

    private void loadAssets() {
        background = new Image(getClass().getResourceAsStream("/assets/backgrounds/stage_select_bg.png"));
        stageBox = new Image(getClass().getResourceAsStream("/assets/ui/stage_box.png"));
        chestImage = new Image(getClass().getResourceAsStream("/objects/chest.png"));
        keyImage = new Image(getClass().getResourceAsStream("/objects/key.png"));
        fantasyFont = Font.font("Pixelify Sans", FontWeight.BOLD, 30);
    }

    private void initStages() {
        int buttonWidth = 350;
        int buttonHeight = 80;
        int centerX = (int) ((gp.getWidth() - buttonWidth) / 2);
        int startY = 140;
        int gap = 25;

        stageButtons = new StageButton[] {
            new StageButton("Tower of Storms", centerX, startY, buttonWidth, buttonHeight, stageBox, fantasyFont, false),
            new StageButton("Infernal Keep", centerX, startY + (buttonHeight + gap), buttonWidth, buttonHeight, stageBox, fantasyFont, true),
            new StageButton("Abyssal Ruins", centerX, startY + 2 * (buttonHeight + gap), buttonWidth, buttonHeight, stageBox, fantasyFont, true),
            new StageButton("Cursed Citadel", centerX, startY + 3 * (buttonHeight + gap), buttonWidth, buttonHeight, stageBox, fantasyFont, true)
        };
        updateStageUnlocks();
    }

    private void updateStageUnlocks() {
        for (int i = 0; i < stageButtons.length; i++) {
            stageButtons[i].setLocked(i >= unlockedStages);
        }
    }

    private void selectStage(String stageName) {
        if (stageButtons[selectedStageIndex].isLocked()) {
            System.out.println("Stage is locked!");
            return;
        }
        System.out.println("Entering: " + stageName);
    }

    public void unlockNextStage() {
        if (unlockedStages < stageButtons.length) {
            unlockedStages++;
            updateStageUnlocks();
        }
    }

    @Override
    public void update() {
        if (keyH.qPressed) {
            gp.sceneManager.setScene(SceneManager.MAP_SCENE);
            resetKeys();
        }

        // ตรวจสอบ hover effect
        double mouseX = keyH.getMouseX();  // เรียกจาก KeyHandler
        double mouseY = keyH.getMouseY();  // เรียกจาก KeyHandler

        // อัพเดตสถานะ hover ของแต่ละปุ่ม
        for (StageButton stageButton : stageButtons) {
            if (stageButton.contains(mouseX, mouseY)) {
                stageButton.setHovered(true);  // เมื่อเมาส์อยู่เหนือปุ่ม
            } else {
                stageButton.setHovered(false);  // เมื่อเมาส์ออกจากปุ่ม
            }
        }

        if (keyH.upPressed) {
            selectedStageIndex = (selectedStageIndex - 1 + stageButtons.length) % stageButtons.length;
            keyH.upPressed = false;
        }

        if (keyH.downPressed) {
            selectedStageIndex = (selectedStageIndex + 1) % stageButtons.length;
            keyH.downPressed = false;
        }

        if (keyH.enterPressed) {
            selectStage(stageButtons[selectedStageIndex].stageName);
            keyH.enterPressed = false;
        }
    }

    private void resetKeys() {
        keyH.qPressed = false;
        keyH.enterPressed = false;
        keyH.upPressed = false;
        keyH.downPressed = false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (background != null) {
            gc.drawImage(background, 0, 0, gp.getWidth(), gp.getHeight());
        }

        gc.setFont(fantasyFont);
        for (StageButton stageButton : stageButtons) {
            stageButton.draw(gc, chestImage, keyImage);
        }
    }
}
