package entity;

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
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
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
            checkCheckpoint2();
        }

        if (keyH.shiftPressed) {
            speed = 8; // เพิ่มความเร็วถ้ากด Shift
        } else {
            speed = 4; // กลับมาความเร็วปกติ
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
        int checkpointX = gp.TILE_SIZE * 10;
        int checkpointY = gp.TILE_SIZE * 10;
        int checkpointSize = gp.TILE_SIZE; 

        Rectangle checkpointArea = new Rectangle(checkpointX, checkpointY, checkpointSize, checkpointSize);
        Rectangle playerHitbox = new Rectangle(worldX, worldY, gp.TILE_SIZE, gp.TILE_SIZE);

        if (playerHitbox.getBoundsInLocal().intersects(checkpointArea.getBoundsInLocal())) {
            System.out.println("🏁 ผู้เล่นถึง Checkpoint! เปลี่ยนเป็น Scene เลือกด่าน");
            gp.sceneManager.setScene(SceneManager.STAGE_SCENE);
        }
    }

    public void checkCheckpoint2() {
        int checkpointX = gp.TILE_SIZE * 24;
        int checkpointY = gp.TILE_SIZE * 40;
        int checkpointSize = gp.TILE_SIZE;

        Rectangle checkpointArea = new Rectangle(checkpointX, checkpointY, checkpointSize, checkpointSize);
        Rectangle playerHitbox = new Rectangle(worldX, worldY, gp.TILE_SIZE, gp.TILE_SIZE);

        System.out.println("Player Position: (" + worldX + ", " + worldY + ")");
        System.out.println("Checkpoint 2 Position: (" + checkpointX + ", " + checkpointY + ")");
        System.out.println("Checking collision...");

        if (playerHitbox.getBoundsInLocal().intersects(checkpointArea.getBoundsInLocal())) {
            System.out.println("🏁 ผู้เล่นถึง Checkpoint 2! เปลี่ยนเป็น Scene เลือกตัวละคร");
            gp.sceneManager.setScene(SceneManager.CHARACTER_SELECT_SCENE);
        } else {
            System.out.println("ยังไม่ชน Checkpoint 2");
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
}
