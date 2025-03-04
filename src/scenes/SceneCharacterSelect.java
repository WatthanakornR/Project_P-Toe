package scenes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;
import main.KeyHandler;

import java.util.HashMap;

public class SceneCharacterSelect extends Scene {
    private GamePanel gp;
    private KeyHandler keyH;
    private Image background;

    private HashMap<String, Image[]> characters = new HashMap<>();
    private HashMap<String, Integer> characterOffsets = new HashMap<>();
    private HashMap<String, Integer> characterScales = new HashMap<>();

    private String[] characterNames = {"assassin", "knight", "wizard", "samurai", "warrior"};
    private int selectedCharacterIndex = 0;

    private int animationFrame = 0;
    private int animationCounter = 0;
    private final int animationSpeed = 10;

    private boolean characterSelected = false;

    public SceneCharacterSelect(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        loadBackground();
        loadAllCharacterFrames();
        setCharacterOffsets();
        setCharacterScales();
    }

    private void loadBackground() {
        background = new Image(getClass().getResourceAsStream("/assets/backgrounds/character_select.png"));
    }

    private void loadAllCharacterFrames() {
        for (String character : characterNames) {
            characters.put(character, loadCharacterFrames(character));
        }
    }

    private Image[] loadCharacterFrames(String characterName) {
        int frameCount = 8;
        Image[] frames = new Image[frameCount];

        for (int i = 1; i <= frameCount; i++) {
            frames[i - 1] = new Image(getClass().getResourceAsStream(
                "/assets/characters/" + characterName + "_frames/" + characterName + "_frame_" + i + ".png"
            ));
        }
        return frames;
    }

    private void setCharacterOffsets() {
        characterOffsets.put("assassin", 110);
        characterOffsets.put("knight", -45);
        characterOffsets.put("wizard", 70);
        characterOffsets.put("samurai", 100);
        characterOffsets.put("warrior", 70);
    }

    private void setCharacterScales() {
        characterScales.put("assassin", 6);
        characterScales.put("knight", 6);
        characterScales.put("wizard", 4);
        characterScales.put("samurai", 6);
        characterScales.put("warrior", 7);
    }

    @Override
    public void update() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            animationFrame = (animationFrame + 1) % characters.get(getSelectedCharacter()).length;
            animationCounter = 0;
        }

        boolean characterChanged = false;

        // ตรวจสอบปุ่มซ้ายและขวาเพื่อเปลี่ยนตัวละคร
        if (keyH.leftPressed) {
            selectedCharacterIndex = (selectedCharacterIndex - 1 + characterNames.length) % characterNames.length;
            keyH.leftPressed = false;  // รีเซ็ตปุ่มซ้าย
            characterChanged = true;  // เมื่อมีการเปลี่ยนตัวละคร
        }

        if (keyH.rightPressed) {
            selectedCharacterIndex = (selectedCharacterIndex + 1) % characterNames.length;
            keyH.rightPressed = false;  // รีเซ็ตปุ่มขวา
            characterChanged = true;  // เมื่อมีการเปลี่ยนตัวละคร
        }

        // เมื่อมีการเปลี่ยนแปลงตัวละคร รีเฟรชหน้าจอ
        if (characterChanged) {
            System.out.println("🔄 Character changed to: " + getSelectedCharacter());
            gp.draw();  // รีเฟรชหน้าจอ
            gp.sceneManager.update(); // อัปเดต SceneManager
        }

        // ถ้ากดปุ่ม X ให้เลือกตัวละคร
        if (keyH.xPressed) {  // เปลี่ยนจาก enterPressed เป็น xPressed
            characterSelected = true;
            String selectedChar = getSelectedCharacter();
            System.out.println("✅ Selected Character: " + selectedChar);

            gp.setSelectedCharacter(selectedChar);  // เลือกตัวละคร
            gp.sceneManager.setScene(SceneManager.MAP_SCENE);  // เปลี่ยนไปที่ MAP_SCENE
            gp.draw();  // รีเฟรชหน้าจอเมื่อเปลี่ยนฉาก

            keyH.xPressed = false;  // รีเซ็ตปุ่ม X
        }

        // กดปุ่ม Q เพื่อกลับไปที่ MAP_SCENE
        if (keyH.qPressed) {
            System.out.println("🔄 Q Pressed: Switching to MAP_SCENE");
            gp.sceneManager.setScene(SceneManager.MAP_SCENE);
            gp.draw();  // รีเฟรชหน้าจอเมื่อเปลี่ยนฉาก

            keyH.qPressed = false;  // รีเซ็ตปุ่ม Q
            keyH.xPressed = false;  // รีเซ็ตปุ่ม X
            keyH.leftPressed = false;  // รีเซ็ตปุ่ม Left
            keyH.rightPressed = false;  // รีเซ็ตปุ่ม Right
            keyH.upPressed = false;  // รีเซ็ตปุ่ม Up
            keyH.downPressed = false;  // รีเซ็ตปุ่ม Down
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight);

        Image[] frames = characters.get(getSelectedCharacter());
        if (frames.length == 0) return;

        int originalWidth = (int) frames[0].getWidth();
        int originalHeight = (int) frames[0].getHeight();

        int scale = characterScales.getOrDefault(getSelectedCharacter(), 4);
        int scaledWidth = originalWidth * scale;
        int scaledHeight = originalHeight * scale;

        int screenX = gp.screenWidth / 2 - scaledWidth / 2;
        int yOffset = characterOffsets.getOrDefault(getSelectedCharacter(), 0);
        int screenY = gp.screenHeight / 2 - scaledHeight / 2 + yOffset;

        gc.drawImage(frames[animationFrame], screenX, screenY, scaledWidth, scaledHeight);
    }

    private String getSelectedCharacter() {
        return characterNames[selectedCharacterIndex];
    }
}
