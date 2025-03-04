package entity;

import entity.unit.Unit_Player;
import entity.base.Skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import main.GamePanel;
import main.KeyHandler;
import scenes.SceneManager;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    
    private Unit_Player unitPlayer; 
    private boolean nearCheckpoint = false; // 🔥 เช็คว่าผู้เล่นอยู่ใกล้จุด Checkpoint หรือไม่

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.screenX = gp.screenWidth / 2 - gp.TILE_SIZE / 2;
        this.screenY = gp.screenHeight / 2 - gp.TILE_SIZE / 2;
        
        this.solidArea = new Rectangle(8, 16, 32, 32);
        this.solidAreaDefaultX = (int) this.solidArea.getX();
        this.solidAreaDefaultY = (int) this.solidArea.getY();
        
        setDefaultValues();
        loadPlayerImages();

        this.unitPlayer = new Unit_Player("Hero", 1, 100, 20, 5, null);
    }

    public void setDefaultValues() {
        this.worldX = gp.TILE_SIZE * 23;
        this.worldY = gp.TILE_SIZE * 21;
        this.speed = 4;
        this.direction = "down";
    }

    private void loadPlayerImages() {
        this.up1 = loadImage("/player/down_1.png");
        this.up2 = loadImage("/player/down_3.png");
        this.down1 = loadImage("/player/up_1.png");
        this.down2 = loadImage("/player/up_3.png");
        this.left1 = loadImage("/player/left_1.png");
        this.left2 = loadImage("/player/left_2.png");
        this.right1 = loadImage("/player/right_1.png");
        this.right2 = loadImage("/player/right_2.png");
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    public void update() {
        boolean moving = keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed;

        if (moving) {
            if (keyH.upPressed) direction = "up";
            if (keyH.downPressed) direction = "down";
            if (keyH.leftPressed) direction = "left";
            if (keyH.rightPressed) direction = "right";

            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            if (!collisionOn) move();
            
            spriteCounter++;
            if (spriteCounter > 12) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }

            checkCheckpoint();
        }

        if (keyH.shiftPressed) {
            speed = 8; 
        } else {
            speed = 4; 
        }

        // 🔥 Debugging จุดเช็ค
        System.out.println("Near Checkpoint: " + nearCheckpoint);
        System.out.println("G Pressed: " + keyH.gPressed);

        // 🔥 เปลี่ยนฉากเมื่ออยู่ใน Checkpoint และกดปุ่ม "G"
        if (nearCheckpoint && keyH.gPressed) {
            System.out.println("✅ เข้าฉากใหม่!");
            enterScene();
        }
    }

    private void move() {
        switch (direction) {
            case "up": worldY -= speed; break;
            case "down": worldY += speed; break;
            case "left": worldX -= speed; break;
            case "right": worldX += speed; break;
        }
    }

    public void checkCheckpoint() {
        int checkpoint1X = gp.TILE_SIZE * 7;
        int checkpoint1Y = gp.TILE_SIZE * 6;
        int checkpoint2X = gp.TILE_SIZE * 15;
        int checkpoint2Y = gp.TILE_SIZE * 7;
        int checkpointSize = gp.TILE_SIZE; 

        Rectangle checkpoint1 = new Rectangle(checkpoint1X, checkpoint1Y, checkpointSize, checkpointSize);
        Rectangle checkpoint2 = new Rectangle(checkpoint2X, checkpoint2Y, checkpointSize, checkpointSize);
        Rectangle playerHitbox = new Rectangle(worldX, worldY, gp.TILE_SIZE, gp.TILE_SIZE);

        // 🔥 เช็คว่าผู้เล่นอยู่ใน Checkpoint หรือไม่
        if (playerHitbox.getBoundsInLocal().intersects(checkpoint1.getBoundsInLocal())) {
            nearCheckpoint = true;
        } else if (playerHitbox.getBoundsInLocal().intersects(checkpoint2.getBoundsInLocal())) {
            nearCheckpoint = true;
        } else {
            nearCheckpoint = false;
        }
    }

    private void enterScene() {
        System.out.println("🚀 กำลังเปลี่ยนฉาก...");
        
        if (nearCheckpoint) {
            if (worldX >= gp.TILE_SIZE * 7 && worldX <= gp.TILE_SIZE * 8 &&
                worldY >= gp.TILE_SIZE * 6 && worldY <= gp.TILE_SIZE * 7) {
                System.out.println("🏁 ผู้เล่นกด G ที่ Checkpoint! เปลี่ยนเป็น Scene เลือกด่าน");
                gp.sceneManager.setScene(SceneManager.STAGE_SCENE);
            } else if (worldX >= gp.TILE_SIZE * 15 && worldX <= gp.TILE_SIZE * 16 &&
                       worldY >= gp.TILE_SIZE * 7 && worldY <= gp.TILE_SIZE * 8) {
                System.out.println("🏁 ผู้เล่นกด G ที่ Checkpoint 2! เปลี่ยนเป็น Scene เลือกตัวละคร");
                gp.sceneManager.setScene(SceneManager.CHARACTER_SELECT_SCENE);
            } else {
                System.out.println("⚠ พิกัดไม่ตรงกับ Checkpoint!");
            }
        } else {
            System.out.println("⚠ ไม่ได้อยู่ใน Checkpoint!");
        }
    }

    public void draw(GraphicsContext gc) {
        Image image = null;
        switch (direction) {
            case "up": image = (spriteNum == 1) ? up1 : up2; break;
            case "down": image = (spriteNum == 1) ? down1 : down2; break;
            case "left": image = (spriteNum == 1) ? left1 : left2; break;
            case "right": image = (spriteNum == 1) ? right1 : right2; break;
        }
        gc.drawImage(image, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE);
    }

    public Unit_Player getUnitPlayer() {
        return unitPlayer;
    }

    public void setSkill(Skill skill) {
        this.unitPlayer.setSkill(skill);
    }
}
